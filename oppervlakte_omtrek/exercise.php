<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <meta name="description" content="Oppervlakte-Omtrek is an application that your calculation speed on the surface and circumfarence of an figure">
        <meta name="keywords" content="rekentuin,friesland, college,smartrekenen,surface, oppervlakte, area of a circle ">
        <!-- allow website to scale from different devices -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="../../assets/vendor/font-awesome/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="../../assets/vendor/bootstrap/dist/css/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="../../css/fonts.css">
        <link type="text/css" rel="stylesheet" href="css/stijl.css">
        <script type="text/javascript" src="../../assets/vendor/jquery/dist/jquery.min.js"></script>
        <script type="text/javascript" src="../../assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../../assets/vendor/konva/konva.min.js"></script>
       
        <script type="text/javascript" src="../../js/generic/navigation.js"></script>
        <script type="text/javascript" src="../../js/generic/nt2school.js"></script>
        <script type="text/javascript" src="../../js/generic/tr_fcsprint.js"></script>
        <script type="text/javascript" src="../../js/generic/timer.js"></script>
        <script type="text/javascript" src="../../js/generic/score.js"></script>
        <script type="text/javascript" src="js/exercise.js"></script>
        <script type="text/javascript" src="js/konva_ex.js"></script>
        <!-- <script type="text/javascript" src="js/test.js"></script> -->
    </head>
    <body>
        <div class="navigation"></div>
        <div class="container">
            <div class="row">

                <div id="exercise" class="maxEx col-xs-12 col-sm-12 col-md-12">

                    <div class="panel panel-primary">

                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-12 col-sm-10 col-md-10 text-left">
                                    <h2 id="tHead"></h2>
                                </div>
                            </div>
                        </div>
                        
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-4 col-md-6" id="timer">
                                    </div>
                                    <div class="col-xs-8 col-md-6 text-right" id="score">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="panel-body">

                            <div class="row">

                                <div class="col-xs-12 col-sm-12 col-md-4" id="main_content"></div>
                               
                                    
                                    <div id="stage" class="col-xs-6 col-sm-8 col-md-8 text-center">
                                    </div> 
                                    <!-- <button class="btn btn-primary"><i class="fa fa-save"></i></button>  -->
                                <!-- </div> -->
                               
                            </div>
                            
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>    

        <script type="text/javascript">
            var TIME = new TIMER('#timer');
            $('#timer').prepend('<i class="fa fa-clock-o"></i> ');
            var SCR = new SCORE('#score');
            var EX = new getExercise();
            //var t = new test();
        </script>

    </body>
</html>