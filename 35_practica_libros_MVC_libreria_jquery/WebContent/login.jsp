<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function comprobar(){
	//recogemos los valores de los inputs
	var caja1=document.getElementbyId("us");
	var caja2=document.getElementbyId("pw");
	if (caja1.value=="" || caja2.value==""){
		alert("debe introducir un valor");
		return false;
	}else{
		return true;
	}
	
}


</script>
<title>Insert title here</title>
</head>
<body>
<form action="Controller?op=doLogin" onsubmit="return comprobar();" method="post">
	Introduzca el nombre del usuario: <input id="us" type="text" name="usuario"/><br/><br/>
	Introduzca su clave: <input id="pw" type="password" name="password"/><br/><br/>
	<input type="submit"  value="Enviar" />
</form>
<a href="Controller?op=toRegistro"> Registrese</a>
</body>
</html>