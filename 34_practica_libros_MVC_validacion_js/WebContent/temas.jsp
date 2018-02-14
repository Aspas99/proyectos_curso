<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Tema"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selecciones el tema de la consulta</title>
</head>
<body>
<%List<Tema> temas = (List<Tema>)request.getAttribute("temas");
if (temas==null || temas.size()==0){%>
	<jsp:forward page="Controller?op=toLogin"/>
<%}%> 


<center>
Seleccione su tema</br></br>
    <form  action="Controller?op=doLibros" method="post">
   		<select name="idTema">
			<option value="0">Todos</option>
    		<% for(int i=0;i<temas.size();i++){%>
				 <option value=<%=temas.get(i).getIdTema() %>><%= temas.get(i).getTema()%> </option>
				 	 
			<%}%>
		</select>
		<br/>
		<input type="submit" value="Ver libros"/>
			
	</form>


<a href="Controller?op=toInicio" >Volver inicio</a>
</center>

</body>
</html>