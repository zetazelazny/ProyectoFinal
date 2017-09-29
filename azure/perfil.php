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
        <meta charset="utf-8">
        <title>Mi perfil - Integrapp</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Dosis:400,700' rel='stylesheet' type='text/css'>

        <!-- Bootsrap -->
        <link rel="stylesheet" href="estilos/css/bootstrap.min.css">


        <!-- Font awesome -->
        <link rel="stylesheet" href="estilos/css/font-awesome.min.css">

        <!-- PrettyPhoto -->
        <link rel="stylesheet" href="estilos/css/prettyPhoto.css">

        <!-- Template main Css -->
        <link rel="stylesheet" href="estilos/css/style.css">
        
        <!-- Modernizr -->
        <script src="estilos/js/modernizr-2.6.2.min.js"></script>
        <link rel="shortcut icon" href="estilos/images/favicon.ico" type="image/x-icon"><link rel="icon" href="estilos/images/favicon.ico" type="image/x-icon"></head>


    </head>
    <body>
    <!-- NAVBAR
    ================================================== -->

    <header class="main-header">
        
    
        <nav class="navbar navbar-static-top">
            

            <div class="navbar-main">
              
              <div class="container">

                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">

                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>

                  </button>                  
                
                </div>

                <div id="navbar" class="navbar-collapse collapse pull-right">

                  <ul class="nav navbar-nav">

                    
                    <li class="submenu-item"><a href="/azure/perfil.php">Mi perfil</a></li>
                    <li class="submenu-item"><a href="/azure/agregar.php">Agregar paciente</a></li>
                    <li class="submenu-item"><a href="/azure/mispacientes.php">Mis pacientes</a></li>

                  </ul>
                </div> <!-- /#navbar -->

              </div> <!-- /.container -->
              
            </div> <!-- /.navbar-main -->


        </nav> 

    </header> <!-- /. main-header -->

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

              <form action="subirImgProf.php" enctype="multipart/form-data" method="post">
                <label for="imagen">Subir/modificar foto de perfil:</label> 
                <input id="imagen" name="imagen" size="30" type="file"/>
                <br>
                <input type="submit" value="Subir imagen" />
              </form>    
              <br>
              <h4><a href="cerrarsesion.php">Cerrar sesión</a></h4>



              </div>

            </div>

          </div>
      </div>
  </div>



<style>

#imagen
{
margin-left: auto;
margin-right: auto;
}
    
.presentacion{
  background-color:white;
  height: 300px;
  width: 75%;
  border-radius:3px;
  border: 1px solid #ebeff6;
  margin:20px;
  text-align: center;
}

p
{
  font-size: 15px;
}

.descripcion
{
  margin-top:20px;
  width: 100%;
}

.profesional
{
background-color:white;
  height: 450px;
  width: 75%;
  border-radius:3px;
  border: 1px solid #ebeff6;
  margin:20px;
  text-align: center;
}
 img.titulo {
border: 2px solid grey;padding: 0;
border-radius: 800px;
overflow: hidden;
width:150px;
height:150px;
margin-left: auto;
margin-right: auto;
display: block;
}


.pres
{
  text-align: center;
  margin-top:20px;
}
body
{
    background-color:#e9e9e9;

}

.titulo
{
    display: inline-block;
    justify-content: center;
    text-align:center;
}


.ingreso {
  padding: 19px 39px 18px 39px;  
  background-color: #115c9b;
  font-size: 18px;
  text-align: center;
  font-style: normal;
  min-width: 20px;
  max-width:250px;
  width: 50%;
  color: white;
  text-decoration: none;
  display: inline-block;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  cursor: pointer;
}
.ingreso:hover { 
    background-color: white;
    color:#115c9b;
}
</style>

		<?php	
}
else
{
	echo '<script> window.location="login.php";</script>';
}

?>
