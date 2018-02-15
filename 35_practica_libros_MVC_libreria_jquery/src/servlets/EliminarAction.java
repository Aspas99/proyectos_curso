package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;



@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Libro> libros=(List<Libro>)request.getSession().getAttribute("carrito");
		
		int pos=Integer.parseInt(request.getParameter("pos"));
		libros.remove(pos);
		System.out.println("IdTema:" +  request.getParameter("idTema"));
		//Obtener el parametro de tema de la lista de libros para volver a la misma lista desde donde se llamo
		
		RequestDispatcher rd;
		//Porque no puedes hacerlo con la llamada al controller ?????
		rd=request.getRequestDispatcher("LibrosAction?idTema=" + request.getParameter("idTema"));//Transfiere una petición a una vista
		rd.forward(request,response);
		
		
	}

}
