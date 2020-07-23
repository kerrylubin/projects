<!--A Design by W3layouts
   Author: W3layout
   Author URL: http://w3layouts.com
   License: Creative Commons Attribution 3.0 Unported
   License URL: http://creativecommons.org/licenses/by/3.0/
   -->
   <?php include('app_php/webinfo.php'); ?>
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
               <div class="hedder-logo">
                  <h1><a href="index.php"><?php $web = new common(); echo $web->web_Name;?></a></h1>
               </div>
               <!-- /open/close -->
               <!-- navigation section  -->
               <div class="menu">
                  <a href="" id="menuToggle"> <span class="navClosed"></span> </a>
                  <nav>  
                     <a href="index.php" class="active">Home</a> 
                     <a href="#about" class="scroll">About</a>
                     <a href="#service" class="scroll">Services</a>
                     <a href="#gallery" class="scroll">Gallery</a>
                     <a href="error.php">Error</a>
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
         <div class="slider">
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
            <!-- This is here just to demonstrate the callbacks -->
            <!-- <ul class="events">
               <li>Example 4 callback events</li>
               </ul>-->
         </div>
         <div class="clearfix"></div>
      </div>
      <!-- //banner -->
      <!-- About-one -->
      <section class="about py-lg-4 py-md-3 py-sm-3 py-3" id="about">
         <div class="container py-lg-5 py-md-5 py-sm-4 py-3">
            <div class="title-sub text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">
               <h3 class="title mb-2"><?php $web = new about(); echo $web->about_1; ?></h3>
               <div class="line-w3ls-title text-center mb-md-4 mb-sm-3 mb-3"></div>
               <p><?php $web = new about(); echo $web->about_1_txt; ?></p>
            </div>
            <div class="row">
               <div class="col-lg-5 col-md-6 left-imag-agile-txt">
                  <img src="images/ab1.jpg" alt=" " class="img-fluid">
               </div>
               <div class="col-lg-7 col-md-6 right-abut-agile-txt">
                  <h2 class="pb-3"> <?php $web = new about(); echo $web->about_2; ?></h2>
                  <p><?php $web = new about(); echo $web->about_2_txt; ?></p>
                  <div class="outs_about-buttn mt-lg-4 mt-md-3 mt-3">
                     <a href="#contact" class="scroll">Book Now</a>
                  </div>
               </div>
            </div>
            <!-- <div class="row mt-lg-5 mt-md-4 mt-sm-3 mt-3">
               <div class="col-lg-4 col-md-4 col-sm-12 about-agile-icon text-center">
                  <span class="fas fa-cubes"></span>
                  <div class="abut-text-wthree">
                     <h4 class="mt-3">
                        Best Work 
                     </h4>
                     <p class="mt-3">Lorem ipsum dolor sit amet, consectetuer adipiscing elit dolor sit amet</p>
                  </div>
               </div>
               <div class="col-lg-4 col-md-4 col-sm-12 about-agile-icon text-center">
                  <span class="fab fa-servicestack"></span>
                  <div class="abut-text-wthree">
                     <h4 class="mt-3">
                        Colorfull
                     </h4>
                     <p class="mt-3">Lorem ipsum dolor sit amet, consectetuer adipiscing elit dolor sit amet</p>
                  </div>
               </div>
               <div class="col-lg-4 col-md-4 col-sm-12 about-agile-icon text-center">
                  <span class="fab fa-accusoft"></span>
                  <div class="abut-text-wthree">
                     <h4 class="mt-3">
                        Modren Desgin
                     </h4>
                     <p class="mt-3">Lorem ipsum dolor sit amet, consectetuer adipiscing elit dolor sit amet</p>
                  </div>
               </div>
            </div> -->
         </div>
      </section>
      <!-- //About-one -->
      <!--states -->
      <section class="stats py-lg-4 py-md-3 py-sm-3 py-3">
         <div class="container py-lg-5 py-md-5 py-sm-4 py-3">
            <div class="jst-must-info text-center">
               <div class="row stats-info">
                  <div class="col-md-3 col-sm-6 col-6 stats-grid-1">
                     <div class=" stats-grid">
                        <div class="counter">2045</div>
                        <div class="stat-info">
                           <h5 class="pt-2">Experience </h5>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-3 col-sm-6 col-6 stats-grid-2">
                     <div class=" stats-grid">
                        <div class="counter">350</div>
                        <div class="stat-info">
                           <h5 class="pt-2"> Staff</h5>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-3 col-sm-6 col-6 stats-grid-3">
                     <div class=" stats-grid">
                        <div class="counter">1000</div>
                        <div class="stat-info">
                           <h5 class="pt-2"> Coffee</h5>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-3 col-sm-6 col-6 stats-grid-4">
                     <div class=" stats-grid">
                        <div class="counter">650</div>
                        <div class="stat-info">
                           <h5 class="pt-2"> Pojects </h5>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!--//states -->
      <!--service-->	
      <section class="service py-lg-4 py-md-3 py-sm-3 py-3" id="service">
         <div class="container py-lg-5 py-md-5 py-sm-4 py-3">
            <div class="title-sub text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">
               <h3 class="title mb-2"><?php $web = new services(); echo $web->service; ?></h3>
               <div class="line-w3ls-title text-center mb-md-4 mb-sm-3 mb-3"></div>
               <p><?php $web = new services(); echo $web->service_txt; ?></p>
            </div>
            <div class="row">
               <div class="col-lg-4 col-md-6 col-sm-6 ser-icon p-0">
                  <div class="row mx-0">
                     <div class="col-md-4 col-sm-3 col-3 pl-0 text-right banner-icon">
                        <span class="fas fa-arrow-up"></span>
                     </div>
                     <div class="col-md-8 col-sm-9 col-9 ser-text-wthree text-left">
                        <h4>
                        <?php $web = new services(); echo $web->service_1; ?>
                        </h4>
                        <p class="mt-3"><?php $web = new services(); echo $web->service_1_txt; ?></p>
                     </div>
                  </div>
               </div>
               <div class="col-lg-4 col-md-6 col-sm-6 ser-icon p-0">
                  <div class="row mx-0">
                     <div class="col-md-4 col-sm-3 col-3 pl-0 text-right banner-icon">
                        <span class="fas fa-angle-double-up"></span>
                     </div>
                     <div class="col-md-8 col-sm-9 col-9 ser-text-wthree text-left">
                        <h4>
                        <?php $web = new services(); echo $web->service_2; ?>
                        </h4>
                        <p class="mt-3"><?php $web = new services(); echo $web->service_2_txt; ?></p>
                     </div>
                  </div>
               </div>
               <div class="col-lg-4 col-md-6 col-sm-6 ser-icon p-0 mt-lg-0 mt-3">
                  <div class="row mx-0">
                     <div class="col-md-4 col-sm-3 col-3 pl-0 text-right banner-icon">
                        <span class="fas fa-align-justify "></span>
                     </div>
                     <div class="col-md-8 col-sm-9 col-9 ser-text-wthree text-left">
                        <h4>
                        <?php $web = new services(); echo $web->service_3; ?>
                        </h4>
                        <p class="mt-3"><?php $web = new services(); echo $web->service_3_txt; ?></p>
                     </div>
                  </div>
               </div>
               <div class="col-lg-4 col-md-6 col-sm-6 ser-icon p-0 mt-lg-4 mt-3">
                  <div class="row mx-0">
                     <div class="col-md-4 col-sm-3 col-3 pl-0 text-right banner-icon">
                        <span class="fas fa-cubes"></span>
                     </div>
                     <div class="col-md-8 col-sm-9 col-9 ser-text-wthree text-left">
                        <h4>
                        <?php $web = new services(); echo $web->service_4; ?> 
                        </h4>
                        <p class="mt-3"><?php $web = new services(); echo $web->service_4_txt; ?></p>
                     </div>
                  </div>
               </div>
               <div class="col-lg-4 col-md-6 col-sm-6 ser-icon p-0 mt-lg-4 mt-3">
                  <div class="row mx-0">
                     <div class="col-md-4 col-sm-3 col-3 pl-0 text-right banner-icon">
                        <span class="fab fa-servicestack"></span>
                     </div>
                     <div class="col-md-8 col-sm-9 col-9 ser-text-wthree text-left">
                        <h4>
                        <?php $web = new services(); echo $web->service_5; ?>
                        </h4>
                        <p class="mt-3"><?php $web = new services(); echo $web->service_5_txt; ?></p>
                     </div>
                  </div>
               </div>
               <div class="col-lg-4 col-md-6 col-sm-6 ser-icon p-0 mt-lg-4 mt-3">
                  <div class="row mx-0">
                     <div class="col-md-4 col-sm-3 col-3 pl-0 text-right banner-icon">
                        <span class="fab fa-accusoft"></span>
                     </div>
                     <div class="col-md-8 col-sm-9 col-9 ser-text-wthree text-left">
                        <h4>
                        <?php $web = new services(); echo $web->service_6; ?>
                        </h4>
                        <p class="mt-3"><?php $web = new services(); echo $web->service_6_txt; ?></p>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!--//service-->

      <!--team -->
      <!-- <section class="clients py-lg-4 py-md-3 py-sm-3 py-3" id="team">
         <div class="container py-lg-5 py-md-4 py-sm-4 py-3">
            <div class="title-sub text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">
               <h3 class="title mb-2">Our Team</h3>
               <div class="line-w3ls-title text-center mb-md-4 mb-sm-3 mb-3"></div>
               <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed<br>tempor incididunt ut labore et</p>
            </div>
            <div class="row ">
               <div class="col-lg-4 col-md-4 col-sm-4 profile">
                  <div class="img-box icon-follower">
                     <img src="images/t1.jpg" alt="" class="img-fluid">
                  </div>
                  <div class="team-w3layouts-info mt-lg-4 mt-3 text-center">
                     <h4>Rose Will</h4>
                     <span class=" wls-client-title"> Creative Director</span>
                     <div class="list-social-icons">
                        <ul>
                           <li><a href="#"><span class="fab fa-facebook-f"></span></a></li>
                           <li><a href="#"><span class="fas fa-envelope"></span></a></li>
                           <li><a href="#"><span class="fas fa-rss"></span></a></li>
                           <li><a href="#"><span class="fab fa-vk"></span></a></li>
                        </ul>
                     </div>
                  </div>
               </div>
               <div class="col-lg-4 col-md-4 col-sm-4 profile">
                  <div class="img-box">
                     <div class="team-list-img">
                        <img src="images/t2.jpg" alt="" class="img-fluid">
                     </div>
                  </div>
                  <div class="team-w3layouts-info mt-lg-4 mt-3 text-center">
                     <h4>Max Deo</h4>
                     <span class="wls-client-title">Lead Designer</span>
                     <div class="list-social-icons  ">
                        <ul>
                           <li><a href="#"><span class="fab fa-facebook-f"></span></a></li>
                           <li><a href="#"><span class="fas fa-envelope"></span></a></li>
                           <li><a href="#"><span class="fas fa-rss"></span></a></li>
                           <li><a href="#"><span class="fab fa-vk"></span></a></li>
                        </ul>
                     </div>
                  </div>
               </div>
               <div class="col-lg-4 col-md-4 col-sm-4 profile">
                  <div class="img-box">
                     <img src="images/t3.jpg" alt="" class="img-fluid">
                  </div>
                  <div class="team-w3layouts-info mt-lg-4 mt-3 text-center">
                     <h4 >Lara Kent</h4>
                     <span class="wls-client-title"> Creative Director</span>
                     <div class="list-social-icons ">
                        <ul>
                           <li><a href="#"><span class="fab fa-facebook-f"></span></a></li>
                           <li><a href="#"><span class="fas fa-envelope"></span></a></li>
                           <li><a href="#"><span class="fas fa-rss"></span></a></li>
                           <li><a href="#"><span class="fab fa-vk"></span></a></li>
                        </ul>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section> -->
      <!--//team -->

      <section class="fun-facts py-lg-4 py-md-3 py-sm-3 py-3">
         <div class="container-fluid py-lg-5 py-md-5 py-sm-4 py-3">
            <div class="fun-hedder-up text-center">
               <h5><?php $web = new common(); echo $web->story_txt; ?></h5>
            </div>
         </div>
      </section>
      <!--Gallery-->
      <section class="gallery py-lg-4 py-md-3 py-sm-3 py-3" Id="gallery">
         <div class="container py-lg-5 py-md-4 py-sm-4 py-3">
            <div class="title-sub text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">
               <h3 class="title mb-2"><?php $web = new gallery(); echo $web->gallery_title; ?></h3>
               <div class="line-w3ls-title text-center mb-md-4 mb-sm-3 mb-3"></div>
               <p><?php $web = new gallery(); echo $web->gallery_txt; ?></p>
            </div>
            <div class="row grid gallery-info">
               <div class="col-lg-3 col-md-6 col-sm-6 gallery-images">
                  <div class="gallery-grids mb-3">
                     <figure class="effect-milo">
                        <img src="images/g1.jpg" alt="" class="img-fluid">
                        <figcaption>
                           <h5>our<span>Gallery</span></h5>
                           <p>Lorem ipsum dolor</p>
                           <a href="images/g1.jpg" class="gallery-box" data-lightbox="example-set" data-title="">
                           </a>
                        </figcaption>
                     </figure>
                  </div>
                  <div class="gallery-grids">
                     <figure class="effect-milo">
                        <img src="images/g2.jpg" alt="" class="img-fluid">
                        <figcaption>
                           <h5>our<span>Gallery</span></h5>
                           <p>Lorem ipsum dolor</p>
                           <a href="images/g2.jpg" class="gallery-box" data-lightbox="example-set" data-title="">
                           </a>
                        </figcaption>
                     </figure>
                  </div>
               </div>
               <div class="col-lg-3 col-md-6 col-sm-6 gallery-images">
                  <div class="gallery-grids  mb-3">
                     <figure class="effect-milo">
                        <img src="images/g3.jpg" alt="" class="img-fluid">
                        <figcaption>
                           <h5>our<span>Gallery</span></h5>
                           <p>Lorem ipsum dolor</p>
                           <a href="images/g3.jpg" class="gallery-box" data-lightbox="example-set" data-title="">
                           </a>
                        </figcaption>
                     </figure>
                  </div>
                  <div class="gallery-grids">
                     <figure class="effect-milo">
                        <img src="images/g4.jpg" alt="" class="img-fluid">
                        <figcaption>
                           <h5>our<span>Gallery</span></h5>
                           <p>Lorem ipsum dolor</p>
                           <a href="images/g4.jpg" class="gallery-box" data-lightbox="example-set" data-title="">
                           </a>
                        </figcaption>
                     </figure>
                  </div>
               </div>
               <div class="col-lg-3 col-md-6 col-sm-6 gallery-images">
                  <div class="gallery-grids mb-3">
                     <figure class="effect-milo ">
                        <img src="images/g5.jpg" alt="" class="img-fluid">
                        <figcaption>
                           <h5>our<span>Gallery</span></h5>
                           <p>Lorem ipsum dolor</p>
                           <a href="images/g5.jpg" class="gallery-box" data-lightbox="example-set" data-title="">
                           </a>
                        </figcaption>
                     </figure>
                  </div>
                  <div class="gallery-grids">
                     <figure class="effect-milo">
                        <img src="images/g6.jpg" alt="" class="img-fluid">
                        <figcaption>
                           <h5>our<span>Gallery</span></h5>
                           <p>Lorem ipsum dolor</p>
                           <a href="images/g6.jpg" class="gallery-box" data-lightbox="example-set" data-title="">
                           </a>
                        </figcaption>
                     </figure>
                  </div>
               </div>
               <div class="col-lg-3 col-md-6 col-sm-6 gallery-images">
                  <div class="gallery-grids mb-3">
                     <figure class="effect-milo">
                        <img src="images/g7.jpg" alt="" class="img-fluid">
                        <figcaption>
                           <h5>our<span>Gallery</span></h5>
                           <p>Lorem ipsum dolor </p>
                           <a href="images/g7.jpg" class="gallery-box" data-lightbox="example-set" data-title="">
                           </a>
                        </figcaption>
                     </figure>
                  </div>
                  <div class="gallery-grids">
                     <figure class="effect-milo">
                        <img src="images/g8.jpg" alt="" class="img-fluid">
                        <figcaption>
                           <h5>our<span>Gallery</span></h5>
                           <p>Lorem ipsum dolor</p>
                           <a href="images/g8.jpg" class="gallery-box" data-lightbox="example-set" data-title="">
                           </a>
                        </figcaption>
                     </figure>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!--//Gallery-->
      <!-- clients -->
      <!-- <section class="clients py-lg-4 py-md-3 py-sm-3 py-3" id="testimonials">
         <div class="container py-lg-5 py-md-4 py-sm-4 py-3">
            <div class="title-sub text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">
               <h3 class="title mb-2">Our Clients</h3>
               <div class="line-w3ls-title text-center mb-md-4 mb-sm-3 mb-3"></div>
               <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed<br>tempor incididunt ut labore et</p>
            </div>
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
               <ol class="carousel-indicators">
                  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
               </ol>
               <div class="carousel-inner">
                  <div class="carousel-item active">
                     <div class="least-w3layouts-text-gap">
                        <div class="row">
                           <div class="col-md-4 col-sm-4 news-img text-center">
                              <img src="images/c2.jpg" alt="" class="image-fluid">
                           </div>
                           <div class="col-md-8 col-sm-8 news-agile-text ">
                              <p>velit sagittis vehicula. Duis posuere 
                                 ex in mollis iaculis. Suspendisse tincidunt
                                 velit sagittis vehicula
                                 velit sagittis vehicula. Duis posuere 
                                 ex in mollis iaculis. Suspendisse tincidunt
                                 velit sagittis vehicula
                              </p>
                              <h4 class="mt-3">Rose Will 
                              </h4>
                              <span class="wls-client-title">Designer At Behance</span>
                              <div class="customer-rev">
                                 <ul>
                                    <li>
                                       <a href="#">
                                       <span class="fas fa-star"></span>
                                       <span class="fas fa-star"></span>
                                       <span class="fas fa-star"></span>
                                       <span class="far fa-star"></span>
                                       <span class="far fa-star"></span>
                                       </a>
                                    </li>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="carousel-item">
                     <div class="row">
                        <div class="col-md-4 col-sm-4 news-img text-center">
                           <img src="images/c1.jpg" alt="" class="image-fluid">
                        </div>
                        <div class="col-md-8 col-sm-8 news-agile-text ">
                           <p>velit sagittis vehicula. Duis posuere 
                              ex in mollis iaculis. Suspendisse tincidunt
                              velit sagittis vehicula
                              velit sagittis vehicula. Duis posuere 
                              ex in mollis iaculis. Suspendisse tincidunt
                              velit sagittis vehicula
                           </p>
                           <h4 class="mt-3">Max Kent 
                           </h4>
                           <span class="wls-client-title">founter of Instagram</span>
                           <div class="customer-rev">
                              <ul>
                                 <li>
                                    <a href="#">
                                    <span class="fas fa-star"></span>
                                    <span class="fas fa-star"></span>
                                    <span class="fas fa-star"></span>
                                    <span class="far fa-star"></span>
                                    <span class="far fa-star"></span>
                                    </a>
                                 </li>
                              </ul>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="carousel-item">
                     <div class="row">
                        <div class="col-md-4 col-sm-4 news-img text-center">
                           <img src="images/c3.jpg" alt="" class="image-fluid">
                        </div>
                        <div class="col-md-8 col-sm-8 news-agile-text ">
                           <p>velit sagittis vehicula. Duis posuere 
                              ex in mollis iaculis. Suspendisse tincidunt
                              velit sagittis vehicula
                              velit sagittis vehicula. Duis posuere 
                              ex in mollis iaculis. Suspendisse tincidunt
                              velit sagittis vehicula
                           </p>
                           <h4 class="mt-3">Deo Kent 
                           </h4>
                           <span class="wls-client-title">founter of Instagram</span>
                           <div class="customer-rev">
                              <ul>
                                 <li>
                                    <a href="#">
                                    <span class="fas fa-star"></span>
                                    <span class="fas fa-star"></span>
                                    <span class="fas fa-star"></span>
                                    <span class="far fa-star"></span>
                                    <span class="far fa-star"></span>
                                    </a>
                                 </li>
                              </ul>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                  </a>
                  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                  </a>
            </div>
         </div>
      </section> -->
      <!--//clients -->

      <!--contact -->
      <Section class="contact py-lg-4 py-md-3 py-sm-3 py-3" id="contact">
         <div class="container py-lg-5 py-md-5 py-sm-4 py-3">
            <div class="title-sub text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">
               <h3 class="title clr mb-2"><?php $web = new contact(); echo $web->contact_Title; ?></h3>
               <div class="line-w3ls-title clr text-center mb-md-4 mb-sm-3 mb-3"></div>
               <p class="text-light"><?php $web = new contact(); echo $web->contact_txt; ?></p>
            </div>

            <?php include('app_php/contact_form.php')?>

            <div class=" contact-form">
               <form action="" method="POST">
                  <div class="row text-center contact-wls-detail">
                     <div class="col-md-6 form-group contact-forms">
                        <input type="text" name="Name" class="form-control" placeholder="Your Name" required="">
                     </div>
                     <div class="col-md-6 form-group contact-forms">
                        <input type="email" name="Email" class="form-control" placeholder="Your Email" required="">
                     </div>
                  </div>
                  <div class="row text-center contact-wls-detail">
                     <div class="col-md-6 form-group contact-forms">
                        <input type="text" name="Subject" class="form-control" placeholder="Subject" required="">
                     </div>
                     <div class="col-md-6 form-group contact-forms">
                        <input type="text" id="date_picker" name="Date" class="form-control"  placeholder="Date" required="">
                     </div>
                  </div>
                  <div class="form-group contact-forms">
                     <textarea class="form-control" rows="3" name="Message" placeholder="Your Message" required=""></textarea>
                  </div>
                  <div class="sent-butnn text-center">
                     <button type="submit" name="submit" class="btn ">Send</button>
                  </div>
               </form>
            </div>
         </div>
      </section>
      <!--//contact -->
      <!-- footer -->
      <footer class="py-lg-4 py-md-3 py-sm-3 py-3">
         <div class="container py-lg-5 py-md-5 py-sm-4 py-3">
            <div class="row ">
               <div class="dance-agile-info col-lg-6 col-md-6 col-sm-6">
                  <h4 class="pb-lg-4 pb-md-3 pb-3 text-uppercase"><?php $web = new contact(); echo $web->address_title; ?></h4>
                  <div class="bottom-para ">
                     <div class="footer-office-hour">
                        <ul>
                           <li class="mb-2">
                              <h6><?php $web = new contact(); echo $web->address_title; ?></h6>
                           </li>
                           <li>
                              <p><?php $web = new contact(); echo $web->address; ?></p>
                           </li>
                        </ul>
                        <ul>
                           <li class="my-2">
                              <h6><?php $web = new contact(); echo $web->phone_title; ?></h6>
                           </li>
                           <li>
                              <p><?php $web = new contact(); echo $web->phone; ?></p>
                           </li>
                           <li class="my-2">
                              <h6><?php $web = new contact(); echo $web->email_title; ?></h6>
                           </li>
                           <li>
                              <p><a href=<?php $web = new contact(); echo $web->email; ?>><?php $web = new contact(); echo $web->email_Name; ?></a></p>
                           </li>
                        </ul>
                     </div>
                  </div>
               </div>

               <div class="dance-agile-info col-lg-6 col-md-6 col-sm-6">
                  <h4 class="pb-lg-4 pb-md-3 pb-3 text-uppercase">Contact Us</h4>
                  <div class="address_mail_footer_grids">
                     <?php $web = new common(); echo $web->location; ?>
                  </div>
               </div>
               <!-- <div class="dance-agile-info col-lg-3 col-md-6 col-sm-6">
                  <h4 class="pb-lg-4 pb-md-3 pb-3 text-uppercase">Twitter Us</h4>
                  <div class="footer-office-hour">
                     <ul>
                        <li>
                           <p>sit amet consectetur adipiscing</p>
                        </li>
                        <li class="my-1">
                           <p><a href="mailto:info@example.com">info@example.com</a></p>
                        </li>
                        <li class="mb-3"><span>Posted 3 days ago.</span></li>
                        <li>
                           <p>sit amet consectetur adipiscing</p>
                        </li>
                        <li class="my-1">
                           <p><a href="mailto:info@example.com">info@example.com</a></p>
                        </li>
                        <li><span>Posted 3 days ago.</span></li>
                     </ul>
                  </div>
               </div> -->
               <!-- <div class="dance-agile-info col-lg-3 col-md-6 col-sm-6">
                  <h4 class="pb-lg-4 pb-md-3 pb-3 text-uppercase">News Letter</h4>
                  <div class="newsletter">
                     <form action="#" method="post" class="d-flex">
                        <input type="email" name="Your Email" class="form-control" placeholder="Your Email" required="">
                        <button class="btn1">
                        <span class="far fa-envelope"></span>
                        </button>
                     </form>
                  </div>
                  <div class="footer-office-hour mt-3">
                     <p>vehicula velit sagittis vehicula. Duis posuere ex in mollis iaculis. Suspendisse tincidunt velit sagittis vehicula</p>
                  </div>
               </div> -->
            </div>
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