<?php

    include('connection.php');

    $email = $_POST["email"];
    $user_pax = $_POST["password"];
    // $email = "jm";
    // $user_pax = "1234";

    $user_type_query = "SELECT user_type, users, id, email, user_study FROM user_data WHERE email = '$email' AND user_pax = '$user_pax' ";

    //$result = $conn->query($sql);
    $results_login = mysqli_query($conn,$user_type_query);

    if ($results_login == TRUE) 
    {
        //output data of each row
        $results_login_data = array();
        $results_login_array = array();


        while($row = $results_login->fetch_assoc()) // output all db data
        {
            $results_login_data = $row;//by putting this '[]' lets you take an array of object from the DB

            $user_name = $row['users'];
            $user_id = $row['id'];

            $get_user_grades_query = "SELECT * FROM user_grades WHERE student_name = '$user_name'" ;
            $get_user_progress_query = "SELECT user_grade_percentage, goal_point FROM user_progress WHERE student_name = '$user_name'" ;
            $get_user_goals_query = "SELECT user_goals, goal_id FROM user_goals WHERE user_id = '$user_id'" ;//change to username

            $results_grades_data = mysqli_query($conn,$get_user_grades_query);

            while($row = $results_grades_data->fetch_assoc())//getgrades
            {
                // $results_grades_data[] = $row;//by putting this '[]' lets you take an array of object from the DB
                $results_login_data += $row;
                //array_push($results_login_data,$row);
            }

            $results_progress_data = mysqli_query($conn,$get_user_progress_query);

            while($row = $results_progress_data->fetch_assoc())//getgrades
            {
                // $results_progress_data[] = $row;//by putting this '[]' lets you take an array of object from the DB
                $results_login_data += $row;
                //array_push($results_login_data,$row);
            }

            $results_goals_data = mysqli_query($conn,$get_user_goals_query);

            while($row = $results_goals_data->fetch_assoc())//getgrades
            {
                // $results_goals_data[] = $row;//by putting this '[]' lets you take an array of object from the DB
                $results_login_data += $row;
                //array_push($results_login_data,$row);
            }

            $results_login_array[] = $results_login_data;
        }
        
        if($results_login_array != [])
        {
            echo json_encode($results_login_array);
        }
        else
        {
            echo 'Login Failed';

        }
    }

    $conn->close();
?>