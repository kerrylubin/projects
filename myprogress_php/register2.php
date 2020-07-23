<?php

    include('connection.php');
    //require "connection.php";

    $user_name = $_POST["user_name"];
    $email = $_POST["email"];
    $pax = $_POST['password'];
    $user_type = $_POST['user_type'];
    $user_study = $_POST['user_study'];

    // $user_name = 'var4';
    // $email = 'tm@tes1';
    // $pax = '123';
    // $user_type = 'Student';
    // $user_study = 'ICT';

    $insert_sql = "INSERT INTO user_data (email, users, user_pax, user_type, user_study) VALUES ('$email', '$user_name', '$pax', '$user_type','$user_study')";

    $checkUser_query = "SELECT * FROM user_data WHERE users = '$user_name' ";

    $teacher_query = "INSERT INTO teachers (teachers_name) VALUES ('$user_name')";

    $student_query = "INSERT INTO students (students) VALUES ('$user_name')";

    $user_grades_query = "INSERT INTO user_grades (student_name) VALUES ('$user_name')";

    $user_progress_query = "INSERT INTO user_progress (student_name) VALUES ('$user_name')";

    $get_id_query = "SELECT id FROM user_data WHERE users = '$user_name'";

    $results = mysqli_query($conn,$get_id_query);

    $results_check_user = mysqli_query($conn,$checkUser_query);

    

    if(mysqli_num_rows($results_check_user)>=1)//inserts data to userdata
    {
        echo 'This user already exist!';
    }
    else
    {
        if($conn->query($insert_sql) )//inserts data to userdata
        {
            // echo 'Registration successfull!';

            $results = mysqli_query($conn,$get_id_query);
            
            // $id = array();
            // while($row = $results->fetch_assoc()) // output all db data
            // {
            //     $id = $row['id'];//by putting this '[]' lets you take an array of object from the DB

            //     $user_goals_query = "INSERT INTO user_goals (user_id) VALUES ('$id')";

            //     $conn->query($user_goals_query);
            // }
    
            if($user_type == 'Leraar')
            {
                $conn->query($teacher_query);
            }
            else 
            {
                $conn->query($student_query);
                $conn->query($user_grades_query);
                $conn->query($user_progress_query);
            }

            echo 'Registration successfull!';
        }
        else
        {
            echo 'Registration Failed!';
            //echo 'Registration Failed! '. $insert_sql. '<br>'. $conn->error;
        }
    }
    $conn->close();
?>