<?php

    include('connection.php');
    //require "connection.php";

    $user_name = $_POST["user_name"];
    $goal_id = $_POST['goal_id'];
    $goal_points = $_POST['goal_point'];

    // ALTER TABLE `user_goals` 
    // ADD COLUMN `user_goal_6` VARCHAR(45) NULL AFTER `user_name`;

    // ALTER TABLE `user_goals` 
    // DROP COLUMN `user_goal_5`;
    $delete_query = "DELETE FROM user_goals WHERE goal_id = '$goal_id' ";

    // $drop_query = "ALTER TABLE user_goal DROP user_goal_$goal_id";

    $update_query = "UPDATE user_progress SET goal_point = '$goal_points' WHERE student_name = '$user_name' ";

    if($conn->query($delete_query))
    {
        echo 'Verwijderd  ';
        if($conn->query($update_query))
        {
            echo $goal_points.'  Doel punten gehaald!';
        }
        else{
            echo 'Error '. $update_query. '<br>'. $conn->error;
        }
    }
    else
    {
        echo 'Error '. $delete_query. '<br>'. $conn->error;
    }

    $conn->close();

?>