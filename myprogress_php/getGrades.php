<?php

include('connection.php');
//require "connection.php";

$user_name = $_POST["user_name"];

// $user_name = "Kerry Lubin";

//select where student name is $user_name;
$sql = "SELECT * FROM user_grades WHERE student_name = '$user_name'" ;

$result = $conn->query($sql);
//$result = mysqli_query($conn,$sql);


if ($result) 
  {
    //output data of each row
    $grades = array();
    while($row = $result->fetch_assoc()) // output all db data
    {
      $grades[] = $row;//by putting this '[]' lets you take an array of object from the DB
     
    }

    echo json_encode($grades);
    
  }
  else
  {
    echo 'Geen Cijfers';
  }

$conn->close();

?>