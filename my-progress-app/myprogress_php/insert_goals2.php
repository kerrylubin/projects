<?php

    include('connection.php');
    //require "connection.php";

    $user_id = $_POST["user_id"];
    $goal_text = $_POST["goal_text"];
    $goal_id = $_POST["goal_id"];



    $insert_sql = "INSERT INTO user_goals (user_id, goal_id, user_goals) VALUES ('$user_id', '$goal_id', '$goal_text')";//user_id change to user_name
    
    if($conn->query($insert_sql))
    {
        echo 'Doel gemaakt';
        // mysqli_query($conn,$update_query);
    }
    else
    {
        echo 'Oops doel was niet gemaakt';
        //echo 'Error '. $insert_sql. '<br>'. $conn->error;
    }
   
    $conn->close();

?>