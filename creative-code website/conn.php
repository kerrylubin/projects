<?php

$servername = "localhost";
$username = "kerrylu_kerry";
$password = "cdppw5555cdppw";
$dbname = "kerrylu_creative-code";

$conn = @mysqli_connect($servername, $username,  $password, $dbname) OR die('Could not connet because: '.mysqli_connect_error());

?>