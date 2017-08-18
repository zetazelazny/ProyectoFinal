<?php
include('funciones/config.php');

$juego = $_POST['juego'];
$puntaje = $_POST['puntaje'];
if(isset($juego, $puntaje))
{
		$con = mysql_connect($host,$user,$pw) or die("Error al conectar al servidor.");

 		mysql_select_db($db,$con)or die("Error al conectar con la base de datos");

 		mysql_query("INSERT INTO puntajes (juego, puntaje) VALUES ('".$juego."','".$puntaje."' )", $con)or die(mysql_error());
}
	
  


