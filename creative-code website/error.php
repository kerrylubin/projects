<!--A Design by W3layouts
   Author: W3layout
   Author URL: http://w3layouts.com
   License: Creative Commons Attribution 3.0 Unported
   License URL: http://creativecommons.org/licenses/by/3.0/
   -->
   <?php include('app_php/webInfo.php'); ?>
<!DOCTYPE html>
<html lang="zxx">
   <head>
      <title><?php $web = new common(); echo $web->web_Title; ?></title>
      <!--meta tags -->
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="keywords" content="Multi-Pro Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
         Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
      <script>
         addEventListener("load", function () {
         	setTimeout(hideURLbar, 0);
         }, false);
         
         function hideURLbar() {
         	window.scrollTo(0, 1);
         }
      </script>
      <!--//meta tags ends here-->
      <!--booststrap-->
      <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
      <!--//booststrap end-->
      <!-- font-awesome icons -->
      <link href="css/fontawesome-all.min.css" rel="stylesheet" type="text/css" media="all">
      <!-- //font-awesome icons -->
      <!--gallery-->
      <link rel="stylesheet" type="text/css" href="css/set1.css" />
      <!--//gallery-->
      <!--lightbox slider-->
      <link rel="stylesheet" href="css/lightbox.css">
      <!-- lightbox slider-->
      <link href="css/style.css" rel='stylesheet' type='text/css' media="all">
      <!--//stylesheets-->
      <link href="//fonts.googleapis.com/css?family=Montserrat:300,400,500" rel="stylesheet">
      <link href="//fonts.googleapis.com/css?family=Encode+Sans+Condensed:400,500,600,700" rel="stylesheet">
       <!-- DateTimepicker -->
       <link rel="stylesheet" href="datetimepicker/jquery.datetimepicker.css">
      <link rel="stylesheet" href="datetimepicker/build/jquery.datetimepicker.min.css">
      <!-- jQuiry file ui -->
      <link rel="stylesheet" href="css/jquery-ui.css">
      <link rel="stylesheet" href="css/jquery-ui.structure.css">
      <link rel="stylesheet" href="css/jquery-ui.theme.css">

   </head>
   <body>
      <div class="header-outs" id="header">
         <div class="header-w3layouts">
            <div class="container">
               <!-- open/close -->
               <!-- <div class="hedder-logo">
                  <h1><a href="index.php"><?php $web = new common(); echo $web->web_Name;?></a></h1>
               </div> -->
               <!-- /open/close -->
               <!-- navigation section  -->
               <div class="menu open">
                  <!-- <a href="" id="menuToggle"> <span class="navClosed"></span> </a> -->
                  <nav>  
                     <a href="index.php" class="active">Home</a> 
                     <a href="#about" class="scroll">About</a>
                     <a href="#service" class="scroll">Services</a>
                     <a href="#gallery" class="scroll">Gallery</a>
                     <!-- <a href="error.php">Error</a> -->
                     <a href="#contact" class="scroll">Contact</a> 
                  </nav>
               </div>
               <div class="clearfix"> </div>
               <!-- /navigation section -->
            </div>
            <div class="clearfix"> </div>
         </div>
         <!--banner -->
         <!-- Slideshow 4 -->
         <!-- <div class="slider">
            <div class="callbacks_container">
               <ul class="rslides" id="slider4">
                  <li>
                     <div class="slider-img one-img">
                        <div class="container">
                           <div class="slider-info">
                              <h5><?php $web = new index(); echo $web->slider_1; ?></h5>
                              <p><?php $web = new index(); echo $web->slider_1_txt; ?></p>
                              <div class="outs_more-buttn">
                                 <a href="#contact" class="scroll">Book Now</a>
                              </div>
                           </div>
                        </div>
                     </div>
                  </li>
                  <li>
                     <div class="slider-img two-img">
                        <div class="container">
                           <div class="slider-info">
                              <h5><?php $web = new index(); echo $web->slider_2; ?></h5>
                              <p><?php $web = new index(); echo $web->slider_2_txt; ?></p>
                              <div class="outs_more-buttn">
                                 <a href="#contact" class="scroll">Book Now</a>
                              </div>
                           </div>
                        </div>
                     </div>
                  </li>
                  <li>
                     <div class="slider-img three-img">
                        <div class="container">
                           <div class="slider-info">
                              <h5><?php $web = new index(); echo $web->slider_3; ?></h5>
                              <p><?php $web = new index(); echo $web->slider_3_txt; ?></p>
                              <div class="outs_more-buttn">
                                 <a href="#contact" class="scroll">Book Now</a>
                              </div>
                           </div>
                        </div>
                     </div>
                  </li>
               </ul>
            </div>
            This is here just to demonstrate the callbacks 
             <ul class="events">
               <li>Example 4 callback events</li>
               </ul>
         </div> -->
         <div class="clearfix"></div>
      </div>
      <!-- //banner -->
      <!-- 404 -->
      <div class="container-fluid py-lg-5 py-md-4 py-sm-4 py-3"style="background:#f2f2f2">
         <div class="page-not-agile text-center">
            <h4>404</h4>
            <div class="sub-text-page">
               <p>sorry somthing whent wrong</p>
            </div>
         </div>
      </div>
      <!--//contact -->
      <!-- footer -->
      <footer class="py-lg-4 py-md-3 py-sm-3 py-3" style="background:#f2f2f2">
         <div class="container py-lg-5 py-md-5 py-sm-4 py-3">
            <div class="copy-agile-right text-center pt-2">
               <div class="list-social-icons text-center py-lg-4 py-md-3 py-3">
                  <ul>
                     <li><a href="#"><span class="fab fa-facebook-f"></span></a></li>
                     <li><a href=<?php $web = new contact(); echo $web->email; ?>><span class="fas fa-envelope"></span></a></li>
                     <li><a href="#"><span class="fas fa-rss"></span></a></li>
                     <li><a href="#"><span class="fab fa-vk"></span></a></li>
                  </ul>
               </div>
               <p> 
                  © 2018 <?php $web = new common(); echo $web->webName_logo;?>. All Rights Reserved | Design by <a href="http://www.W3Layouts.com" target="_blank">W3Layouts</a>
               </p>
            </div>
         </div>
      </footer>
      <!-- //footer -->

      <!--js working-->
      <script src='js/jquery-2.2.3.min.js'></script>
      <!--  light box js -->
      <script src="js/lightbox-plus-jquery.min.js"> </script> 
      <!-- //light box js-->  

      <script src="js/jquery.js" type="text/javascript"></script>
      <script src="js/jquery-ui.js"></script>


      <!--responsiveslides banner-->
      <script src="js/responsiveslides.min.js"></script>
      <!-- //OnScroll-Number-Increase-JavaScript -->
      <!-- start-smoth-scrolling -->
      <script src="js/move-top.js"></script>
      <script src="js/easing.js"></script>
      <!--About OnScroll-Number-Increase-JavaScript -->
      <script src="js/jquery.waypoints.min.js"></script>
      <script src="js/jquery.countup.js"></script>
      <script>
         $('.counter').countUp();
      </script>

      <!-- DateTimepicker -->
      <script src="datetimepicker/jquery.datetimepicker.js" type="text/javascript"></script>
      <script src="datetimepicker/build/jquery.datetimepicker.full.min.js" type="text/javascript"></script>
      <script src="datetimepicker/build/jquery.datetimepicker.min.js" type="text/javascript"></script>

      <!-- contact js has all the events like scrolling and navbar -->
      <script src="app_js/contact.js"></script>

      <script type="text/javascript">//call the class when you are Objorieted
         var CNTC = new getContact();
      </script>
      <!--bootstrap working-->
      <script src="js/bootstrap.min.js"></script>
      <!-- //bootstrap working-->
   </body>
</html>