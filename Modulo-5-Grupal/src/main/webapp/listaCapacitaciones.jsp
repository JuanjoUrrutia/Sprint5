<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Capacitacion" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Capacitaciones</title>
     <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script src="jquery-3.6.4.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
   	
</head>
<body>
<%@ include file='/includes/bienvenido.jsp' %>

    <h1>Lista de Capacitaciones</h1>
<%@ include file='/includes/navbar.jsp' %>


<div class="container">
    <div class="capacitaciones">
        <table class="table table-striped" id="tabla-capacitaciones">
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Lugar</th>
                </tr>
            </thead>
            <tbody>
                            <% List<Capacitacion> capacitaciones = (List<Capacitacion>) request.getAttribute("capacitaciones"); %>
                <% for (Capacitacion capacitacion : capacitaciones) { %>
                    <tr>
                        <td><%= capacitacion.getTitulo() %></td>
                        <td><%= capacitacion.getDescripcion() %></td>
                        <td><%= capacitacion.getFecha() %></td>
                        <td><%= capacitacion.getHora() %></td>
                        <td><%= capacitacion.getLugar() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>

    

</body>
</html>
