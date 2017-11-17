<?php
session_start();
include('funciones/config.php');
if(isset($_SESSION['usuario']))
{
	echo '<script> window.location="perfil.php";</script>';
}
?>

<!DOCTYPE html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <title>Registro para profesionales - Integrapp</title>
  <?php require('funciones/headerNoLogueado.php') ?> 

  <form id="formulario" action="registro_c.php" method="post" enctype="multipart/for-data">

    <h1>Registro</h1>

    <fieldset>
      <legend><span class="number">1</span>Datos de usuario</legend>
      <label for="usuario">Usuario*:</label>
      <input type="text" id="usuario" name="usuario" placeholder="Ejemplo: atjorgeperez" required> 
      <label for="password">Contraseña*:</label>
      <input type="password" id="password" name="password" required> 
      <!--<b><p>*Por favor no ingrese carácteres especiales.</p></b>!-->

    </fieldset>

    <fieldset>
      <legend><span class="number">2</span>Información personal</legend>

      <label for="nombre">Nombre*:</label>
      <input type="text" id="nombre" name="nombre" placeholder="Ingrese su nombre" required >

      <label for="apellido">Apellido*:</label>
      <input type="text" id="apellido" name="apellido" placeholder="Ejemplo: Ingrese su apellido" required>

      <label for="email">Email*:</label>
      <input type="email" id="email" name="email" placeholder="Ingrese su e-mail" required>      

      <label for="telefono">Teléfono*:</label>
      <input type="text" id="telefono" name="telefono" placeholder="Ingrese su número de teléfono/celular" required>    

      <label for="cca">CUIT/CUIL/Alias*:</label>
      <input type="text" id="cca" name="cca" placeholder="Ingrese su CUIT/CUIL/Alias" required> 


    </fieldset>

    <fieldset>

      <legend><span class="number">3</span>Información profesional</legend>
      <br>

      <label for="titulo" style="margin-top:10px;">Título*:</label>
      <select id="titulo" name="titulo" required>
        <option value="Profesorado">Profesorado</option>
        <option value="Licenciatura">Licenciatura</option>
        <option value="Tecnicatura">Tecnicatura</option>           
      </select>


      <label for="profesion">Profesión*:</label>
      <select id="profesion" name="profesion" required>
        <option value="doc">Docencia</option>
        <option value="docedesp">Docencia en Educación Especial</option>
        <option value="doclsa">Docencia en Educación Especial con conocimiento de LSA</option>            
        <option value="psicopedagogo">Psicopedagogía</option>
        <option value="terapeuta">Terapeuta Ocupacional</option>
        <option value="psicologo">Psicología</option>
        <option value="fono">Fonoaudiología</option>
      </select>


      <label for="descripcion">Descripción del profesional:</label>
      <textarea id="descripcion" name="descripcion" placeholder="Escriba una descripción profesional suya."></textarea>

      <label for="provincia">Provincia*:</label>
      <input type="text" name="provincia" id="provincia" placeholder="Ingrese la provincia en la que vive" required>   

      <label for="localidad">Localidad/Partido/Ciudad*:</label>
      <input type="text" name="localidad" id="localidad" placeholder="Ingrese la localidad/ciudad en la que vive" required>    



    </fieldset>

    <button type="submit" class="ingreso">Registrarse</button>
  </form>
</body>
</html>
 
