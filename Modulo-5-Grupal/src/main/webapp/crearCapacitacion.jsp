<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Crear Capacitación</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   
    
</head>
<body>
<%@ include file='/includes/bienvenido.jsp' %>

    <h1>Crear Capacitación</h1>
    
<%@ include file='/includes/navbar.jsp' %>


<div class="container">
  <div class="row">
    <div class="col-md-6">
      <div class="crear-capacitacion">
        <form id="formularioCapacitacion" action="CrearCapacitacion" method="post" >
          <div class="form-group">
            <label for="titulo">Título:</label>
            <input type="text" class="form-control" id="titulo" name="titulo" required>
          </div>

          <div class="form-group">
            <label for="descripcion">Descripción:</label>
            <textarea class="form-control" id="descripcion" name="descripcion" required></textarea>
          </div>

          <div class="form-group">
            <label for="fecha">Fecha:</label>
            <input type="date" class="form-control" id="fecha" name="fecha" required>
          </div>

          <div class="form-group">
            <label for="hora">Hora:</label>
            <input type="time" class="form-control" id="hora" name="hora" required>
          </div>

          <div class="form-group">
            <label for="lugar">Lugar:</label>
            <input type="text" class="form-control" id="lugar" name="lugar" required>
          </div>

          <input type="submit" class="btn btn-primary" value="Guardar Capacitación">
        </form>
      </div>
    </div>
  </div>
</div>

<script>
$(document).ready(function() {
  // Manejar el envío del formulario
  $('#formularioCapacitacion').submit(function(event) {
    // Evitar que se envíe el formulario por defecto
    event.preventDefault();
    
    // Realizar validaciones
    var titulo = $('#titulo').val();
    var descripcion = $('#descripcion').val();
    var hora = $('#hora').val();
    var lugar = $('#lugar').val();
    
    
    // Verificar longitud de campos
    
      if (titulo.length > 45) {
      alert('Ingrese un título menor o igual a 45 caracteres.');
      return false;
    }
    
      if (descripcion.length > 200) {
          alert('Ingrese una descripción menor o igual a 200 caracteres.');
          return false;
        }
      // Obtener la fecha actual
      var fechaActual = new Date();
      
      // Obtener los valores de la fecha ingresada por el usuario
      var fechaIngresada = new Date($('#fecha').val());
      
      // Obtener el año actual y establecer el límite máximo (2025)
       var yearActual = fechaActual.getFullYear();
      	var yearLimite = 2025;
       
       // Validar si la fecha ingresada es posterior al día de hoy y no excede el año 2025
       
       if (fechaIngresada < fechaActual || fechaIngresada.getFullYear() >= yearLimite) {
		
    	      // La fecha no es válida
    	      alert('La fecha ingresada no es válida.');
    	      return false;
    	      // Detener el envío del formularioS
    	      };
    	      // Enviar el formulario si todas las validaciones pasaron
    	      alert('La capacitación fue registrada.');

    	      this.submit();
    	      //
       });
});
</script>
</body>
</html>
