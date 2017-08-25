<?php

include('config.php');

$con = mysql_connect($host,$user,$pw) or die("error al conectar server");

mysql_select_db($db,$con) or die("error bd");

if(isset($_POST['nombre']))
{	
	$name = $_POST['nombre'];
	$consulta = mysql_query("SELECT nombre, apellido FROM profesionales WHERE nombre='$name'", $con);	
	while ($row=mysql_fetch_array($consulta)){ 
		echo "Nombre: ".$row['nombre'];
		echo "<br>";
		echo "Apellido: ".$row['apellido'];
	}
}  


?>