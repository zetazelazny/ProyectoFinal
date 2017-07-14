<?php
session_start();
include('config.php');
if(isset($_SESSION['usuario']))
{
	
?>

<html>
<head>
</head>
<body>
<form action="agregar_c.php" method="POST" name="form">
<label for="nombre">Nombre</label>
<input type="text" name="nombre">

<label for="apellido">Apellido</label>
<input type="text" name="apellido">
</form>
</body>
</html>
<?php
}
else
{
  echo '<script> window.location="login.php";</script>';
}