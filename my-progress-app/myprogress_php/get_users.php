<?php

include('connection.php');
//require "connection.php";

//select column users from user_data
$sql = "SELECT students FROM students" ;

$result = $conn->query($sql);
//$result = mysqli_query($conn,$sql);


if ($result) 
  {
    //output data of each row
    $students = array();
    while($row = $result->fetch_assoc()) // output all db data
    {
      $students[] = $row;//by putting this '[]' lets you take an array of object from the DB
     
    }

    echo json_encode($students);
    
  }
  else
  {
    echo 'No Data';
  }

$conn->close();

?>