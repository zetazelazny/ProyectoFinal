<?php
session_start();
include('funciones/config.php');
include('funciones/datos.php');

if(!isset($_SESSION['usuario']))
{
    echo '<script> window.location="login.php";</script>';
}
else{

$idprof = $_SESSION['id'];
$conexion = new PDO('mysql:host=127.0.0.1:56915;dbname=integrapp;charset=utf8mb4', 'azure', '6#vWHD_$');
$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

$consulta = "SELECT puntajes.puntaje AS puntaje, pacientes.nombre AS nombrePac, pacientes.apellido AS apellido, juegos.nombre, pacientes.id_profesional, profesionales.id AS idprof FROM puntajes 
    INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id 
    INNER JOIN juegos ON puntajes.id_juego = juegos.id 
    INNER JOIN profesionales ON pacientes.id_profesional=profesionales.id 
    WHERE pacientes.id_profesional = ".$idprof." 
    ORDER BY puntajes.puntaje DESC";

if(isset($_POST['filtro']))
{
    
    switch($_POST['filtro']){
        case "todos":
        $consulta = "SELECT puntajes.puntaje AS puntaje, pacientes.nombre AS nombrePac, pacientes.apellido AS apellido, juegos.nombre, pacientes.id_profesional, profesionales.id
                    FROM puntajes 
                    INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id
                    INNER JOIN juegos ON puntajes.id_juego = juegos.id
                    INNER JOIN profesionales ON pacientes.id_profesional=profesionales.id 
                    WHERE pacientes.id_profesional = ".$idprof."
                    ORDER BY puntajes.puntaje DESC";
        break;
        case "puntajemax":
        $consulta = "SELECT puntajes.puntaje as puntaje, pacientes.nombre AS nombrePac, pacientes.apellido AS apellido, juegos.nombre 
                    FROM (puntajes 
                    INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id)
                    INNER JOIN juegos ON puntajes.id_juego = juegos.id 
                    INNER JOIN profesionales ON pacientes.id_profesional=profesionales.id 
                    WHERE pacientes.id_profesional = ".$idprof."
                    ORDER BY puntajes.puntaje DESC";
        break;
        case "puntajemin":
        $consulta = "SELECT puntajes.puntaje as puntaje, pacientes.nombre AS nombrePac, pacientes.apellido AS apellido, juegos.nombre 
                    FROM (puntajes 
                    INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id)
                    INNER JOIN juegos ON puntajes.id_juego = juegos.id 
                    INNER JOIN profesionales ON pacientes.id_profesional=profesionales.id 
                    WHERE pacientes.id_profesional = ".$idprof."
                    ORDER BY puntajes.puntaje ASC";
        break; 

        case "memotest":
        $nombrejuego = "memotest";
        $consulta = "SELECT puntajes.puntaje as puntaje, pacientes.nombre AS nombrePac, pacientes.apellido AS apellido, juegos.nombre  
                    FROM (puntajes 
                    INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id)
                    INNER JOIN juegos ON puntajes.id_juego = juegos.id
                    INNER JOIN profesionales ON pacientes.id_profesional=profesionales.id 
                    WHERE pacientes.id_profesional = ".$idprof." AND juegos.nombre = '".$nombrejuego."'
                    ORDER BY puntajes.puntaje ASC"
                    ;
        break;        

        case "conceptos":
        $nombrejuego = "conceptos";
        $consulta = "SELECT puntajes.puntaje as puntaje, pacientes.nombre AS nombrePac, pacientes.apellido AS apellido, juegos.nombre  
                    FROM (puntajes 
                    INNER JOIN pacientes ON puntajes.id_usuario = pacientes.id)
                    INNER JOIN juegos ON puntajes.id_juego = juegos.id
                    INNER JOIN profesionales ON pacientes.id_profesional=profesionales.id 
                    WHERE pacientes.id_profesional = ".$idprof." AND juegos.nombre = '".$nombrejuego."'
                    ORDER BY puntajes.puntaje ASC"
                    ;
        break;                   
    }

}

?>

<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <title>Ver mis pacientes - Integrapp</title>
        <?php require('funciones/headerLogueado.php'); ?>   

<div id="filtros">
<form action="traerPuntajes.php" method="post">
    <select name="filtro">        
        <option value="todos">Seleccione un filtro</option>
        <option value="puntajemax">Puntaje máximo</option>
        <option value="puntajemin">Puntaje mínimo</option>
        <option value="conceptos">Juego: Conceptos</option>
        <option value="memotest">Juego: Memotest</option>
    </select> 
    <button type="submit">Filtrar</button></form>
</div>

<br>

<!--comienza tabla puntajes-->
<table>
     <tr> 
     <th>Juego</th> 
    <th>Nombre</th>
    <th>Apellido</th> 
    <th>Puntaje</th>  
    </tr>
    <tr>
<?php
$stmt = $conexion->query($consulta);
while($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
          
          echo "<td>".$row['nombre']."</td>";
          echo "<td>".$row['nombrePac']."</td>";
          echo "<td>".$row['apellido']."</td>";
          echo "<td>".$row['puntaje']."</td></tr>";
          }           
    echo "</table>";
?>

</body>
</html>


<?php
}
?>