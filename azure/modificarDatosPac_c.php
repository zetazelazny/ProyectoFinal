<?php
session_start();
include("funciones/config.php");
	if(isset($_POST['form']))
	{			
		$conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
		$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		$nombre = $_POST['nombre'];
		$apellido = $_POST['apellido'];
		$edad = $_POST['edad'];
		$conexion->exec("UPDATE pacientes SET nombre = '$nombre', apellido = '$apellido', edad = '$edad'");
		echo '<script> window.location="perfil.php";</script>';  
		
	}
	
	else
	{
			echo '<script>javascript:history.back(alert("Vuelva a intentarlo."));</script>';
	}