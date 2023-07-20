<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="modelo.Usuario" %>

<html>
<head>
    <title>Editar Cliente</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<%@ include file='/includes/bienvenido.jsp' %>
        <h1>Editar Cliente</h1>
<%@ include file='/includes/navbar.jsp' %>
    <div class="container">
        <% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
        <form action="ActualizarUsuario" method="POST">
            <input type="hidden" name="id" value="<%= usuario.getId() %>">
            <div class="form-group">
                <label for="apellido">Apellido:</label>
                <input type="text" class="form-control" name="apellido" value="<%= usuario.getApellido() %>">
            </div>
            <div class="form-group">
                <label for="telefono">Teléfono:</label>
                <input type="text" class="form-control" name="telefono" value="<%= usuario.getTelefono() %>">
            </div>
            <div class="form-group">
                <label for="afp">AFP:</label>
                <input type="text" class="form-control" name="afp" value="<%= usuario.getAfp() %>">
            </div>
<div class="form-group">
    <label for="sistemaDeSalud">Sistema de Salud:</label>
    <select id="sistemaDeSalud" name="sistemaDeSalud" class="form-control">
        <option value="1" <%= usuario.getSistemaDeSalud() == 1 ? "selected" : "" %>>Fonasa</option>
        <option value="2" <%= usuario.getSistemaDeSalud() == 2 ? "selected" : "" %>>Isapre</option>
    </select>
</div>
            <div class="form-group">
                <label for="direccion">Dirección:</label>
                <input type="text" class="form-control" name="direccion" value="<%= usuario.getDireccion() %>">
            </div>
            <div class="form-group">
                <label for="comuna">Comuna:</label>
                <input type="text" class="form-control" name="comuna" value="<%= usuario.getComuna() %>">
            </div>
            <div class="form-group">
                <label for="edad">Edad:</label>
                <input type="number" class="form-control" name="edad" value="<%= usuario.getEdad() %>">
            </div>
            <button type="submit" class="btn btn-primary">Actualizar</button>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
