<?php
session_start();
include("../funciones/conexion.php");
include("../funciones/ingreso.php");
include('../funciones/asegurar.php');
//$texto = $_POST['nombre'].$_POST['apellido'].$_POST['usuario'].$_POST['email'].$_;
if(isset($_POST['nombre']) && !empty($_POST['nombre']) &&
  isset($_POST['apellido']) && !empty($_POST['apellido']) &&
  isset($_POST['usuario']) && !empty($_POST['usuario']) &&
  isset($_POST['password']) && !empty($_POST['password']) &&
  isset($_POST['email']) && !empty($_POST['email']) &&
  isset($_POST['telefono']) && !empty($_POST['telefono']) &&
  isset($_POST['cca']) && !empty($_POST['cca']) &&
  isset($_POST['provincia']) && !empty($_POST['provincia']) &&
  isset($_POST['localidad']) && !empty($_POST['localidad']) &&
  esEmail($_POST['email']) && esSeguro($_POST['usuario']) && esSeguro($_POST['password']) && esSeguro($_POST['nombre']) && esSeguro($_POST['apellido']) && esSeguro($_POST['telefono'])&& esSeguro($_POST['cca']) && esSeguro($_POST['localidad']) && esSeguro($_POST['provincia']))
{
  $con = mysql_connect($host,$user,$pw)
  or die("Error al conectar al servidor.");

  mysql_select_db($db,$con)
  or die("Error al conectar con la base de datos");

  $nuevo_usuario=mysql_query("SELECT usuario FROM usuarios WHERE usuario='".$_POST['usuario']."'", $con); 

    if(mysql_num_rows($nuevo_usuario)>0) //if usuarios
    { 
      ?>
      <script> javascript:history.back(alert("Este usuario ya está en uso."));
      </script>
      <?php    
    }
      else
      {
        $nuevo_email=mysql_query("SELECT email FROM usuarios WHERE email='".$_POST['email']."'", $con); 

      if(mysql_num_rows($nuevo_email)>0) //if mail
      { 
        ?><script> javascript:history.back(alert("Este mail ya está en uso."));
        </script>
        <?php    
      }

        else //else usuarios && mail
        {
          $desc = asegurar($_POST['descripcion']);
          $desc = utf8_decode($desc);
          $matr = asegurar($_POST['nummat']);    
          $usuario = $_POST['usuario'];
          $usuario = str_replace(' ', '', $usuario);
          $usuario = strtolower($usuario);
          $usuario = utf8_decode($usuario);

          $_POST['usuario'] = str_replace(' ', '', $_POST['usuario']);
          $_POST['usuario'] = strtolower($_POST['usuario']);
          mysql_query("INSERT INTO usuarios (usuario, password, nombre, apellido, email, telefono, cca, titulo, profesion, nummat, descripcion, plan, provincia, localidad) 
          VALUES ('".$usuario."','".$_POST['password']."','".$_POST['nombre']."','".$_POST['apellido']."','".$_POST['email']."','".$_POST['telefono']."','".$_POST['cca']."','".$_POST['titulo']."','".$_POST['profesion']."','".$matr."','".$desc."','".$_POST['plan']."','".$_POST['provincia']."','".$_POST['localidad']."')", $con)
          or die(mysql_error());        

              ?>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
          <!DOCTYPE html>
    <html class="no-js">
        <head>
            <meta charset="utf-8">
            <title>Registro confirmado</title>
            <meta name="description" content="">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <!-- Fonts -->
            <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
            <link href='http://fonts.googleapis.com/css?family=Dosis:400,700' rel='stylesheet' type='text/css'>

            <!-- Bootsrap -->
            <link rel="stylesheet" href="/estilos/css/bootstrap.min.css">

            <!-- Font awesome -->
            <link rel="stylesheet" href="/estilos/css/font-awesome.min.css">

            <!-- Owl carousel -->
            <link rel="stylesheet" href="/estilos/css/owl.carousel.css">

            <!-- Template main Css -->
            <link rel="stylesheet" href="/estilos/css/style.css">
            
            <!-- Modernizr -->
            <script src="estilos/js/modernizr-2.6.2.min.js"></script>
<link rel="shortcut icon" href="estilos/images/favicon.ico" type="image/x-icon"><link rel="icon" href="estilos/images/favicon.ico" type="image/x-icon"></head>

        </head>

        <body>


        <header class="main-header">
            
        
            <nav class="navbar navbar-static-top">

                

                <div class="navbar-main">
                  
                  <div class="container">

                    <div class="navbar-header">
                      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">

                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>

                      </button>
                      
                       <a class="navbar-brand" href="/" style="padding:0px;"><img src="/estilos/images/logo.png" alt="" style="max-width:130px; width: 100%;height: 65px;padding:0px;margin-bottom:10px;"></a>  
                      
                    </div>

                    <div id="navbar" class="navbar-collapse collapse pull-right">

                      <ul class="nav navbar-nav">

                        <li><a href="/">Inicio</a></li>
                        <li><a href="/cursosyarticulos">Novedades</a></li>
                        <li class="has-child"><a href="/busqueda">Búsqueda</a>

                         <ul class="submenu">
                         <li class="submenu-item"><a href="/at">Acompañantes terapéuticos </a></li>
                         <li class="submenu-item"><a href="/enfermeros">Enfermeros </a></li>
                         <li class="submenu-item"><a href="/ag">Asistentes gerontológicos </a></li>
                         <li class="submenu-item"><a href="/cuidadores">Cuidadores domiciliarios </a></li>
                      </ul>

                        </li>
                        <li><a href="/bolsatrabajo">Bolsa de trabajo</a></li>
                        <li><a href="/uso">Cómo usar EncontrAT</a></li>
                        <li><a href="/beneficios">Beneficios</a></li>
                        <li><a href="/contacto">Contacto</a></li>              
                     
                      

                      <?php
                    if(isset($_SESSION['usuario']))
                    {
                        echo '<script> window.location="/";</script>';
                    }
                    else
                    {
                        echo '<li><a href="/registro">Registro</a></li>';
                        echo '<li><a href="/login">Login</a></li>';
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

              <p>Recibimos su registro correctamente y su perfil está siendo creado. Para activar tu cuenta y tener acceso a los servicios de nuestro sitio (perfil publicado, publicidad del perfil, acceso a cursos, etc.) tendrás que completar la siguiente suscripción (MercadoPago):</p>
              <b><a href="http://mpago.la/sxVj" style="font-size: 18px">Ir a Mercado Pago</a></b>          
              
            </div>

          </div> <!-- /.row -->
             

        </div>
      </div> 
      
          <?php
          include ('../funciones/footer.php');
echo footer();
        }
    }
}
else
{
?><script> javascript:history.back(alert("Error en el ingreso de datos. Por favor intente nuevamente. Asegurese de no usar caracteres especiales en los campos."));</script> <?php    
}
?>

}

  