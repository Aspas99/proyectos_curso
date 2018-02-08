package contactos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Contacto;



public class GestionContactos {

	Contacto c=null;
	Statement st;
	String sql;
	
	String user = "root";
	String pwd="root";
	static {
		//cargar el driver en memoria
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	
	public void alta(String nombre,String email,int telefono)  {
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda",user, pwd))
 			{
			c=new Contacto(nombre,email,telefono);
		
			//consultas preparadas
			String sql="Insert into contactos(nombre,email,telefono) values(?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1,c.getNombre());
			ps.setString(2,c.getEmail());
			ps.setInt(3, c.getTelefono());
			ps.execute();//en este caso no se pasa como parametro la query en el string
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void eliminar(String email) {
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", user, pwd);) {
			
			this.st=cn.createStatement();
			
			sql="delete from contactos where email='" + email +"'";
			st.execute(sql);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public List<Contacto> recuperarTodos() {
		
		
		ArrayList<Contacto> contactos = new ArrayList<>();
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", user, pwd);) {
			
			this.st=cn.createStatement();
			
			String sql="select * from contactos";
			ResultSet rs=st.executeQuery(sql);
						
				while (rs.next()) {
					contactos.add(new Contacto(rs.getString("nombre"),rs.getString("email"),rs.getInt("telefono")));
				}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return contactos;
	}
		
}
