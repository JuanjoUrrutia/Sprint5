<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="modelo.Usuario" %>

<html>
<head>
    <title>Editar Profesional</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<%@ include file='/includes/bienvenido.jsp' %>
        <h1>Editar Profesional</h1>
<%@ include file='/includes/navbar.jsp' %>
    <div class="container">
        <% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
        <form action="ActualizarUsuario" method="POST">
            <input type="hidden" name="id" value="<%= usuario.getId() %>">

            <div class="form-group">
                            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" class="form-control" value="<%= usuario.getTitulo() %>"><br>

      
            </div>
            <div class="form-group">
                <label for="fechaIngreso">Fecha de Ingreso:</label>
            <input type="date" id="fechaIngreso" name="fechaIngreso" class="form-control" value="<%= usuario.getFechaIngreso() %>"><br>
            </div>
            <button type="submit" class="btn btn-primary">Actualizar</button>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
