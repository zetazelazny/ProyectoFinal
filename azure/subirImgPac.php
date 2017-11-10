<?php
session_start();
include('funciones/config.php');
$con = mysql_connect($host,$user,$pw)
  or die("Error al conectar al servidor.");

  mysql_select_db($db,$con)
  or die("Error al conectar con la base de datos");

$id=$_POST['id'];
$idpac=(int)$id;
$nombre_img = $_FILES['imagen']['name'];
$tipo = $_FILES['imagen']['type'];
$tamano = $_FILES['imagen']['size'];
 
//Si existe imagen y tiene un tamaño correcto
if (($nombre_img == !NULL) && ($_FILES['imagen']['size'] <= 200000)) 
{
   //indicamos los formatos que permitimos subir a nuestro servidor
   if (($_FILES["imagen"]["type"] == "image/gif")
   || ($_FILES["imagen"]["type"] == "image/jpeg")
   || ($_FILES["imagen"]["type"] == "image/jpg")
   || ($_FILES["imagen"]["type"] == "image/png"))
   {
      $nombre_img = $id.".jpg";
      // Ruta donde se guardarán las imágenes que subamos
      $directorio = $_SERVER['DOCUMENT_ROOT'].'/azure/imagenes/';
      // Muevo la imagen desde el directorio temporal a nuestra ruta indicada anteriormente
      move_uploaded_file($_FILES['imagen']['tmp_name'],$directorio.$nombre_img);
      
      $sql = "UPDATE pacientes SET foto = '$nombre_img' WHERE id='$idpac'";
      $result = mysql_query($sql);
      
    } 
    else 
    {
       //si no cumple con el formato
       echo '<script> window.location="perfil.php";</script>';
    }
} 
else 
{
   //si existe la variable pero se pasa del tamaño permitido
   if($nombre_img == !NULL) echo "La imagen es demasiado grande "; 
}

?>