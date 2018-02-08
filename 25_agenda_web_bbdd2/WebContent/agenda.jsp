<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beans.Contacto,contactos.GestionContactos"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agenda de contactos completa</title>
</head>
<body>

<%GestionContactos agenda = new GestionContactos();
if (agenda==null || agenda.recuperarTodos().size()==0){%>
	<jsp:forward page="inicio.html"/>
<%}%>
<center>
<table border=1>
<tr>
<th>Nombre</th><th>Email</th><th>Telefono</th>
</tr>
	<% for(Contacto c:agenda.recuperarTodos()){%>
		 <tr><td><%=c.getNombre() %></td><td><%=c.getEmail() %></td><td><%=c.getTelefono() %></td></tr>
	<%}%>
</table>
<a href="inicio.html" >Volver inicio</a>
</center>
</body>

</html>