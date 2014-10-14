<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Muistilista</title>

    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script src="assets/vendor/angular.min.js"></script>
    <script src="assets/vendor/angular-route.js"></script>

    <script src="assets/js/app.js"></script>
    <script src="assets/js/controllers/application_controller.js"></script>
    <script src="assets/js/controllers/category_todo_list_controller.js"></script>
    <script src="assets/js/controllers/todo_list_controller.js"></script>
    <script src="assets/js/controllers/edit_todo_controller.js"></script>
    <script src="assets/js/controllers/category_list_controller.js"></script>
    <script src="assets/js/controllers/edit_category_controller.js"></script>
    <script src="assets/js/controllers/login_controller.js"></script>
    <script src="assets/js/controllers/create_category_controller.js"></script>
    <script src="assets/js/controllers/create_todo_controller.js"></script>
    <script src="assets/js/controllers/register_controller.js"></script>
  </head>
  <body ng-app="TodoApp" style="background-image:url('assets/listakuva.jpg'); color: white;">
    <div ng-controller="ApplicationController">
      <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Muistilista</a>
          </div>

          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li ng-show="user"><a href="#/askareet">Askareet</a></li>
              <li ng-show="user"><a href="#/luokat">Luokat</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
              <li ng-show="user"><a ng-click="logout()" style="cursor: pointer;">Kirjaudu ulos</a></li>
              <li ng-hide="user"><a href="#/kirjaudu">Kirjaudu sisään</a></li>
              <li ng-hide="user"><a href="#/rekisteroidy">Rekisteröidy</a></li>
            </ul>
          </div>
        </div>
      </nav>

      <div ng-view style="padding: 0px 30px;"></div>
    </div>

    <script src="assets/vendor/jquery.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
