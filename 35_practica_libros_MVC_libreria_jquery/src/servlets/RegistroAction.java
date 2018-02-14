package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionUsuarios;

/**
 * Servlet implementation class RegistroAction
 */
@WebServlet("/RegistroAction")
public class RegistroAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String pwd=request.getParameter("password");
		String email=request.getParameter("email");
		int telefono=Integer.parseInt(request.getParameter("telefono"));
		
		
		RequestDispatcher rd;
		GestionUsuarios gusuarios = new GestionUsuarios();
		
		if ( gusuarios.registroUsuario(usuario, pwd, email, telefono)!=null) {
			rd=request.getRequestDispatcher("temas.jsp");//Transfiere una petición a una vista
			
		}else {
			request.setAttribute("mensaje", "Problema al crear el usuario");
			rd=request.getRequestDispatcher("registro.html");//Transfiere una petición a una vista
		}
			
			
			rd.forward(request,response);
			
	}

}
