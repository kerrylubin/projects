<!DOCTYPE html>
<html>
    <head>
		<title>Opervlakte & Omtrek</title>
		<!--JavaScript-->
        <script type="text/javascript" src="/assets/vendor/jquery/dist/jquery.min.js"></script>
		<script type="text/javascript" src="/assets/vendor/jquery-ui/jquery-ui.min.js"></script>
		<!--BootStrap-->
        <script src="/assets/vendor/datatables.net-bs/js/dataTables.bootstrap.js"></script>
        <script type="text/javascript" src= "/assets/vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
		<script type="text/javascript" src="/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/generic/checker.js"></script>
		<link rel="stylesheet" type="text/css" href="/assets/vendor/bootstrap-select/dist/css/bootstrap-select.min.css">
		
		<script type="text/javascript" src="/assets/vendor/konva/konva.min.js"></script>

        <script type="text/javascript" src="/js/generic/navigation.js"></script>
        <script src="/assets/vendor/datatables.net/js/jquery.dataTables.js"></script>
		<script type="text/javascript" src="class_index.js"></script>
		
		<link rel="icon" href="http://dk.fcsprint2.nl/favicon.ico?v=2">
		
        <link rel="stylesheet" type="text/css" href="/assets/vendor/jquery-ui/themes/base/jquery-ui.min.css">
        <link rel="stylesheet" type="text/css" href="/assets/vendor/datatables.net-bs/css/dataTables.bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/assets/vendor/font-awesome/css/font-awesome.css">
        <link rel="stylesheet" type="text/css" href="/css/fonts.css">


        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading col-md-12 col-sm-12 col-xs-12">
                    <div class="row">
                        <div class="col-md-10 col-sm-10 col-xs-8 text-left">
                            <h1>Exercises</h1>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-4 text-right">
                            <h1>
                                <a href="index.php" class="btn btn-info resetFilter" title="Reset Filter">
                                    <i class="fa fa-refresh"></i>
                                </a>
                                <a href="cms.php?id=new" class="btn btn-info newExercise" title="New Excersise">
                                    <i class="fa fa-plus"></i>
                                </a>
                            </h1>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table id="exerciseTable" class="table table-striped table-hover task-table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Language</th>
                                <th></th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </body>

    <script>
        $(document).ready(function () {

            var index = new class_index();
            //index.databaseFunction();
            index.getReady();


        });
    </script>
</html>
