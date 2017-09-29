<?php

function Datos($idpac)
{
$idprof = $_SESSION['id'];
$conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$consulta = "
      SELECT profesionales.id as id_profesional, pacientes.nombre AS nombre, pacientes.apellido AS apellido, pacientes.id_profesional AS id_pacprofesional, pacientes.id AS id_pac
      FROM profesionales 
      INNER JOIN pacientes ON profesionales.id = pacientes.id_profesional
      WHERE profesionales.id = $idprof AND pacientes.id = $idpac
      ORDER BY pacientes.nombre, pacientes.apellido DESC";
$stmt = $conexion->prepare($consulta);
$stmt->execute();
$stmt->fetch(PDO::FETCH_ASSOC);

}

?>
