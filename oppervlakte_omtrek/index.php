<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Oppervlakte Omtrek</title>
        <link rel="stylesheet" href="/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/vendor/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="/assets/vendor/datatables.net-bs/css/dataTables.bootstrap.min.css" >
        <link href='/css/fonts.css' rel='stylesheet' type='text/css'>
        <link rel="icon" href="http://dk.fcsprint2.nl/favicon.ico?v=2">
        <script type="text/javascript" src="/assets/vendor/jquery/dist/jquery.min.js"></script>
        <script type="text/javascript" src="/assets/vendor/jquery-ui/jquery-ui.min.js"></script>
        <script type="text/javascript" src="/js/generic/checker.js"></script>
        <script type="text/javascript" src="/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/assets/vendor/datatables.net/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="/assets/vendor/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="/assets/vendor/datatables-plugins/sorting/natural.js"></script>
        <script type="text/javascript" src="js/index.js"></script>
        <style>
            body
            {
                font-family: 'Ubuntu', verdana;
                font-size: 1.8em;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading col-md-12">
                    <div class="col-md-10 text-left">
                        <h1 class="">Oppervlakte Omtrek</h1>
                    </div>
                    <div class="col-md-2 text-right">
                        <h1>
                            <a class="btn btn-info resethFilter top-8" title="Reset filters"><i class="fa fa-refresh"></i></a>
                            <a class="btn btn-info newExercise top-8" title="New Exercise"><i class="fa fa-plus"></i></a>
                        </h1>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="col-md-12 table table-striped table-hover task-table setdatatbl" style="width: 1111px !important">
                        <thead>
                            <tr>
                                <th class="col-md-1">ID</th>
                                <th class="col-md-6">Title</th>
                                <th class="col-md-3">Language</th>
                                <th class="col-md-2"></th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
