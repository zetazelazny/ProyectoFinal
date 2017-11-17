<?php
session_start();
include('funciones/config.php');

if(!isset($_SESSION['usuario']))
{
    echo '<script> window.location="login.php";</script>';
} else{

	$conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
	$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	$id_pac = $_GET['id'];
	$consultaQuery = "DELETE FROM pacientes WHERE id = :id";
	$consulta = $conexion->prepare($consultaQuery);
	$consulta->bindValue(':id', $id_pac, PDO::PARAM_INT);
	$consulta->execute();
	echo '<script>javascript:history.back(alert("Paciente borrado correctamente."));</script>';
}