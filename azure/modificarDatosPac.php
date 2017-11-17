<?php
session_start();
include('funciones/config.php');
if(!isset($_SESSION['usuario']))
{
	echo '<script> window.location="perfil.php";</script>';
}
else{
  $id_pac = $_GET['id'];
?>

<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <title>Modificación datos paciente - Integrapp</title>
        <?php require('funciones/headerLogueado.php') ?>
        <body>

<?php echo" <form action=modificarDatosPac_c.php?id=".$id_pac." method=post> "?>
      
        <h1>Ingreso</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Datos de paciente</legend>
          <label for="nombre">Nombre*:</label>
          <input type="text" id="nombre" name="nombre" required pattern="[A-Za-z0-9_-@-]{1,30}">

          <label for="apellido">Apellido*:</label>
          <input type="text" id="apellido" name="apellido" required pattern="[A-Za-z0-9_-]{1,30}">    

          <label for="apellido">Edad*:</label>
          <input type="text" id="edad" name="edad" required pattern="[A-Za-z0-9_-]{1,30}">
              
          <input type="hidden" name="form" value="1">
          <button class="ingreso" type="submit" name="modificacion">Ingreso</button>

        </fieldset>        
</form>   
</body>
</html>

<?php 
}
?>