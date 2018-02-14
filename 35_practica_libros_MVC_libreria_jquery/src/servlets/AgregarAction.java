package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import modelo.GestionLibros;

/**
 * Servlet implementation class AgregarAction
 */
@WebServlet("/AgregarAction")
public class AgregarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtenemos el carrito del objeto HttpSession		
		List<Libro> libros=(List<Libro>)request.getSession().getAttribute("carrito");
		Libro l=null;
		//Agregaremos al carrito el libro 
		GestionLibros glibros=new GestionLibros();
		l=glibros.buscarLibro(Integer.parseInt(request.getParameter("isbn")));
		if (libros==null) {
			libros=new ArrayList<>();
		}
		libros.add(l);
		for (Libro li:libros) {
			System.out.println("Libro:" + li.getTitulo());
		}
		//Actualizamos el atributo carrito con la lista de los libros
		request.getSession().setAttribute("carrito", libros);
		//Obtener el parametro de tema de la lista de libros para volver a la misma lista desde donde se llamo
		
		RequestDispatcher rd;
		System.out.print("idTema:" +request.getParameter("idTema"));
		rd=request.getRequestDispatcher("LibrosAction?idTema=" + request.getParameter("idTema"));//Transfiere una petición a una vista
		
		rd.forward(request,response);
		
	}

}
