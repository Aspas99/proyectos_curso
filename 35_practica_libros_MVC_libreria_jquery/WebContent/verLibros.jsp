<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Libro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de libros por tema</title>
</head>
<body>
<%List<Libro> libros = (List<Libro>)request.getAttribute("libros");
 

if (libros==null || libros.size()==0){%>
	<jsp:forward page="Controller?op=doTemas"/>
<%}%>
<center>
<table border=1>
<tr>
<th>Titulo</th><th>Autor</th><th>Precio</th>
</tr>
	<% for(int i=0;i<libros.size();i++){%>
		 <tr><td><%=libros.get(i).getTitulo() %></td><td><%=libros.get(i).getAutor() %>
		 </td><td><%=libros.get(i).getPrecio() %></td><td>
		 <a href="Controller?op=doAgregar&idTema=<%=libros.get(i).getIdTema()%>&isbn=<%=libros.get(i).getIsbn()%>">Agregar</a></td></tr>
	<%}%>
</table>
<a href="Controller?op=doTemas" >Volver lista libros</a>
</center>


<%List<Libro> carrito =  (List<Libro>)session.getAttribute("carrito");
	if (carrito!=null && carrito.size()>0){
	 %>
	<center>
	<table border=1>
		<th>Titulo</th><th>Autor</th><th>Precio</th>
		
		<%for(int i=0;i<carrito.size();i++){ %>
			
		 	<tr><td><%=carrito.get(i).getTitulo() %></td><td><%=carrito.get(i).getAutor() %>
		 </td><td><%=carrito.get(i).getPrecio() %></td>
		 <td><a href="Controller?op=doEliminar&idTema=<%=carrito.get(i).getIdTema() %>&pos=<%=i%> ">Eliminar</a></td>
		 </tr>
		
		 <%} %>
	</table>
	
	<form action="Controller?op=doVentas&idTema=<%=request.getParameter("idTema") %>" method="post">
	<input type="submit"  value="Comprar" /></form>
	 
	</center>
<%} %>

</body>
</html>