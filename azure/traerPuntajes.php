<?php

$conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

$consulta = "SELECT puntajes.puntaje as puntaje, pacientes.nombre AS nombre, pacientes.apellido AS apellido, juegos.nombre AS nombrejuego 
			FROM (puntajes 
			INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id)
			INNER JOIN juegos ON puntajes.id_juego = juegos.id ORDER BY puntajes.puntaje DESC";
$stmt = $conexion->prepare($consulta);
$stmt->execute();
$stmt->fetch(PDO::FETCH_ASSOC);
echo "<table>";  
echo "<tr>";  
echo "<th>Juego</th>";  
echo "<th>Nombre</th>";  
echo "<th>Apellido</th>"; 
echo "<th>Puntaje</th>";   
echo "</tr>"; 
foreach( $stmt as $valor) {
    echo "<tr>";
    echo "<td>".$valor['nombrejuego']."</td>";
    echo "<td>".$valor['nombre']."</td>";
    echo "<td>".$valor['apellido']."</td>";
    echo "<td>".$valor['puntaje']."</td>";
    echo "</tr>";
}



?>

<style>
td {
    height: 50px;
    vertical-align: bottom;
}
</style>