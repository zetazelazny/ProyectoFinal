<?php
session_start();
include('funciones/config.php');
if(isset($_SESSION['usuario']))
{
	
?>
<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <title>Ingreso de paciente - Integrapp</title>
        <?php require('funciones/headerLogueado.php'); ?>        

<form action="agregar_c.php" method="post">
      
        <h1>Ingreso</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Datos del paciente</legend>
          <label for="nombre">Nombre*:</label>
          <input type="text" id="nombre" name="nombre" required pattern="[A-Za-z0-9_-@-]{1,30}">

          <label for="apellido">Apellido*:</label>
          <input type="text" id="apellido" name="apellido" required pattern="[A-Za-z0-9_-]{1,30}">       

          <label for="edad">Edad*:</label>
          <input type="text" id="edad" name="edad" required pattern="[A-Za-z0-9_-]{1,30}">         
          
          
        </fieldset>        
       
        <button class="ingreso" type="submit" name="agregar">Ingreso</button>
      </form>   

<?php
}
else
{
  echo '<script> window.location="login.php";</script>';
}