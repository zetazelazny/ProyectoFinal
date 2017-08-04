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
                    
					<li class="submenu-item"><a href="/azure/login.php">Ingreso</a></li>
					<li class="submenu-item"><a href="/azure/registro.php">Registro</a></li>


                  </ul>
                </div> <!-- /#navbar -->

              </div> <!-- /.container -->
              
            </div> <!-- /.navbar-main -->


        </nav> 

    </header> <!-- /. main-header -->

 

      <form id="formulario" action="registro_c.php" method="post" enctype="multipart/for-data" style="margin-top:75px;width: 100%;">
      
        <h1>Registro</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Datos de usuario</legend>
          <label for="usuario" style="margin-top:10px;">Usuario*:</label>
          <input type="text" id="usuario" name="usuario" placeholder="Ejemplo: atjorgeperez" required> 
          <label for="password" style="margin-top:10px;">Contraseña*:</label>
          <input type="password" id="password" name="password" required> 
          <!--<b><p>*Por favor no ingrese carácteres especiales.</p></b>!-->

        </fieldset>
        
        <fieldset>
          <legend><span class="number">2</span>Información personal</legend>

          <label for="nombre" style="margin-top:10px;">Nombre*:</label>
          <input type="text" id="nombre" name="nombre" placeholder="Ingrese su nombre" required >

          <label for="apellido">Apellido*:</label>
          <input type="text" id="apellido" name="apellido" placeholder="Ejemplo: Ingrese su apellido" required>
          
          <label for="email">Email*:</label>
          <input type="email" id="email" name="email" placeholder="Ingrese su e-mail" required>      

          <label for="telefono">Teléfono*:</label>
          <input type="text" id="telefono" name="telefono" placeholder="Ingrese su número de teléfono/celular" required>    

          <label for="cca">CUIT/CUIL/Alias*:</label>
          <input type="text" id="cca" name="cca" placeholder="Ingrese su CUIT/CUIL/Alias" required> 


</fieldset>

<fieldset>

          <legend><span class="number">3</span>Información profesional</legend>
          <br>
          
          <label for="titulo" style="margin-top:10px;">Título*:</label>
          <select id="titulo" name="titulo" required>
            <option value="Profesorado">Profesorado</option>
            <option value="Licenciatura">Licenciatura</option>
            <option value="Tecnicatura">Tecnicatura</option>           
          </select>


          <label for="profesion">Profesión*:</label>
        <select id="profesion" name="profesion" required>
            <option value="doc">Docencia</option>
            <option value="docedesp">Docencia en Educación Especial</option>
            <option value="doclsa">Docencia en Educación Especial con conocimiento de LSA</option>            
			<option value="psicopedagogo">Psicopedagogía</option>
			<option value="terapeuta">Terapeuta Ocupacional</option>
			<option value="psicologo">Psicología</option>
			<option value="fono">Fonoaudiología</option>
        </select>


        <label for="descripcion">Descripción del profesional:</label>
        <textarea id="descripcion" name="descripcion" placeholder="Escriba una descripción profesional suya."></textarea>

        <label for="provincia">Provincia*:</label>
        <input type="text" name="provincia" id="provincia" placeholder="Ingrese la provincia en la que vive" required>   

        <label for="localidad">Localidad/Partido/Ciudad*:</label>
        <input type="text" name="localidad" id="localidad" placeholder="Ingrese la localidad/ciudad en la que vive" required>        
        
        
</fieldset>

        <button type="submit" class="ingreso">Registrarse</button>
      </form>
    

<style type="text/css">
  *, *:before, *:after {
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

body {
  font-family: 'Nunito', sans-serif;
  color: #384047;
}

form {
  max-width: 100%;
  margin: 10px auto;
  padding: 10px 20px;
  background: #f4f7f8;
  border-radius: 8px;
}

h1 {
  margin: 0 0 30px 0;
  text-align: center;
}

input[type="text"],
input[type="password"],
input[type="date"],
input[type="datetime"],
input[type="email"],
input[type="number"],
input[type="search"],
input[type="tel"],
input[type="time"],
input[type="url"],
textarea,
select {
  background: rgba(255,255,255,0.1);
  border: none;
  font-size: 16px;
  height: auto;
  margin: 0;
  outline: 0;
  padding: 15px;
  width: 100%;
  background-color: #e8eeef;
  color: #8a97a0;
  box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
  margin-bottom: 30px;
}

input[type="radio"],
input[type="checkbox"] {
  margin: 0 4px 8px 0;
}

select {
  padding: 6px;
  height: 32px;
  border-radius: 2px;
}

.ingreso {
  padding: 19px 39px 18px 39px;  
  background-color: #115c9b;
  font-size: 18px;
  text-align: center;
  font-style: normal;
  width: 100%;
  margin-bottom: 10px;
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


fieldset {
  margin-bottom: 30px;
  border: none;
}

legend {
  font-size: 1.4em;
  margin-bottom: 10px;
}

label {
  display: block;
  margin-bottom: 8px;
}

label.light {
  font-weight: 300;
  display: inline;
}

.number {
  background-color: #115c9b;
  color: #fff;
  height: 30px;
  width: 30px;
  display: inline-block;
  font-size: 0.8em;
  margin-right: 4px;
  line-height: 30px;
  text-align: center;
  text-shadow: 0 1px 0 rgba(255,255,255,0.2);
  border-radius: 100%;
}

@media screen and (min-width: 480px) {

  form {
    max-width: 480px;
  }

}
</style>
