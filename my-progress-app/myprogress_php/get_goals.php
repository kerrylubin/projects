<?php

include('connection.php');
//require "connection.php";

$user_id = $_POST["user_id"];
// $user_id = "1";


//select where student name is $user_name;
$select_query = "SELECT user_goals, goal_id FROM user_goals WHERE user_id = '$user_id'" ;//change to username

$result = $conn->query($select_query);

if ($result == TRUE) 
  {
    //output data of each row
    $goals = array();
    while($row = $result->fetch_assoc()) // output all db data
    {
      $goals[] = $row;//by putting this '[]' lets you take an array of object from the DB
     
    }

    if($goals != [])
    {
      echo json_encode($goals);
    }
    else
    {
      echo 'No Data';

    }
    
  }
  // else
  // {
  //   echo 'No Data';
  // }

$conn->close();

?>