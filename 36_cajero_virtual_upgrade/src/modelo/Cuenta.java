package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cuenta {
	// La clase dispone de los atributos
	private int numeroCuenta;
	private double saldo;
	private String tipocuenta;
	
	public Cuenta(int numeroCuenta,double saldo) {
		this.numeroCuenta=numeroCuenta;
		this.saldo=saldo;	
	}
	
	public Cuenta(int numeroCuenta) {
		this.numeroCuenta=numeroCuenta;
	}
	
	public void crearCuenta(int numeroCuenta,double saldo) {
		this.numeroCuenta=numeroCuenta;
		this.saldo=saldo;
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bancabd", "root", "toor"))
		{	
			String sql="insert into cuentas(numeroCuenta,saldo,tipoCuenta) values(?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1,numeroCuenta);
			ps.setDouble(2, saldo);
			ps.setString(3, tipocuenta);
			ps.execute();//en este caso no se pasa como parametro la query en el string
		}catch(SQLException ex) {
				ex.printStackTrace();
		}
	}

	public static Cuenta buscarCuenta(int numeroCuenta) {
		Cuenta c=null;
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bancabd", "root", "toor"))
		{	
			String sql="select * from cuentas where numeroCuenta=" + "'"+numeroCuenta+"'" ;
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if (rs.next()) {
				c=new Cuenta(rs.getInt("numeroCuenta"),rs.getDouble("saldo"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return c;
	}
	public void ingresar(double cant) {
		saldo=this.getSaldo(numeroCuenta);
		saldo+=cant;
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bancabd", "root", "toor"))
		{
		
			String sql="update cuentas set saldo=? where numeroCuenta=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setDouble(1,saldo);
			ps.setInt(2, numeroCuenta);
			ps.execute();//en este caso no se pasa como parametro la query en el string
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void extraer(double cant) {
		saldo=this.getSaldo(numeroCuenta);
		saldo-=cant;
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bancabd", "root", "toor"))
		{
		
			String sql="update cuentas set saldo=? where numeroCuenta=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setDouble(1,saldo);
			ps.setInt(2, numeroCuenta);
			ps.execute();//en este caso no se pasa como parametro la query en el string
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public double getSaldo(int numeroCuenta) {
		double saldo=0.0;
		
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bancabd", "root", "toor"))
		{	
			String sql="select saldo from cuentas where numeroCuenta=" + "'"+numeroCuenta+"'" ;
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if (rs.next()) {
				saldo=rs.getDouble("saldo");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return saldo;
	}
	
	public int getIdCuenta() {
		return numeroCuenta;
	}
	
	

}
