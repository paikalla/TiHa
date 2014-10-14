<?php

  class User{
    public $username;
    public $password;
    public $password_again;

    public static function create($attrs){
      $con = Utils::db_connection();

      $query = $con->prepare('INSERT INTO kayttaja (kayttajatunnus, salasana) VALUES(:kayttajatunnus, :salasana)');
      $query->execute(array('kayttajatunnus' => $attrs['username'], 'salasana' => $attrs['password']));
    }

    public static function authenticate($attrs){
      $con = Utils::db_connection();

      $query = $con->prepare('SELECT * from kayttaja where kayttajatunnus = :kayttajatunnus AND salasana = :salasana LIMIT 1');
      $query->execute(array('kayttajatunnus' => $attrs['username'], 'salasana' => $attrs['password']));

      $users = $query->fetchAll();

      if(count($users) != 0){
        $_SESSION['user'] = $users[0]['id'];

        return $users[0]['id'];
      }

      return null;
    }

    public function errors(){
      $errors = array();

      if($this->password != $this->password_again){
        array_push($errors, 'Salasanat eivät täsmänneet');
      }

      if($this->password == ''){
        array_push($errors, 'Salasa ei saa olla tyhjä!');
      }

      if($this->username == ''){
        array_push($errors, 'Käyttäjätunnus ei saa olla tyhjä');
      }

      return $errors;
    }
  }

?>
