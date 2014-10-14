<?php

  class Category{
    public $id;
    public $name;

    public static function create($attrs){
      $con = Utils::db_connection();

      $query = $con->prepare('INSERT INTO luokka (nimi) VALUES (:nimi)');
      $query->execute(array('nimi' => $attrs['name']));
    }

    public static function todos($id){
        $con = Utils::db_connection();

        $query = $con->prepare('SELECT askare.kuvaus as kuvaus, askare.tarkeys as tarkeys, askare.id as askare_id, luokka.nimi as luokka_nimi from askare, luokka WHERE kayttaja_id = :kayttaja_id AND luokka.id = :id AND askare.luokka_id = luokka.id');
        $query->execute(array('kayttaja_id' => $_SESSION['user'], 'id' => $id));

        $todos = array();

        foreach($query->fetchAll() as $todo){
          $t = new Todo();
          $t->id = $todo['askare_id'];
          $t->description = $todo['kuvaus'];
          $t->priority = $todo['tarkeys'];
          $t->category = $todo['luokka_nimi'];

          array_push($todos, $t);
        }

        return $todos;
    }

    public static function all(){
      $con = Utils::db_connection();

      $query = $con->prepare('SELECT * FROM luokka');
      $query->execute();

      $categories = array();

      foreach($query->fetchAll() as $category){
        $c = new Category();
        $c->name = $category['nimi'];
        $c->id = $category['id'];

        array_push($categories, $c);
      }

      return $categories;
    }

    public static function destroy($id){
      $con = Utils::db_connection();

      $query = $con->prepare('DELETE FROM luokka WHERE id = :id');
      $query->execute(array('id' => $id));
    }

    public static function show($id){
      $con = Utils::db_connection();

      $query = $con->prepare('SELECT * FROM luokka WHERE id = :id LIMIT 1');
      $query->execute(array('id' => $id));

      $results = $query->fetchAll();

      $category = new Category();
      $category->id = $results[0]['id'];
      $category->name = $results[0]['nimi'];

      return $category;
    }

    public static function update($attrs){
      $con = Utils::db_connection();

      $query = $con->prepare('UPDATE luokka SET nimi = :nimi WHERE id = :id');
      $query->execute(array('nimi' => $attrs['name'], 'id' => $attrs['id']));
    }

    public function errors(){
      $errors = array();

      if($this->name == ''){
        array_push($errors, 'Luokan nimi ei saa olla tyhjä!');
      }

      return $errors;
    }
  }

?>
