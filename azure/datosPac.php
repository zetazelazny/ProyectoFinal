<?php
session_start();

$id_pac=$_GET['id'];
$conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$consulta = "
      SELECT nombre, apellido
      FROM pacientes 
      WHERE id = '$id_pac'";
$stmt = $conexion->prepare($consulta);
$stmt->execute();
$array = $stmt->fetch(PDO::FETCH_ASSOC);
var_dump($array);

foreach( $array as $valor) {
    echo $valor["nombre"];
    echo $valor["apellido"];
}

echo"<br><br><br><br><br><br><table>";
    echo "<tr>";   
    echo "<th>Nombre</th>";  
    echo "<th>Apellido</th>"; 
    echo "</tr>";
    echo "<tr>";
foreach( $array as $valor) {
    echo "<td>".$valor[nombre]."</td>";
    echo "<td>".$valor[apellido]."</td>";
   echo "</tr>";
} 
    echo "</table>";

    echo 'jirafa10';

?>