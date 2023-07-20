<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contacto</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
</head>
<body>
<%@ include file='/includes/bienvenido.jsp' %>

    <h1>Contacto</h1>
<%@ include file='/includes/navbar.jsp' %>
<div class="container">
  <div class="contact-info">
    <p>Puede ponerse en contacto con nosotros utilizando el siguiente formulario o a través de la información de contacto a continuación:</p>
  </div>

  <div class="row">
    <div class="col-md-6">
      <form id="formularioContacto" action="Contacto" method="post">
        <div class="form-group">
          <label for="nombre">Nombre:</label>
          <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>

        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" class="form-control" id="email" name="email" required>
        </div>

        <div class="form-group">
          <label for="mensaje">Mensaje:</label>
          <textarea class="form-control" id="mensaje" name="mensaje" required></textarea>
        </div>
			<br>
        <input type="submit" class="btn btn-primary" value="Enviar mensaje">
      </form>
    </div>
  </div>
</div>
<script>
$(document).ready(function() {
  // Manejar el envío del formulario
  $('#formularioContacto').submit(function(event) {
    // Evitar que se envíe el formulario por defecto
    event.preventDefault();
    
    // Realizar validaciones
    var nombre = $('#nombre').val();
    var email = $('#email').val();
    var mensaje = $('#mensaje').val();
    
    
    // Verificar longitud de campos
    
      if (nombre.length > 45) {
      alert('Ingrese un nombre menor o igual a 45 caracteres.');
      return false;
    }
    
      if (email.length > 45) {
          alert('Ingrese un correo menor o igual a 45 caracteres.');
          return false;
        }
      
      if (mensaje.length > 200) {
          alert('Ingrese un mensaje menor o igual a 200 caracteres.');
          return false;
        }
    	      // Enviar el formulario si todas las validaciones pasaron
    	 alert('Estimado ' + nombre + ', su mensaje fue enviado al administrador.');

    	      this.submit();
       });
});
</script>
</body>
</html>
