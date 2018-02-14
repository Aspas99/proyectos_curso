package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionLibros;

/**
 * Servlet implementation class LibrosAction
 */
@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			GestionLibros glibros = new GestionLibros();
			
			System.out.println("IdTema:" +  request.getParameter("idTema"));
			int idTema = Integer.parseInt(request.getParameter("idTema"));
			if (idTema!=0) {
				request.setAttribute("libros", glibros.verLibrosporTema(idTema));
			}else {
				request.setAttribute("libros", glibros.verLibrosporTema());
			}
				
			//System.out.println(glibros.verLibrosporTema(idTema).get(1));
			request.getRequestDispatcher("verLibros.jsp").forward(request, response);
	}

}
