<?php
session_start();
include('funciones/config.php');
include('funciones/datos.php');

if(!isset($_SESSION['usuario']))
{
	echo '<script> window.location="login.php";</script>';
}
else{
  $idprof = $_SESSION['id'];
  $conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
  $conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  $stmt = $conexion->query("
  SELECT profesionales.id as id_profesional, pacientes.nombre AS nombrePac, pacientes.apellido AS apellidoPac, pacientes.id_profesional AS id_pacprofesional, pacientes.id AS id_pac
  FROM profesionales 
  INNER JOIN pacientes ON profesionales.id = pacientes.id_profesional
  WHERE profesionales.id = $idprof
  ORDER BY pacientes.nombre, pacientes.apellido DESC");


  ?>

  <!DOCTYPE html>
  <html class="no-js">
  <head>
    <meta charset="utf-8">
    <title>Ver mis pacientes - Integrapp</title>
    <?php require('funciones/headerLogueado.php'); ?>

    <body>

      <table>
        <tr>
          <th>Nombre</th>
          <th>Apellido</th>
          <th>Ver</th>
          <th>Acciones</th>
        </tr>
        
          <?php        
          
          while($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
          $id_pac = $row['id_pac'];
          echo "<tr><td>".$row['nombrePac']."</td>";
          echo "<td>".$row['apellidoPac']."</td>";
          echo "<td><a href=datosPac.php?id=".$id_pac.">Datos</a></td>";
          echo "<td><a href=modificarDatosPac.php?id=".$id_pac.">Modificar datos</a>
          <br>
          <a href=bajaPac.php?id=".$id_pac.">Dar de baja</a>
          </td></tr>";
          }                
                  
         }
         ?>
         
              
       
    </table>    
    
  </body>
  </html> 
