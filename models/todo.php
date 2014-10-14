<?php

  class Todo{
    public $id;
    public $description;
    public $priority;
    public $category;

    public static function create($attrs){
      $con = Utils::db_connection();

      $query = $con->prepare('INSERT INTO askare (kuvaus, tarkeys, luokka_id, kayttaja_id) VALUES(:kuvaus, :tarkeys, :luokka_id, :kayttaja_id)');
      $query->execute(array('kuvaus' => $attrs['description'], 'tarkeys' => $attrs['priority'], 'luokka_id' => $attrs['category'], 'kayttaja_id' => $attrs['user']));
    }

    public static function all(){
      $con = Utils::db_connection();

      $query = $con->prepare('SELECT askare.kuvaus as kuvaus, askare.tarkeys as tarkeys, askare.id as askare_id, luokka.nimi as luokka_nimi from askare, luokka WHERE kayttaja_id = :kayttaja_id AND askare.luokka_id = luokka.id');
      $query->execute(array('kayttaja_id' => $_SESSION['user']));

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

    public static function show($id){
      $con = Utils::db_connection();

      $query = $con->prepare('SELECT * FROM askare WHERE id = :id LIMIT 1');
      $query->execute(array('id' => $id));

      $results = $query->fetchAll();

      $todo = new Todo();
      $todo->id = $results[0]['id'];
      $todo->description = $results[0]['kuvaus'];
      $todo->priority = $results[0]['tarkeys'];
      $todo->category = $results[0]['luokka_id'];

      return $todo;
    }


    public static function update($attrs){
      $con = Utils::db_connection();

      $query = $con->prepare('UPDATE askare SET kuvaus = :kuvaus, tarkeys = :tarkeys, luokka_id = :luokka_id  WHERE id = :id');
      $query->execute(array('luokka_id' => $attrs['category'], 'tarkeys' => $attrs['priority'], 'kuvaus' => $attrs['description'], 'id' => $attrs['id']));
    }

    public static function destroy($id){
      $con = Utils::db_connection();

      $query = $con->prepare('DELETE FROM askare WHERE id = :id');
      $query->execute(array('id' => $id));
    }

    public function errors(){
      $errors = array();

      if(is_null($this->category)){
        array_push($errors, 'Valitse luokka askareellesi!');
      }

      if($this->description == ''){
        array_push($errors, 'Askareen kuvaus ei saa olla tyhjä!');
      }

      if($this->priority == ''){
        array_push($errors, 'Askareen tarkeysaste ei saa olla tyhjä!');
      }

      return $errors;
    }
  }

?>
