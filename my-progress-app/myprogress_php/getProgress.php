<?php

include('connection.php');
//require "connection.php";

$user_name = $_POST["student_name"];

// $user_name = "Kerry Lubin";

//select where student name is $user_name;
$sql = "SELECT user_grade_percentage, goal_point FROM user_progress WHERE student_name = '$user_name'" ;

$result = $conn->query($sql);
//$result = mysqli_query($conn,$sql);


if ($result) 
  {
    //output data of each row
    $progress = array();
    while($row = $result->fetch_assoc()) // output all db data
    {
      $progress[] = $row;//by putting this '[]' lets you take an array of object from the DB
     
    }

    echo json_encode($progress);
    
  }
  else
  {
    echo 'Geen Progress';
  }

$conn->close();

?>