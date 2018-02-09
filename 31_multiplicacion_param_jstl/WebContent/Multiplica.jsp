<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date,java.util.List" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table border='1'>
<h1> Tabla del ${param.nombre} </h1>
<c:set var=”i”  value="${param.nombre}"/> 
<c:forEach var="con" begin="1" end="${param.nombre}">
	<tr>
	 <td>${con.value} X</td><td>${param.nombre}=</td>${i*con.value}<td></td> 
		</tr>

</c:forEach>
	</table>
</body>
</html>