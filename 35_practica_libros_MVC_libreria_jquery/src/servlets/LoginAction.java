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
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String clave=request.getParameter("password");
		
		RequestDispatcher rd;
		GestionUsuarios gusuarios = new GestionUsuarios();
		
		//request.getSession().setAttribute("login", gusuarios.login(usuario, clave));
		if ( gusuarios.login(usuario, clave)) {
			rd=request.getRequestDispatcher("TemasAction");//Transfiere una petición a una vista
			int idCliente=gusuarios.buscaUsuario(usuario);
			request.getSession().setAttribute("idCliente", idCliente);//Al hacer login, salvamos un atributo de sesion para identificar al usuario
			
		}else {
			
			rd=request.getRequestDispatcher("registro.html");//Transfiere una petición a una vista
		}
			
			
			rd.forward(request,response);
			
		
		
	}

}
