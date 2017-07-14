<?php
session_start();
include("config.php");
	if(isset($_POST['login']))
	{		
	if(isset($_POST['usuario']) && !empty($_POST['usuario']) && 
	isset($_POST['password']) && !empty($_POST['password']))
	{
		$con = mysql_connect($host,$user,$pw) or die("error al conectar server");
		mysql_select_db($db,$con) or die("error bd");
		$usuario = $_POST['usuario'];
		$password = $_POST['password'];
		$log = mysql_query("SELECT usuario, nombre, apellido, id FROM usuarios WHERE usuario='$usuario' AND password='$password'");
		if(mysql_num_rows($log)>0)
		{
			$row = mysql_fetch_array($log);
			$_SESSION['usuario'] = $row['usuario'];
			$_SESSION['nombre'] = $row['nombre'];
			$_SESSION['apellido'] = $row['apellido'];
			$_SESSION['id'] = $row['id'];
					
			  echo '<script> window.location="perfil.php";</script>';  
		}
		else
		{
			echo '<script>javascript:history.back(alert("Ingreso de datos incorrecto."));</script>';

		}
	}
	}
	else
	{
			echo '<script>javascript:history.back(alert("Vuelva a intentarlo."));</script>';
	}