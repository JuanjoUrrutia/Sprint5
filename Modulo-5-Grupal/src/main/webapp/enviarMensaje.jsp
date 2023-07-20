<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacto</title>
    <style>
            h1 {
            color: #333;
        }
    </style>
</head>
<body>
    <h1>Contacto</h1>
    <p>Estimado <%= request.getParameter("nombre") %>, su mensaje fue enviado a alguien!</p>
    <br>
    <p>(Página placeholder)</p>
</body>
</html>