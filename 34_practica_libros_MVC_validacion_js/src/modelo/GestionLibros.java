package modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Libro;
import beans.Tema;

public class GestionLibros {
	Statement st;
	String sql;

	private DataSource ds;
	
	public GestionLibros() {
		try {//conectamos con la entrada del sistema de directorios 
			Context ctx=new InitialContext();
			//buscamos el datasource
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Tema seleccionTema(String tema) {
		Tema  t=null;
		
		try (Connection cn=ds.getConnection()) {
			
			String sql="select * from temas where tema=?" ;
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1,tema);
		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				t=new Tema(rs.getInt("idTema"),rs.getString("tema")); 
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return t;
		
	}

	public List<Tema> verTemas(){
		Tema t=null;
		ArrayList<Tema> temas=null;
		try (Connection cn=ds.getConnection()) {
			
			String sql="select * from temas" ;
			PreparedStatement ps =cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
				temas=new ArrayList<>();
		
				while (rs.next()) {
					t=new Tema(rs.getInt("idTema"),rs.getString("tema"));
					temas.add(t);
				}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return temas;
		
	}
	
	public List<Libro> verLibrosporTema(){
		Libro l=null;
		ArrayList<Libro> libros=null;
		
		
		try (Connection cn=ds.getConnection()) {
			
			String sql="select * from libros" ;
			PreparedStatement ps =cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
				libros=new ArrayList<>();
				while (rs.next()){
					//int isbn, String titulo, String autor, double precio, int paginas, int idTema
					l=new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("autor")
							,rs.getDouble("precio"),rs.getInt("paginas"),rs.getInt("idTema"));
					libros.add(l);
				}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return libros;
	}
	
	
	public List<Libro> verLibrosporTema(int idTema){
		Libro l=null;
		ArrayList<Libro> libros=null;
		
		
		try (Connection cn=ds.getConnection()) {
			
			String sql="select * from libros where idTema=?" ;
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setInt(1,idTema);
			ResultSet rs = ps.executeQuery();
			
				libros=new ArrayList<>();
				while (rs.next()){
					//int isbn, String titulo, String autor, double precio, int paginas, int idTema
					l=new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("autor")
							,rs.getDouble("precio"),rs.getInt("paginas"),rs.getInt("idTema"));
					libros.add(l);
				}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return libros;
	}
	
	public Libro buscarLibro(int isbn) {
		
		Libro l=null;
		
		try (Connection cn=ds.getConnection()) {
			
			String sql="select * from libros where isbn=? LIMIT 1" ;
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setInt(1,isbn);
			ResultSet rs = ps.executeQuery();
			
				while (rs.next()){
					//int isbn, String titulo, String autor, double precio, int paginas, int idTema
					l=new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("autor")
							,rs.getDouble("precio"),rs.getInt("paginas"),rs.getInt("idTema"));
					
				}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return l;
		
		
	}
	
	private int buscarTema(String tema) {
		int idTema=-1;
		
		try (Connection cn=ds.getConnection()) {
			
			String sql="select * from temas where tema=? limit 1" ;
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1,tema);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				idTema=rs.getInt("tema");
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return idTema;
	}
}
