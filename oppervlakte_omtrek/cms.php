<!DOCTYPE html>
<!-- Back End -->
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>New Excersis</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" href="http://dk.fcsprint2.nl/favicon.ico?v=2">
        
        <link rel="stylesheet" type="text/css" href="cms.css">
        <link rel="stylesheet" type="text/css" href="/assets/vendor/font-awesome/css/font-awesome.min.css">
        <script type="text/javascript" src="/assets/vendor/jquery/dist/jquery.min.js"></script>
        <script type="text/javascript" src="/assets/vendor/jquery-ui/jquery-ui.min.js"></script>

        <script type="text/javascript" src="/assets/vendor/konva/konva.min.js"></script>
        
        <script type="text/javascript" src="/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="/assets/vendor/datatables.net-bs/js/dataTables.bootstrap.js"></script>
        <link rel="stylesheet" type="text/css" href="/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/assets/vendor/datatables.net-bs/css/dataTables.bootstrap.css">
        <link rel="stylesheet" type="text/css" href="/assets/vendor/font-awesome/css/font-awesome.min.css">
        
        <script type="text/javascript" src="../../js/generic/checker.js"></script>
        <script src="/assets/vendor/datatables.net/js/jquery.dataTables.js"></script>
        <script src="js/konvacms.js"></script>
        <link rel="stylesheet" type="text/css" href="/assets/vendor/font-awesome/css/font-awesome.min.css">

        <script type="text/javascript" src="class_cms.js"></script>
        <script type="text/javascript" src="cms.js"></script>

    </head>
    <body data-spy="scroll" data-target="#navbar">
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading header">
                    <div class="row">
                        <h2 id="title" class="col-md-8 col-sm-7 col-xs-6">New Exercise</h2>
                        <div class="col-md-offset-2 col-md-2">
                            <h2>
                                <select class="languageSelector form-control required" id="languageSelector" >
                                    <option selected>Language</option>
                                    <option value="NL">NL</option>
                                    <option value="ENG">ENG</option>
                                    <option value="#">#</option>
                                    <option value="#">#</option>
                                    <option value="#">#</option>
                                </select>
                            </h2>
                        </div><!--col-md-offset-2 col-md-2-->
                    </div><!--row-->
                </div><!--panel heading-->
                <div class="panel panel-body">
                    <div id="controls" class="col-md-12 affix-top" data-spy="affix" data-offset-top="40" data-offset-bottom="20">
                        <nav class="navbar navbar-header" data-spy="affix" data-offset-top="93" style="max-width: 1138px;">
                            <a href="index.php" class="btn btn-warning" title="Home"><i class="fa fa-home"></i></a>
                            <a class="btn btn-success addlistBtn " title="New Exercise"><i class="fa fa-plus" ></i></a>
                            <a type="submit" id="saveBtn" title="Save"  class="btn btn-info saveBtn " ><i class="fa fa-save"></i></a>
                            <a class="btn btn-danger removeBtn" title="Remove"><i class="fa fa-trash"></i></a>
                        </nav>
                        <div class="row row-centered">
                            <div id="Title" class="col col-md-4 Head">
                                <input id="exerciseTitle" class="form-control" type="text" placeholder="Title">
                            </div>
                        </div><!--row centered-->
                    </div><!--controls-->
                    <div class="row-centered">
                        <div class="col-xs-12 col-md-7">
                            <div id="stage"><!--id for KONVA-->
                            </div>
                        </div>
                    </div>
                </div><!--panel body-->
                
            </div><!--panel primary-->
        </div><!--container-->

        <div class="row"><!--Go!-->
                    <div class="col-lg-6">
                        <div class="input-group">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">Go!</button>
                            </span>
                            <input type="text" class="form-control" placeholder="Search for...">
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search for...">
                            <span class="input-group-btn">\
                                <button class="btn btn-default" type="button">Go!</button>
                                <button class="btn-danger" type="button"></button>
                                <button class="btn-success" type="button"></button>
                            </span>
                        </div>
                    </div>
                </div>
                <script src="js/konva_ex.js"></script>
    </body>
</html>