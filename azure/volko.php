<?php
$link = mysql_connect('127.0.0.1:56915', 'azure', '6#vWHD_$')
    or die('No se pudo conectar: ' . mysql_error());
echo 'Connected successfully';
mysql_select_db('localdb') or die('No se pudo seleccionar la base de datos');

echo 'volko gato';

?>