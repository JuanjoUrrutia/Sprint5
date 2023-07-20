<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>CAPACITACION GUARDADA EN LA BASE DE DATOS (placeholder)</p>
<p>Los datos de la capacitacion son:</p>
<p>Título:  <%= request.getParameter("titulo") %></p>
<p>Descripción:  <%= request.getParameter("descripcion") %></p>
<p>Fecha:  <%= request.getParameter("fecha") %></p>
<p>Hora:  <%= request.getParameter("hora") %></p>
<p>Lugar:  <%= request.getParameter("lugar") %></p>


</body>
</html>