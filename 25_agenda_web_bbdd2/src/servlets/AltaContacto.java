package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contactos.GestionContactos;


/**
 * Servlet implementation class AltaContacto
 */
@WebServlet("/AltaContacto")
public class AltaContacto extends HttpServlet {
  
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nombre=request.getParameter("nombre");
	     String email=request.getParameter("email");
	     int telefono=Integer.parseInt(request.getParameter("telefono"));
	     
	     RequestDispatcher rd;
			
			GestionContactos gusuarios= new GestionContactos() ;
			
			gusuarios.alta(nombre, email, telefono);
			
			rd=request.getRequestDispatcher("inicio.html");
			rd.forward(request,response);
	}

}
