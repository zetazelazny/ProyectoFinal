<?php
include('funciones/config.php');
if(isset($_POST['nombre']) && !empty($_POST['nombre']) &&
  isset($_POST['apellido']) && !empty($_POST['apellido']) &&
  isset($_POST['usuario']) && !empty($_POST['usuario']) &&
  isset($_POST['password']) && !empty($_POST['password']) &&
  isset($_POST['email']) && !empty($_POST['email']) &&
  isset($_POST['telefono']) && !empty($_POST['telefono']) &&
  isset($_POST['cca']) && !empty($_POST['cca']) &&
  isset($_POST['provincia']) && !empty($_POST['provincia']) &&
  isset($_POST['localidad']) && !empty($_POST['localidad']))
{
  $con = mysql_connect($host,$user,$pw)
  or die("Error al conectar al servidor.");

  mysql_select_db($db,$con)
  or die("Error al conectar con la base de datos");

  
  $_POST['usuario'] = str_replace(' ', '', $_POST['usuario']);
  $_POST['usuario'] = strtolower($_POST['usuario']);
  mysql_query("INSERT INTO profesionales (usuario, password, nombre, apellido, email, telefono, cca, titulo, profesion, descripcion, provincia, localidad, foto) 
    VALUES ('".$_POST['usuario']."','".$_POST['password']."','".$_POST['nombre']."','".$_POST['apellido']."','".$_POST['email']."','".$_POST['telefono']."','".$_POST['cca']."','".$_POST['titulo']."','".$_POST['profesion']."','".$_POST['descripcion']."','".$_POST['provincia']."','".$_POST['localidad']."', 'null')", $con)
  or die(mysql_error());       

  ?>



  <!DOCTYPE html>
  <html class="no-js">
  <head>
    <meta charset="utf-8">
    <title>Registro confirmado - Integrapp</title>
    <?php require('funciones/headerNoLogueado.php') ?> 


    <div class="main-container">

      <div class="container">

        <div class="row fadeIn animated">       

          <div class="col-md-11">

            <h2 class="title-style-2">Registro exitoso <span class="title-under"></span></h2>

            <p>Recibimos su registro correctamente y su perfil fue creado. <a href="login.php">Ingreso para profesionales</a></p>               

          </div>

        </div> <!-- /.row -->


      </div>
    </div> 
  </body>
  </html>


  <?php

}
else
{
	echo '<script>window.location="registro.php"</script>';
}
?>

