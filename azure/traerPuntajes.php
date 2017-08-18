<?php

$conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$stmt = $conexion->prepare("SELECT * FROM puntajes ORDER BY puntaje DESC");
$stmt->execute();
$stmt->fetch(PDO::FETCH_ASSOC);
echo "<table>";  
echo "<tr>";  
echo "<th>Juego</th>";  
echo "<th>Usuario</th>";  
echo "<th>Puntaje</th>";  
echo "</tr>"; 
foreach( $stmt as $valor) {
    echo "<tr>";
    echo "<td>".$valor['id_juego']."</td>";
    echo "<td>".$valor['id_usuario']."</td>";
    echo "<td>".$valor['puntaje']."</td>";
    echo "</tr>";
}



?>