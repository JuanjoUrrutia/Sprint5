<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuario</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            // Ocultar los campos adicionales al inicio
            $("#camposCliente").hide();
            $("#camposProfesional").hide();
            $("#camposAdministrativo").hide();
            
            // Mostrar u ocultar los campos adicionales al cambiar la selección
            $("input[name='tipoUsuario']").click(function() {
                var selectedValue = $(this).val();
                
                // Ocultar todos los campos adicionales
                $("#camposCliente").hide();
                $("#camposProfesional").hide();
                $("#camposAdministrativo").hide();
                
                // Mostrar los campos adicionales correspondientes a la opción seleccionada
                if (selectedValue === "1") {
                    $("#camposCliente").show();
                } else if (selectedValue === "2") {
                    $("#camposProfesional").show();
                } else if (selectedValue === "3") {
                    $("#camposAdministrativo").show();
                }
                
                // Actualizar el valor del campo oculto con el valor del rol seleccionado (convertido a número)
                $("#rol").val(Number(selectedValue));
            });
            // Validaciones de campos
            // Manejar el envío del formulario
            $('#formularioRegistro').submit(function(event) {
              // Evitar que se envíe el formulario por defecto
              event.preventDefault();
              
              // Realizar validaciones
              var username = $('#username').val();
              var password = $('#password').val();
              var password2 = $('#confirmarPassword').val();
              var rut = $('#rut').val();
              var apellido = $('#apellido').val();
              var afp = $('#afp').val();
              var direccion = $('#direccion').val();
              var comuna = $('#comuna').val();
              var edad = $('#edad').val();
              var titulo = $('#titulo').val();
              var area = $('#area').val();
              var experienciaPrevia = $('#experienciaPrevia').val();
              var sistemaDeSalud = $('#sistemaDeSalud').val();

              
              // Verificar longitud de campos
              
                if (nombre.length > 50 || nombre.length < 10) {
                alert('El nombre debe tener entre 10 y 50 caracteres.');
                return false;
              }
              
                if (password !== password2) {
                    alert('Las contraseñas no coinciden.');
                    return false;
                  }
                
               rut = rut.replace(/\./g, '').replace('-', '');
               var rutNumber = parseInt(rut);
               if (rutNumber >= 100000000){
                   alert('El rut debe ser menor a 99.999.999.');
                   return false;
               }
               if (apellido.length > 30) {
                   alert('El apellido debe menos de 30 caracteres.');
                   return false;
                 }
               if (afp.length > 30) {
                   alert('La AFP debe tener menos de 30 caracteres.');
                   return false;
                 }
               if (direccion.length > 70) {
                   alert('La dirección debe tener menos de 70 caracteres.');
                   return false;
                 }
               if (comuna.length > 50) {
                   alert('La comuna debe tener menos de 50 caracteres.');
                   return false;
                 }
               if (edad > 150) {
                   alert('La edad debe ser menor a 150 años}.');
                   return false;
                 }
               if (titulo.length > 50) {
                   alert('El título debe tener menos de 50 caracteres.');
                   return false;
                 }
               if (area.length > 20) {
                   alert('El área debe tener menos de 20 caracteres.');
                   return false;
                 }
               if (experienciaPrevia.length > 100) {
                   alert('La experiencia previa debe tener menos de 100 caracteres.');
                   return false;
                 }
              	      // Enviar el formulario si todas las validaciones pasaron
              	 alert('Usuario registrado.');
              	      this.submit();
                 });
        });
    </script>
</head>
<body>
<%@ include file='/includes/bienvenido.jsp' %>
    <h1>Registro de Usuario</h1>
<%@ include file='/includes/navbar.jsp' %>
<div class="container mt-4">
     <form action="Registro" id="formularioRegistro" method="post">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="username">Usuario:</label>
            <input type="text" id="username" name="username" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="confirmarPassword">Confirmar Contraseña:</label>
            <input type="password" id="confirmarPassword" name="confirmarPassword" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="rut">Rut:</label>
            <input type="text" id="rut" name="rut" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="fechaNacimiento">Fecha de nacimiento:</label>
            <input type="date" id="fechaNacimiento" name="fechaNacimiento" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="tipoUsuario">Tipo de Usuario:</label>
            <div class="form-check">
                <input type="radio" id="cliente" name="tipoUsuario" value="1" class="form-check-input" required>
                <label class="form-check-label" for="cliente">Cliente</label>
            </div>
            <div class="form-check">
                <input type="radio" id="administrativo" name="tipoUsuario" value="2" class="form-check-input" required>
                <label class="form-check-label" for="profesional">Profesional</label>
            </div>	
            <div class="form-check">
                <input type="radio" id="profesional" name="tipoUsuario" value="3" class="form-check-input" required>
                <label class="form-check-label" for="administrativo">Administrativo</label>
            </div>
        </div>
        <div class="form-group" id="camposCliente">
            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido" class="form-control"><br>

            <label for="telefono">Teléfono:</label>
            <input type="tel" id="telefono" name="telefono" class="form-control"><br>

            <label for="afp">AFP:</label>
            <input type="text" id="afp" name="afp" class="form-control"><br>

            <label for="sistemaDeSalud">Sistema de Salud:</label>
            <select id="sistemaDeSalud" name="sistemaDeSalud" class="form-control">
                            <option value="1">Fonasa</option>
                <option value="2">Isapre</option>
            </select><br>

            <label for="direccion">Dirección:</label>
            <input type="text" id="direccion" name="direccion" class="form-control"><br>

            <label for="comuna">Comuna:</label>
            <input type="text" id="comuna" name="comuna" class="form-control"><br>

            <label for="edad">Edad:</label>
            <input type="number" id="edad" name="edad" class="form-control"><br>
        </div>

        <div class="form-group" id="camposProfesional">
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" class="form-control"><br>

            <label for="fechaIngreso">Fecha de Ingreso:</label>
            <input type="date" id="fechaIngreso" name="fechaIngreso" class="form-control"><br>
        </div>

        <div class="form-group" id="camposAdministrativo">
            <label for="area">Área:</label>
            <input type="text" id="area" name="area" class="form-control"><br>

            <label for="experienciaPrevia">Experiencia Previa:</label>
            <input type="text" id="experienciaPrevia" name="experienciaPrevia" class="form-control"><br>
        </div>

        <input type="hidden" id="rol" name="rol">

        <input type="submit" value="Registrarse" class="btn btn-primary">
    </form>
</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    
</body>
</html>