package modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;



public class Movimiento extends Cuenta {
	private int idMovimiento;
	private int idCuenta;
	private double Cantidad;
	private Date fecha;
	String operacion;
	


 public Movimiento(int idMovimiento,int idCuenta, double saldo, double cantidad, Date fecha,
			String operacion) {
		super(idCuenta, saldo);
		this.idMovimiento = idMovimiento;
		this.idCuenta = idCuenta;
		Cantidad = cantidad;
		this.fecha = fecha;
		this.operacion = operacion;
		
	}
 public Movimiento(int idMovimiento,int idCuenta,double cantidad, Date fecha,String operacion) {
		super(idCuenta);
		this.idMovimiento = idMovimiento;
		this.idCuenta = idCuenta;
		Cantidad = cantidad;
		this.fecha = fecha;
		this.operacion = operacion;
		
	}
 
public static  int last() {
	int last=0;
	try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bancabd", "root", "root"))
	{	
		String sql="select max(idMovimiento) from movimientos ";
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if (rs.next()) {
			last=rs.getInt(1);
		}
	}catch(SQLException ex) {
			ex.printStackTrace();
	}
	return last;
 }




public void setMovimiento(int idMovimiento, int idCuenta, double cantidad, Date fecha,String operacion) {
	
	try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bancabd", "root", "root"))
	{	
		switch (operacion) {
			case "ingreso":{
				if (cantidad>0) {
					this.ingresar(cantidad);
					this.Cantidad=cantidad;
				}
				break;
			}case "retirada":{
				if ((this.getSaldo(idCuenta)-cantidad)>0 && cantidad>0) {
					this.extraer(cantidad);
					this.Cantidad=cantidad;
				}
				break;
			}
		}
		
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		
		//java.sql.Date fechasql=new java.sql.Date(fecha.getTime());<-Este es el paso que habria que hacerle, no el 
		//SimpleDateFormat ,que en este caso si que se lo ha "tragado" MySQL pero que otras BBDD no tienen porqué 
		//No he considerado autonumerico el idMovimiento , pero se podia haber obviado
		String sql="insert into movimientos(idMovimiento,idCuenta,cantidad,fecha,operacion) values(?,?,?,?,?)";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1,idMovimiento);
		ps.setInt(2,idCuenta);
		ps.setDouble(3, cantidad);
		ps.setString(4, currentTime);
		//ps.setDate(4, fechasql);
		ps.setString(5, operacion);
		ps.execute();//en este caso no se pasa como parametro la query en el string
	}catch(SQLException ex) {
			ex.printStackTrace();
	}
 }


public List<Movimiento> listaMovimientos(int numMovimientos){
	ArrayList<Movimiento> movimientos = new ArrayList<>();
	try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bancabd", "root", "root");) {
		
		Statement st=cn.createStatement();
		
		String sql="select * from movimientos where idCuenta=" + this.idCuenta + " order by idMovimiento desc limit " + numMovimientos ;
		ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				//java.util.Date fechautil=new java.util.Date(rs.getDate("fecha").getTime());//No es necesario 
				//movimientos.add(new Movimiento(rs.getInt("idMovimiento"),rs.getInt("idCuenta")
				//		,rs.getDouble("cantidad"),rs.getDate("fecha"),rs.getString("operacion")));
				movimientos.add(new Movimiento(rs.getInt("idMovimiento"),rs.getInt("idCuenta")
								,rs.getDouble("cantidad"),rs.getTimestamp("fecha"),rs.getString("operacion")));
			}		
		
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	return movimientos;
}
public int getIdMovimiento() {
	return idMovimiento;
}
public int getIdCuenta() {
	return idCuenta;
}
public double getCantidad() {
	return Cantidad;
}
public Date getFecha() {
	return fecha;
}
public String getOperacion() {
	return operacion;
}

public  boolean transferencia(int idCuentaOrigen,int idCuentaDestino,double cantidad) {
	Cuenta origen=null;
	Cuenta destino=null;
	
	boolean resultado=false;
	java.util.Date fecha=new Date();
	Movimiento m1=null,m2=null;
	
	try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bancabd", "root", "root"))
	{	
		origen=new Cuenta(idCuentaOrigen,0);
	    destino=new Cuenta(idCuentaDestino,0);

		double saldoorigen=origen.getSaldo(idCuentaOrigen);
		if (saldoorigen>=cantidad) {
			//java.sql.Date fechasql=new java.sql.Date(fecha.getTime());
			origen.extraer(cantidad);
			destino.ingresar(cantidad);
			m1=new Movimiento(Movimiento.last()+1,idCuentaOrigen,origen.getSaldo(idCuentaOrigen),cantidad,fecha,"transferencia");
			m1.setMovimiento(Movimiento.last()+1, idCuentaOrigen, cantidad, fecha, "transferencia");
			m2=new Movimiento(Movimiento.last()+1,idCuentaDestino,destino.getSaldo(idCuentaDestino),cantidad,fecha,"transferencia");
			m2.setMovimiento(Movimiento.last()+1, idCuentaDestino, cantidad, fecha, "transferencia");
			resultado=true;
			
		}
	}catch(SQLException ex) {
			ex.printStackTrace();
	}
	return resultado;
}


}
