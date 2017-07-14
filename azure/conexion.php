<?php


try{
$db = new PDO('mysql:host=localhost;dbname=probando;charset=utf8mb4', 'root', 'albi');
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

}catch(PDOException $e){
echo 'ERROR';
}


$statement=$db->prepare("INSERT INTO inserta(Nombre) VALUES (:texto)");
$statement->bindParam(':texto', $_POST['texto']);
$title = $_POST['texto'];
$statement->execute();

?>