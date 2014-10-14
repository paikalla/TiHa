<?php

  class UserController{
    public static function login(){
      $user = User::authenticate(array('username' => $_POST['username'], 'password' => $_POST['password']));

      echo json_encode(array('authenticated' => $user));
    }

    public static function logout(){
      $_SESSION['user'] = null;
    }

    public static function register(){
      $user = new User();
      $user->username = $_POST['username'];
      $user->password = $_POST['password'];
      $user->password_again = $_POST['password_again'];

      $errors = $user->errors();

      if(count($errors) == 0){
        User::create(array('username' => $user->username, 'password' => $user->password));
      }

      echo json_encode(array('errors' => $errors));
    }

    public static function logged_user(){
      echo json_encode(array('logged_user' => isset($_SESSION['user']) ? $_SESSION['user'] : null));
    }
  }

?>
