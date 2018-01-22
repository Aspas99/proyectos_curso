package principal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.Venta;


public class GestionVentas {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		
	}	
	
	
	public void registrarVentas(Venta v) {
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas", "root", "root");) {
			
			String sql="Insert into ventas(idcliente,idLibro,idFecha) values(?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1,v.getIdCliente());
			ps.setInt(2,v.getIdLibro());
			java.sql.Date datesql=new java.sql.Date(v.getFecha().getTime());
			ps.setDate(3,datesql );
			
			ps.execute();//en este caso no se pasa como parametro la query en el string
			
						
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Venta> recuperarVentas(){
		ArrayList<Venta> listaVentas=new ArrayList<>();
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas", "root", "root");) {
			 Statement st=cn.createStatement();

			String sql="select * from contactos";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				java.util.Date fechautil=new java.util.Date(rs.getDate("fecha").getTime());
				listaVentas.add(new Venta(rs.getInt("idVenta"),rs.getInt("idCliente")
						,rs.getInt("idLibro"),fechautil));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return listaVentas;
	}
}
