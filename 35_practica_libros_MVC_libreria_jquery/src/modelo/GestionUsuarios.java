package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Cliente;


public class GestionUsuarios {

	Statement st;
	String sql;

	private DataSource ds;
	
	public GestionUsuarios() {
		try {//conectamos con la entrada del sistema de directorios 
			Context ctx=new InitialContext();
			//buscamos el datasource
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean existeUsuario(String usuario) {
		boolean existe=false;
	
		
		try (Connection cn=ds.getConnection()) {
			st=cn.createStatement();
			String sql="select * from clientes where usuario='" + usuario + "'"  ;
			ResultSet rs=st.executeQuery(sql);
			if (rs.next()){
				existe=true;
			}	
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return existe;
	}
	
	public boolean login(String usuario,String clave) {
		boolean res=false;
	
		try (Connection cn=ds.getConnection()) {
			
			String sql="select * from clientes where usuario=? and password=?" ;
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1,usuario);
			ps.setString(2,clave);
			ResultSet rs = ps.executeQuery();
			res=rs.next();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
	public Cliente registroUsuario(String usuario, String pwd,String email,int telefono ) {
		Cliente c=null;
		try (Connection cn=ds.getConnection())
			{
		c=new Cliente(usuario,pwd,email,telefono);
	
		//consultas preparadas
		String sql="Insert into clientes(usuario,password,email,telefono) values(?,?,?,?)";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1,c.getUsuario());
		ps.setString(2,c.getPassword());
		ps.setString(3,c.getEmail());
		ps.setInt(4, c.getTelefono());
		ps.execute();//en este caso no se pasa como parametro la query en el string		
		
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return c;
	}
	
	public int buscaUsuario(String usuario) {
		int idCliente=-1;
	
		
		try (Connection cn=ds.getConnection()) {
			st=cn.createStatement();
			String sql="select * from clientes where usuario='" + usuario + "' LIMIT 1"  ;
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				idCliente=rs.getInt("idCliente");
			}	
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return idCliente;
	}
}
