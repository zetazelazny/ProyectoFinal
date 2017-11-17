<?php
session_start();
include('funciones/config.php');
if(isset($_POST['nombre']) && !empty($_POST['nombre']) &&
  isset($_POST['apellido']) && !empty($_POST['apellido']) &&
  isset($_POST['edad']) && !empty($_POST['edad']))
{
  $nombre = $_POST['nombre'];
  $apellido = $_POST['apellido'];
  $edad = $_POST['edad'];
  $idprof = $_SESSION['id'];

  $conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
  $conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  $consulta = "INSERT INTO pacientes (nombre, apellido, edad, id_profesional) VALUES (:nombre, :apellido, :edad, :id_profesional)";
  $stmt = $conexion->prepare($consulta);

    $stmt->bindParam(':nombre', $_POST['nombre'], PDO::PARAM_STR);       
    $stmt->bindParam(':apellido', $_POST['apellido'], PDO::PARAM_STR); 
    $stmt->bindParam(':edad', $_POST['edad'], PDO::PARAM_INT);
    $stmt->bindParam(':id_profesional', $idprof, PDO::PARAM_INT); 
    $stmt->execute(); 

?>



<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <title>Ingreso de paciente confirmado - Integrapp</title>
      <?php require('funciones/headerLogueado.php'); ?>   
        <body>
        

        <div class="main-container">

        <div class="container">

          <div class="row fadeIn animated">       

            <div class="col-md-11">

              <h2 class="title-style-2">Paciente ingresado correctamente <span class="title-under"></span></h2>

              <p>El ingreso del paciente fue exitoso. Puede ver su lista de pacientes <a href="mispacientes.php">aquí</a>.</p> 
              <p>Para ingresar otro paciente, haga click <a href="agregar.php">aquí</a>.</p>      
              
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
	echo '<script> window.location="login.php";</script>';
}
?>

  