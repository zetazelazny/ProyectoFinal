<?php

$conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$stmt = $conexion->prepare("SELECT id, nombre, apellido FROM profesionales ");
$stmt->execute();
$var = $stmt->fetchAll(PDO::FETCH_ASSOC);
$json = json_encode($var);
echo $json;

?>