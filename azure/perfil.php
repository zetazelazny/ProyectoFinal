<?php
session_start();
include('funciones/config.php');
if(isset($_SESSION['usuario']))	
{
		$con = mysql_connect($host,$user,$pw) or die("error al conectar server");
		mysql_select_db($db,$con) or die("error bd");
		$usuario = $_SESSION['usuario'];
		$id = $_SESSION['id']; 
		echo $id;		
		//$users = mysql_query("SELECT nombre, apellido, id FROM usuarios WHERE usuario='$usuario'");		
		//$pac = mysql_query("SELECT nombre, apellido FROM pacientes WHERE usuario='$_SESSION['id']'", $con);
		/*while ($row = mysql_fetch_array($pac))
		{
			$idd = $row['id'];
		}		*/
}
else
{
	echo 'error';
}


?>
