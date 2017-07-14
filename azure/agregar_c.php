<?php
session_start();
include('config.php');
$con = mysql_connect($host,$user,$pw) or die("error al conectar server");
mysql_select_db($db,$con) or die("error bd");

if(isset($_POST['nombre']) && !empty($_POST['nombre']) &&
  isset($_POST['apellido']) && !empty($_POST['apellido']))
  {
	   $con = mysql_connect($host,$user,$pw) or die("Error al conectar al servidor.");
	   mysql_select_db($db,$con) or die("Error al conectar con la base de datos");
	   
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
				mysql_query("INSERT INTO usuarios (nombre, apellido) VALUES $_POST['nombre'], $_POST['apellido']", $con);
			}
	  
  }

?>