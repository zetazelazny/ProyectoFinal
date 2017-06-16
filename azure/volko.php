<?php
$link = mysql_connect('127.0.0.1:56915', 'azure', '6#vWHD_$') or die(mysql_error());
mysql_select_db('usuarios') or die(mysql_error());
$result = mysql_query("SELECT nombre FROM usuarios", $link); 
echo 'gato';
}
?>