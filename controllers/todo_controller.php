<?php

  class TodoController{
    public static function index(){
      if(!isset($_SESSION['user'])){ return; }

      echo json_encode(Todo::all());
    }

    public static function show($id){
      if(!isset($_SESSION['user'])){ return; }

      echo json_encode(Todo::show($id));
    }

    public static function create(){
      if(!isset($_SESSION['user'])){ return; }

      $todo = new Todo();

      $todo->category = $_POST['category'];
      $todo->description = $_POST['description'];
      $todo->priority = $_POST['priority'];

      $errors = $todo->errors();

      if(count($errors) == 0){
          Todo::create(array('description' => $_POST['description'], 'priority' => $_POST['priority'], 'category' => $_POST['category'], 'user' => $_POST['user']));
      }

      echo json_encode(array('errors' => $errors));
    }

    public static function destroy($id){
      if(!isset($_SESSION['user'])){ return; }

      Todo::destroy($id);
    }

    public static function update($id){
      if(!isset($_SESSION['user'])){ return; }
      
      $todo = new Todo();

      $todo->category = $_POST['category'];
      $todo->description = $_POST['description'];
      $todo->priority = $_POST['priority'];

      $errors = $todo->errors();

      if(count($errors) == 0){
          Todo::update(array('description' => $_POST['description'], 'priority' => $_POST['priority'], 'category' => $_POST['category'], 'id' => $id));
      }

      echo json_encode(array('errors' => $errors));
    }
  }

?>
