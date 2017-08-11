<?php
include('funciones/config.php');
$con = mysql_connect($host,$user,$pw) or die("Error al conectar al servidor.");

 mysql_select_db($db,$con)or die("Error al conectar con la base de datos");

if(isset($variables))
	{
		$db = 
	}
  
mysql_query("INSERT INTO pacientes (nombre, apellido, edad)
VALUES ('".$_POST['nombre']."','".$_POST['apellido']."','".$_POST['edad']."')", $con)or die(mysql_error());

