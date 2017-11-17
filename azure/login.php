<?php
session_start();
include('funciones/config.php');
if(isset($_SESSION['usuario']))
{
	echo '<script> window.location="perfil.php";</script>';
}
?>

<!DOCTYPE html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <title>Ingreso para profesionales - Integrapp</title>
  <?php require('funciones/headerNoLogueado.php') ?>

  <body>
    <form action="login_c.php" method="post">
      <div class="form-group">
        <h1>Ingreso</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Datos de usuario</legend>
          <label for="usuario">Usuario*:</label>
          <input type="text" id="usuario" name="usuario" required pattern="[A-Za-z0-9_-@-]{1,30}">

          <label for="password">Contraseña*:</label>
          <input type="password" id="password" name="password" required pattern="[A-Za-z0-9_-]{1,30}">         
          
          
        </fieldset>        
        
        <button class="ingreso" type="submit" name="login">Ingreso</button>
      </div>
    </form>      
  </body>
  </html>