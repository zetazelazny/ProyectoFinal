<?php
session_start();

$id_pac=$_GET['id'];
$conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

$stmt1 = $conexion->query("SELECT *
  FROM pacientes 
  WHERE id = '$id_pac'");

$stmt2 = $conexion->query("SELECT pacientes.nombre, pacientes.apellido, pacientes.edad, pacientes.foto, pacientes.id_profesional, pacientes.id, profesionales.nombre, profesionales.apellido, profesionales.id
  FROM pacientes INNER JOIN profesionales ON pacientes.id_profesional = profesionales.id
  WHERE pacientes.id = '$id_pac'");

while($row = $stmt1->fetch(PDO::FETCH_ASSOC)) {
  $nombrePac = $row['nombre'];
  $apellidoPac = $row['apellido'];
  $edadPac = $row['edad'];
  $fotoPac = $row['foto'];
}

while($row = $stmt2->fetch(PDO::FETCH_ASSOC)) {
  $nombreProf = $row['nombre'];
  $apellidoProf = $row['apellido'];
}

?>

<!DOCTYPE html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <title>Perfil <?php $edadPac.' '.$apellidoPac ?> - Integrapp</title>
  <?php require('funciones/headerLogueado.php'); ?>

  <body>

    <div class="main-container">

      <div class="container">

        <div class="row">      
          <div class="paciente">
            <?php            

            echo "<img id=fotoPac src=/azure/imagenesPac/$fotoPac></img>"; 
            ?>
            <h1 style="color:black;"><?php echo $nombrePac." ".$apellidoPac ;?></h1>
            <h3><i>Paciente</i></h3><br>  

            <h2 style="color:black;">Datos</h2>

            <div class="descripcion">
              <p><b>Nombre:</b> <?php echo $nombrePac; ?></p><br>
              <p><b>Apellido:</b> <?php echo $apellidoPac;?></p><br>
              <p><b>Edad:</b> <?php echo $edadPac;?></p><br>
              <p><b>Profesional a cargo:</b> <?php echo $nombreProf.' '.$apellidoProf;?></p><br>

              <?php echo "<form id=formPerfil action=subirImgPac.php?id=".$id_pac." enctype=multipart/form-data method=post> "; ?>
                <label for="imagen">Subir/modificar foto de perfil:</label> 
                <input id="imagen" name="imagen" size="30" type="file"/>
                <br>
                <input type="submit" value="Subir imagen" />
              </form>    

            </div>
          </div>

        </div>

      </div>
    </div>
  </div>
</body>
</html>



<style>

body
{
  background-color:#e9e9e9;
}
#fotoPac
{
  width: 100%;
  max-width: 400px;
  max-height: 400px;
}


</style>


