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

          <div class="row fadeIn animated">       

            <div class="col-md-11">

              <h2 class="title-style-2">Mi perfil <span class="title-under"></span></h2>

              <h4>Id: <?php echo $id ?></h4>
              <h4>Nombre: <?php echo $nombre ?></h4>
              <h4>Apellido: <?php echo $apellido ?></h4>
              <h4><a href="cerrarsesion.php">Cerrar sesión</a></h4>
              
            </div>

          </div> <!-- /.row -->
             

        </div>
      </div> 


		<?php	
}
else
{
	echo '<script> window.location="login.php";</script>';
}

?>
