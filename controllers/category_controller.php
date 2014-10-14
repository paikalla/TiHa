<?php

  class CategoryController{
    public static function index(){
      if(!isset($_SESSION['user'])){ return; }
      
      echo json_encode(Category::all());
    }

    public static function show($id){
      if(!isset($_SESSION['user'])){ return; }

      echo json_encode(Category::show($id));
    }

    public static function todos($id){
      if(!isset($_SESSION['user'])){ return; }

      echo json_encode(Category::todos($id));
    }

    public static function create(){
      if(!isset($_SESSION['user'])){ return; }

      $category = new Category();
      $category->name = $_POST['name'];
      $errors = $category->errors();

      if(count($errors) == 0){
        Category::create(array('name' => $category->name));
      }

      echo json_encode(array('errors' => $errors));
    }

    public static function destroy($id){
      if(!isset($_SESSION['user'])){ return; }

      Category::destroy($id);
    }

    public static function update($id){
      if(!isset($_SESSION['user'])){ return; }

      $category = new Category();
      $category->name = $_POST['name'];
      $errors = $category->errors();

      if(count($errors) == 0){
        Category::update(array('id' => $id, 'name' => $category->name));
      }

      echo json_encode(array('errors' => $errors));
    }
  }

?>
