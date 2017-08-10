<?php
session_start();
include('funciones/config.php');
session_destroy();
echo '<script> window.location="login.php";</script>';
?>
