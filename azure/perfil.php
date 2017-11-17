<?php
session_start();
include('funciones/config.php');
if(isset($_SESSION['usuario']))	
{
		$con = mysql_connect($host,$user,$pw) or die("error al conectar server");
		mysql_select_db($db,$con) or die("error bd");
		$usuario = $_SESSION['usuario'];
		$id = $_SESSION['id']; 
		$nombre = $_SESSION['nombre'];
		$apellido = $_SESSION['apellido'];
    $prof = $_SESSION['profesion'];
    $provincia = $_SESSION['provincia'];
    $localidad = $_SESSION['localidad'];
    $descripcion = $_SESSION['descripcion'];

switch ($prof) {
  case 'doc':
    $profesion = 'Docente';
    break;
  
  case 'docedesp':
    $profesion = 'Docencia en Educación Especial';
    break;

    case 'doclsa':
    $profesion = 'Docencia en Educación Especial con conocimiento de LSA';
    break;

    case 'psicopedagogo':
    $profesion = 'Psicopedagogía';
    break;

    case 'terapeuta':
    $profesion = 'Terapeuta Ocupacional';
    break;

    case 'psicologo':
    $profesion = 'Psicología';
    break;

    case 'fono': 
    $profesion = 'Fonoaudiología';
    break;      
}


    ?>

			<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=utf-8"/>
        <title>Mi perfil - Integrapp</title>
        <?php require('funciones/headerLogueado.php'); ?>

        <body>

        <div class="main-container">

      <div class="container">

          <div class="row">

          <div class="presentacion">

              <?php

                $result = mysql_query("SELECT * FROM profesionales WHERE id = $id"); 
                while ($row=mysql_fetch_array($result)) 
                { 
                    /*almacenamos el nombre de la ruta en la variable $ruta_img*/ 
                    $ruta_img = $row["foto"]; 
                }

              ?>

                  <div class="pres"><?php echo '<img class="titulo" src="/azure/imagenes/' .$ruta_img. '" width="200px" height="200px"/>';?>
                  <h1 style="color:black;"><?php echo $nombre." ".$apellido ;?></h1>
                  <h3><i><?php echo $profesion;?></i></h3><br>
          </div>

            </div>

            <div class="profesional">
              <h2 style="color:black;">Datos profesionales</h2>

              <div class="descripcion">
              <p><b>Profesión:</b> <?php echo $profesion; ?></p><br>
              <p><b>Ubicación:</b> <?php echo $localidad.", ".$provincia ;?></p><br>
              <p><b>Descripción:</b><br><?php echo $descripcion ;?></p><br>

              <form id="formPerfil" action="subirImgProf.php" enctype="multipart/form-data" method="post">
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
</body>
</html>

		<?php	
}
else
{
	echo '<script> window.location="login.php";</script>';
}

?>
