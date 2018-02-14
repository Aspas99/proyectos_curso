package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Libro;

public class GestionVentas {

	Statement st;
	String sql;

	private DataSource ds;
	
	public GestionVentas() {
		try {//conectamos con la entrada del sistema de directorios 
			Context ctx=new InitialContext();
			//buscamos el datasource
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public boolean registraCompra(List<Libro> libros,int idCliente) {
			boolean comprado=false;
		try (Connection cn=ds.getConnection()) {	
			String sql="insert into ventas(idCliente,idLibro,fecha) ";
			sql+="values(?,?,?)";
			PreparedStatement ps=cn.prepareStatement(sql);
			for (Libro lib:libros) {
				ps.setInt(1,idCliente);
				ps.setInt(2,lib.getIsbn());
				ps.setTimestamp(3,new java.sql.Timestamp(new java.util.Date().getTime()));
				ps.execute();
			}
			comprado=true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return comprado;
		
	}
}
