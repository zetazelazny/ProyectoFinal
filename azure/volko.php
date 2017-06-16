<?php
$link = mysql_connect('127.0.0.1:56915', 'azure', '6#vWHD_$') or die('No se pudo conectar: ' . mysql_error());
mysql_select_db('localdb') or die('No se pudo seleccionar la base de datos');
$result = mysql_query("SELECT nombre FROM usuarios", $link); 
while ($row = mysql_fetch_row($result)){ 
echo $row['nombre'];
}
?>