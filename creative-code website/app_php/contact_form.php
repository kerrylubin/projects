<?php

  if (isset($_POST['submit']))
  {
    //when convert php to json for it to show as text you need to add the content-type
   // header('content-type: application/json; charset=utf-8');
    
    include('connection.php');

    // ini_set('SMTP', "mail.lua-schoonmaakbedrijf.nl");//secure223.servconfig.com or mail.lua-schoonmaakbedrijf.nl
    // ini_set('smtp_port', "587");//465 or 587
    // ini_set('sendmail_from', "info@lua-schoonmaakbedrijf.nl");

    // $address = ( $_POST['street'].", ".$_POST['postcode'].", ".$_POST['province'] ); 
    $name = mysqli_real_escape_string($conn, $_POST['Name']);
    $email = mysqli_real_escape_string($conn, $_POST['Email']);
    // $adrs = mysqli_real_escape_string($conn, $address );
    $date_time = mysqli_real_escape_string($conn, $_POST['Date']);
    $msg = mysqli_real_escape_string($conn, $_POST['Message']);
    //mysqli_real_escape_string helps you write " '/ " and other characters
    $sql = "INSERT INTO contacts (c_name, c_email, c_date, c_message)
    VALUES ('$name', '$email' , '$date_time', '$msg')";

    if (!mysqli_query($conn, $sql)) {
      echo "Error: " . mysqli_error($conn);
    }

    //echo $name.$email.$date_time.$msg;

    // $to = 'creativecode.93@gmail.com';
    // $headers = 'From: '. $_POST['naam']. '<'. $_POST['e_address']. '>'. "\r\n";
    // //$headers =  'MIME-Version: 1.0' . "\r\n"; 
    // // $headers .= 'Content-type: text/html; charset=iso-8859-1' . "\r\n"; 
    // //$headers = "From: " .$_POST['e_address'];
    // //$subject = ($_POST['choice']);
    // $subject = $_POST['Subject'];

    // $txt = $name. " ". $adrs. " ". $email. " ". " Bericht: ". 
    // "\n\n". $_POST['message']. 
    // "\n\n". "Dit is een automatisch bericht. Reageer alsjeblieft niet!!". "\n\n";
    
    if ($conn->query($sql) === TRUE) 
    {
      // if(mail($to,$subject,$txt,$headers))
      // {
        //echo("Email send!!");
        //header("Location: index.php");//change page to index
      //}
    } 
    else 
    {
      header("Location: error.php");
      //echo "Error: " . $sql . "<br>" . $conn->error;
    }

    $conn->close();

  }  //break;
  
?>