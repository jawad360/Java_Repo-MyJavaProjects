<?php
$nm=$_POST['name'];
$em=$_POST['mail'];
$add=$_POST['add'];
$con=mysqli_connect("localhost","root","","bank") or die("error");

$query=mysqli_query($con,"insert into `contact` values ('$nm','$em','$add')") or die("error in table");

if($query==true) echo "contact updated";
?>