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

$consulta = "SELECT puntajes.puntaje as puntaje, pacientes.nombre AS nombre, pacientes.apellido AS apellido, juegos.nombre AS nombrejuego, pacientes.id_profesional
			FROM (puntajes 
			INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id)
			INNER JOIN juegos ON puntajes.id_juego = juegos.id ORDER BY puntajes.puntaje DESC
            WHERE idprof = $idprof";
if(isset($_POST['filtro']))
{
switch($_POST['filtro']){
case "todos":
$consulta = "SELECT puntajes.puntaje as puntaje, pacientes.nombre AS nombre, pacientes.apellido AS apellido, juegos.nombre AS nombrejuego 
            FROM (puntajes 
            INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id)
            INNER JOIN juegos ON puntajes.id_juego = juegos.id ORDER BY puntajes.puntaje DESC";
break;
case "puntajemax":
$consulta = "SELECT puntajes.puntaje as puntaje, pacientes.nombre AS nombre, pacientes.apellido AS apellido, juegos.nombre AS nombrejuego 
            FROM (puntajes 
            INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id)
            INNER JOIN juegos ON puntajes.id_juego = juegos.id ORDER BY puntajes.puntaje DESC";
break;
case "puntajemin":
$consulta = "SELECT puntajes.puntaje as puntaje, pacientes.nombre AS nombre, pacientes.apellido AS apellido, juegos.nombre AS nombrejuego 
            FROM (puntajes 
            INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id)
            INNER JOIN juegos ON puntajes.id_juego = juegos.id ORDER BY puntajes.puntaje ASC";
break; 

case "Conceptos":
$nombrejuego = "Conceptos";
$consulta = "SELECT puntajes.puntaje as puntaje, pacientes.nombre AS nombre, pacientes.apellido AS apellido, juegos.nombre AS nombrejuego 
            FROM (puntajes 
            INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id)
            INNER JOIN juegos ON puntajes.id_juego = juegos.id ORDER BY puntajes.puntaje ASC
            WHERE nombrejuego = $nombrejuego";
break;                   
}

}

else
{
$consulta = "SELECT puntajes.puntaje as puntaje, pacientes.nombre AS nombre, pacientes.apellido AS apellido, juegos.nombre AS nombrejuego 
            FROM (puntajes 
            INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id)
            INNER JOIN juegos ON puntajes.id_juego = juegos.id ORDER BY puntajes.puntaje DESC";
}
$stmt = $conexion->prepare($consulta);
$stmt->execute();
$stmt->fetch(PDO::FETCH_ASSOC);

?>

<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <title>Ver mis pacientes - Integrapp</title>
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

<div id="filtros">
<form action="traerPuntajes.php" method="post">
    <select name="filtro">        
        <option value="todos">Seleccione un filtro</option>
        <option value="puntajemax">Puntaje máximo</option>
        <option value="puntajemin">Puntaje mínimo</option>
        <option value="conceptos">Juego: Conceptos</option>
        <option value="memotest">Juego: Memotest</option>
    </select> 
    <button type="submit">Filtrar</button></form>
</div>

<br>

<!--comienza tabla puntajes-->
<table>
     <tr> 
     <th>Juego</th> 
    <th>Nombre</th>
    <th>Apellido</th> 
    <th>Puntaje</th>  
    </tr>
    <tr>
<?php
    foreach( $stmt as $valor) {
	
    echo "<td>".$valor['nombrejuego']."</td>";
    echo "<td>".$valor['nombre']."</td>";
    echo "<td>".$valor['apellido']."</td>";
    echo "<td>".$valor['puntaje']."</td>";
   echo "</tr>";
}
 
    echo "</table>";
?>

<!--fin tabla puntajes-->

 <style>
table {
    border-collapse: collapse;
    width: 80%;
    left:0;
    right:0;
    margin:auto;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #337ab7;
    color: white;
}
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

<?php
}
?>