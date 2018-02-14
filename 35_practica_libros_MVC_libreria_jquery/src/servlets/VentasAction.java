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
import modelo.GestionVentas;

/**
 * Servlet implementation class VentasAction
 */
@WebServlet("/VentasAction")
public class VentasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtenemos el carrito actual, como sólo se llama una vez que se construye la tabla de "agregados" para el carrito
		//sabes que no está sin libros
		List<Libro> libros=(List<Libro>)request.getSession().getAttribute("carrito");
	
		int idCliente=(Integer)request.getSession().getAttribute("idCliente");
		GestionVentas gventas=new GestionVentas();
		gventas.registraCompra(libros, idCliente);
		
		//Obtener el parametro de tema de la lista de libros para volver a la misma lista desde donde se llamo
		
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("Controller?op=doLibros?idTema=" + request.getParameter("idTema"));//Transfiere una petición a una vista
		rd.forward(request,response);
		
	}

}
