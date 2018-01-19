package contactos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class GestionContactos {

	private String nombre;
	private String email;
	private int telefono;
	
	Statement st;
	String sql;
	
	
		
	
	public void alta(String nombre,String email,int telefono)  {
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root"))
 			{
		/*	
			this.st=cn.createStatement();
			sql="Insert into contactos(nombre,email,telefono) values('" +  nombre + "','" + email + "'," +telefono+")";
			st.execute(sql);
		*/
			//consultas preparadas
			String sql="Insert into contactos(nombre,email,telefono) values(?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1,nombre);
			ps.setString(2,email);
			ps.setInt(3, telefono);
			ps.execute();//en este caso no se pasa como parametro la query en el string
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}/*finally {
			try {
				if (cn!=null){ //Para que no genera un NullPointerException 
				cn.close();
				}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	public void eliminar(String email) {
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");) {
			
			this.st=cn.createStatement();
			
			sql="delete from contactos where email='" + email +"'";
			st.execute(sql);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}/*finally {
			try {
				if (cn!=null){ //Para que no genera un NullPointerException 
				cn.close();
				}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
		
	}
	
	
}
