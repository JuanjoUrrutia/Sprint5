<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Usuario" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
    $("#tabla-usuarios tbody tr").each(function() {
        var rol = $(this).find("td:eq(2)").text(); 
        if (rol === "1") {
            $(this).find("td:eq(2)").text("Cliente");
        } else if (rol === "2") {
            $(this).find("td:eq(2)").text("Profesional");
        } else if (rol === "3") {
            $(this).find("td:eq(2)").text("Administrativo");
        }

        var apellido = $(this).find("td:eq(1)").text();
        if (apellido.trim() === "") {
            $(this).find("td:eq(1)").text("N/A");
        }
        
        var fechaNacimiento = $(this).find("td:eq(4)").text();
        if (fechaNacimiento.trim() === "") {
            $(this).find("td:eq(4)").text("N/A");
        }
        var telefono = $(this).find("td:eq(5)").text();
        if (telefono.trim() === "") {
            $(this).find("td:eq(5)").text("N/A");
        }
        var afp = $(this).find("td:eq(6)").text();
        if (afp.trim() === "") {
            $(this).find("td:eq(6)").text("N/A");
        }
        var sistemaDeSalud = $(this).find("td:eq(7)").text(); 
        if (sistemaDeSalud === "0") {
            $(this).find("td:eq(7)").text("N/A");
        } else if (sistemaDeSalud === "1") {
            $(this).find("td:eq(7)").text("Fonasa");
        } else if (sistemaDeSalud === "2") {
            $(this).find("td:eq(7)").text("Isapre");
        }
        var direccion = $(this).find("td:eq(8)").text();
        if (direccion.trim() === "") {
            $(this).find("td:eq(8)").text("N/A");
        }
        var comuna = $(this).find("td:eq(9)").text();
        if (comuna.trim() === "") {
            $(this).find("td:eq(9)").text("N/A");
        }
        var edad = $(this).find("td:eq(10)").text(); 
        if (edad === "0") {
            $(this).find("td:eq(10)").text("N/A");
        }
        var area = $(this).find("td:eq(11)").text();
        if (area.trim() === "") {
            $(this).find("td:eq(11)").text("N/A");
        }
        var experienciaPrevia = $(this).find("td:eq(12)").text();
        if (experienciaPrevia.trim() === "") {
            $(this).find("td:eq(12)").text("N/A");
        }
        var titulo = $(this).find("td:eq(13)").text();
        if (titulo.trim() === "") {
            $(this).find("td:eq(13)").text("N/A");
        }
        var fechaDeIngreso = $(this).find("td:eq(14)").text();
        if (fechaDeIngreso.trim() === "") {
            $(this).find("td:eq(14)").text("N/A");
        }
    });
});
</script>

</head>
<body>
<%@ include file='/includes/bienvenido.jsp' %>

    <h1>Lista de Usuarios</h1>
<%@ include file='/includes/navbar.jsp' %>
<div class="container">
    <div class="usuarios">
        <table class="table table-striped" id="tabla-usuarios">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Rol</th>
                    <th>Rut</th>
                    <th>Fecha de nacimiento</th>
                    <th>Telefono</th>
                    <th>AFP</th>
                    <th>Sistema de salud</th>
                    <th>Direccion</th>
                    <th>Comuna</th>
                    <th>Edad</th>
                    <th>Area</th>
                    <th>Experiencia Previa</th>
                     <th>Título</th>
                    <th>Fecha de Ingreso</th>

                    
                </tr>
            </thead>
            <tbody>
                            <% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios"); %>
                <% for (Usuario usuario : usuarios) { %>
                    <tr>
                        <td><%= usuario.getNombre() %></td>
                        <td><%= usuario.getApellido() != null ? usuario.getApellido() : "N/A" %></td>
                        <td><%= usuario.getRol() %></td>
                        <td><%= usuario.getRut() %></td>
                        <td><%= usuario.getFechaNacimiento() != null ? usuario.getFechaNacimiento() : "N/A" %></td>
                        <td><%= usuario.getTelefono() != null ? usuario.getTelefono() : "N/A" %></td>
                        <td><%= usuario.getAfp() != null ? usuario.getAfp() : "N/A" %></td>
                        <td><%= usuario.getSistemaDeSalud() %></td>
                        <td><%= usuario.getDireccion() != null ? usuario.getDireccion() : "N/A" %></td>
                        <td><%= usuario.getComuna() != null ? usuario.getComuna() : "N/A" %></td>
                        <td><%= usuario.getEdad() %></td>
                        <td><%= usuario.getArea() != null ? usuario.getArea() : "N/A" %></td>
                        <td><%= usuario.getExperienciaPrevia() != null ? usuario.getExperienciaPrevia() : "N/A" %></td>
                        <td><%= usuario.getTitulo() != null ? usuario.getTitulo() : "N/A" %></td>
                        <td><%= usuario.getFechaIngreso() != null ? usuario.getFechaIngreso() : "N/A" %></td>
                         <td>
                            <a href="EditarUsuario?id=<%= usuario.getId() %>" class="btn btn-primary btn-sm">Editar</a>
                            <a href="BorrarUsuario?id=<%= usuario.getId() %>" class="btn btn-danger btn-sm">Eliminar</a>
                        </td>
                        
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
