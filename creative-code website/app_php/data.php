<?php

  include('connection.php');

  
  $date_query = "SELECT c_date FROM contacts";

  $result = $conn->query($date_query);

  if ($result->num_rows > 0) 
  {
    //output data of each row
    $date = array();
    while($row = $result->fetch_assoc()) // output all db data
    {
      $date[] = $row['c_date'];//by putting this '[]' lets you take an array of object from the DB
     
    }

    echo json_encode($date);
    
  }
  else
  {
    echo 'No Data';
  }

  $conn->close();
?>