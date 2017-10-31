<?php
$id_profesional = $_POST['id_profesional'];
$conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$stmt = $conexion->prepare("SELECT id, nombre, apellido, id_profesional FROM pacientes WHERE id_profesional ='".$id_profesional."'");
$stmt->execute();
$var = $stmt->fetchAll(PDO::FETCH_ASSOC);
$json = json_encode($var);
echo $json;
?>