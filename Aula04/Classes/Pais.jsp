<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="model.Pais" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>País</title>
</head>
<body>
	<%Pais pais = (Pais)request.getAttribute("pais"); %>
	Id: <%=pais.getId() %><br>
	Nome: <%=pais.getNome() %><br>
	Fone: <%=pais.getPopulacao() %><br>
	E-mail: <%=pais.getArea() %><br>
</body>
</html>