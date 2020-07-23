<?php

    include('connection.php');
    //require "connection.php";

    $user_name = $_POST["student_name"];
    $presentatie = $_POST["presentatie"];
    $discussie = $_POST["discussie"];
    $brief = $_POST["brief"];
    $artikel = $_POST["artikel"];
    $lees = $_POST["lees"];
    $eindcijfer = $_POST["eindcijfer"];

    $percentage = $_POST['percentage'];

    // $presentatie = '2.2';
    // $discussie = '2.2';
    // $brief = '2.3';
    // $artikel = '2.2';
    // $lees = '2.4';
    // $eindcijfer = '2.2';

    //$update_query = "SELECT * FROM user_data";
    $update_query = "UPDATE user_grades 
    SET presentatie = '$presentatie', discussie = '$discussie', brief = '$brief', artikel = '$artikel', lees = '$lees', eindcijfer = '$eindcijfer' 
    WHERE student_name = '$user_name' ";

    $update_percentage_query = "UPDATE user_progress SET user_grade_percentage = '$percentage' WHERE student_name = '$user_name' ";


    //$result = $conn->query($update_query);
    // $result = myupdate_queryi_query($conn,$update_query);

    if($conn->query($update_query) === true)
    {
        if($conn->query($update_percentage_query) === true)
        {
            echo 'Cijfer progress is '.$percentage ;
            //echo $result;
        }
        else
        {
            // echo 'Error '. $update_query. '<br>'. $conn->error;
            echo 'Oops... Somthing went wrong!';
        }

        //echo ' Update successfull!';
        //echo $result;
    }
    else{
        //echo 'Error '. $update_query. '<br>'. $conn->error;
        echo 'Oops... Somthing went wrong!';
    }

    $conn->close();

?>