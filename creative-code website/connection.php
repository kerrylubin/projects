<?php

$servername = "localhost";
$username = "Kerry";
$password = "kdppwkdppw5555";
$dbname = "lua_schoonmaak_bedrijf";

$conn = @mysqli_connect($servername, $username,  $password, $dbname) OR die('Could not connet because: '.mysqli_connect_error());

?>