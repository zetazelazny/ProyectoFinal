<?php
$conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$id_juego = $_POST['id_juego'];
$id_usuario = $_POST['id_usuario'];
$puntaje = $_POST['puntaje'];
$fecha = $_POST['fecha'];
	if(isset($id_juego, $id_usuario, $puntaje))
	{
		$stmt=$conexion->prepare("INSERT INTO puntajes (id_juego, id_usuario, puntaje, fecha) VALUES ('".$id_juego."','".$id_usuario."','".$puntaje."','".$fecha."')");
		$stmt->execute();
	}

	 	
	
  


