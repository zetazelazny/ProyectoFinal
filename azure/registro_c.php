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
          mysql_query("INSERT INTO profesionales (usuario, password, nombre, apellido, email, telefono, cca, titulo, profesion, descripcion, provincia, localidad) 
          VALUES ('".$_POST['usuario']."','".$_POST['password']."','".$_POST['nombre']."','".$_POST['apellido']."','".$_POST['email']."','".$_POST['telefono']."','".$_POST['cca']."','".$_POST['titulo']."','".$_POST['profesion']."','".$_POST['descripcion']."','".$_POST['provincia']."','".$_POST['localidad']."')", $con)
          or die(mysql_error());       

    ?>



<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <title>Registro confirmado - Integrapp</title>
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
                    
                    <?php
                    if(isset($_SESSION['usuario']))
                    {
                        echo '<li class="submenu-item"><a href="/perfil.php">Perfil</a></li>';
                        echo '<li class="submenu-item"><a href="/cerrarsesion.php">Salir</a></li>';
                    }
                    else
                    {                      
                        echo '<li class="submenu-item"><a href="/login.php">Ingreso</a></li>';
						echo '<li class="submenu-item"><a href="azure/registro.php">Registro</a></li>';
                    }
                    ?>
                    

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

              <h2 class="title-style-2">Registro exitoso <span class="title-under"></span></h2>

              <p>Recibimos su registro correctamente y su perfil está siendo creado. <p>      
              
            </div>

          </div> <!-- /.row -->
             

        </div>
      </div> 
      
          <?php
              
}
else
{
	echo '<script>window.location="registro.php"</script>';
}
?>

  