<?php
include('config.php');
$con = mysql_connect($host,$user,$pw) or die("error al conectar server");
mysql_select_db($db,$con) or die("error bd");
$consulta = mysql_query("SELECT * FROM usuarios", $con);
echo "<table>  
		<tr>
		<th>Nombre</th>
		<th>Apellido</th>
		</tr>";
while($row = mysql_fetch_array($consulta))
{	
	echo '<tr>  
			<td>'.$row['nombre'].'</td>
			<td>'.$row['apellido'].'</td>
			</tr>';  
}  
echo '</table>';
?>
