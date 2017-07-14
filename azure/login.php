<?php 
include('config.php');
?>

<form action="login_c.php" method="post">
      
        <h1>Ingreso de usuarios</h1>        
          
          <label for="usuario">Usuario*:</label>
          <input type="text" id="usuario" name="usuario" required pattern="[A-Za-z0-9_-@-]{1,30}">

          <label for="password">Contraseña*:</label>
          <input type="password" id="password" name="password" required pattern="[A-Za-z0-9_-]{1,30}">
       
        <input type="submit" name="login" value="Ingreso">
      </form>   
	  
	
