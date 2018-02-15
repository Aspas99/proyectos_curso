package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="";
		
		switch(op) {
		case "toLogin":
				url="login.jsp";
				break;
		case "toSeleccion":
				url="seleccion.jsp";
				break;
		case "toNoLogin":
			    url="noLogin.html";
			    break;
		case "toRegistro":
		    	url="registro.html";
		    	break;
		case "toTemas":
				url="temas.jsp";
		    	break;		      
		case "doLogin":
				url="LoginAction";
				break;
		case "doRegistro":
				url="RegistroAction";
				break;
		case "doTemas":
				url="TemasAction";
				break;
		case "doLibros":
				url="LibrosAction";
				break;
		case "doAgregar":
				url="AgregarAction";
				break;
		case "doVentas":
				url="VentasAction";
				break;
		case "doEliminar":
			url="EliminarAction";
			break;	
		}
		request.getRequestDispatcher(url).forward(request, response); //usamos la url para redirigir a la pagina/servlet corresp
	}

}
