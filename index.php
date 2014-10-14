<?php

  session_start();

  require 'utils/utils.php';

  foreach(glob('controllers/*.php') as $controller){
    require $controller;
  }

  foreach(glob('models/*.php') as $model){
    require $model;
  }

  require 'vendor/Slim/Slim.php';
  \Slim\Slim::registerAutoloader();

  $app = new \Slim\Slim();

  $app->get('/', function () {
      require 'views/main.php';
  });

  $app->get('/askareet', function(){
    TodoController::index();
  });

  $app->post('/askareet', function(){
    TodoController::create();
  });

  $app->get('/askareet/:id', function($id){
    TodoController::show($id);
  });

  $app->post('/askareet/:id/poista', function($id){
    TodoController::destroy($id);
  });

  $app->post('/askareet/:id/muokkaa', function($id){
    TodoController::update($id);
  });

  $app->get('/luokat', function(){
    CategoryController::index();
  });

  $app->post('/luokat', function(){
    CategoryController::create();
  });

  $app->get('/luokat/:id', function($id){
    CategoryController::show($id);
  });

  $app->post('/luokat/:id/poista', function($id){
    CategoryController::destroy($id);
  });

  $app->post('/luokat/:id/muokkaa', function($id){
    CategoryController::update($id);
  });

  $app->get('/luokat/:id/askareet', function($id){
    CategoryController::todos($id);
  });

  $app->get('/kirjautunut_kayttaja', function(){
    UserController::logged_user();
  });

  $app->post('/kirjaudu', function(){
    UserController::login();
  });

  $app->post('/kirjaudu_ulos', function(){
    UserController::logout();
  });

  $app->post('/rekisteroidy', function(){
    UserController::register();
  });

  $app->run();

?>
