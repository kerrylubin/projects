<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <link type="text/css" rel="stylesheet" href="../../assets/vendor/font-awesome/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="../../assets/vendor/bootstrap/dist/css/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="../../assets/vendor/jquery-ui/themes/base/all.css">
        <link type="text/css" rel="stylesheet" href="../../assets/vendor/bootstrap-select/dist/css/bootstrap-select.min.css">
        <link type="text/css" rel="stylesheet" href="../../css/fonts.css">
        <link type="text/css" rel="stylesheet" href="css/stijl_cms.css">
        <script type='text/javascript' src="../../assets/vendor/jquery/dist/jquery.min.js"></script>
        <script type='text/javascript' src="../../assets/vendor/jquery-ui/jquery-ui.min.js"></script>
        <script type='text/javascript' src="../../assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
        <script type='text/javascript' src="../../assets/vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
        <script type='text/javascript' src="../../assets/vendor/bootbox.js/bootbox.js"></script>
        <script type="text/javascript" src="../../assets/vendor/konva/konva.min.js"></script>
        <script type="text/javascript" src="../../js/generic/checker.js"></script>
        <script type='text/javascript' src="../../js/generic/app_js.js"></script>
        <script type="text/javascript" src="../../js/generic/nt2school.js"></script>
        <script type="text/javascript" src="../../js/generic/navigation.js"></script>
        
        <script type="text/javascript" src="js/exercise_cms.js"></script>
        <!-- <script type="text/javascript" src="js/calc.js"></script>     -->
        
    </head>

    <body>
        <div class="navigation">
            
        </div>
        <div class="container containerCustom">
            <div class="row">
                <div id="exercise" class="maxEx col-xs-12 col-sm-12 col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading col-xs-12 col-sm-12 col-md-12">
                            <div class="col-xs-12 col-sm-10 col-md-10 text-left">
                                <h2 id="tHead"></h2>
                            </div>
                            <div class="col-md-2 col-sm-2 col-xs-2">
                                <h2>                                 
                                    <select class="form-control languageInputField" id="languageSelector" name="language" required></select>
                                </h2> 
                            </div>
                        </div>
                        <div class="panel-body scroll">
                            <div class="row">
                                <div class="col-md-12">
                                    <!-- <nav class="navbar" data-spy="affix" data-offset-top="197" style="margin-top: 10px;">
                                        <div id="nav navbar-nav">
                                            titel opdracht: <input id="title" type="text" value="">
                                            <button id="btn_save">sla op</button>&nbsp;<button onclick="redirectToFront();">sla op en bekijk</button>
                                    </nav> -->

                                    <nav class="navbar affix-top" data-spy="affix" data-offset-top="197">
                                        <div id="nav navbar-nav">
                                            Titel opdracht: <input id="title" placeholder="new exercise" type="text">
                                            <button id="btn_save" class="btn btn-primary fa fa-save"></button><!-- &nbsp;<button onclick="redirectToFront();">sla op en bekijk</button> -->
                                        </div>
                                    </nav>
                                </div>

                                
                            </div>
                        </div>

                        <div class="panel-body">
                        
                            <div class="row">

                                <div class="col-xs-6 col-sm-4">
                                    <ul class="list-group" id="list">
                                    </ul>
                                <a class="btn btn-primary" title="Add Input" id="addInput"><i class="fa fa-plus" aria-hidden="true"></i></a>
                                </div>
                                

                                <div class="col-xs-6 col-sm-4 col-md-6" >
                                    <div id="stage"></div>
                                </div>
                                
                                <div class="col-md-12 col-md-2">
                                    <a class="btn btn-primary" title="Add Point" id="point"><i class="fa fa-plus" aria-hidden="true"></i></a>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    
        <script type="text/javascript">
            $(document).ready(function()
            {
                var EX = new getExerciseCMS();
            });
        </script>
    </body>
</html>