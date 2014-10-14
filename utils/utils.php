<?php
  class Utils{
  		public static function db_connection(){
  			try {
  			    $connection = new PDO("mysql:unix_socket=/home/viukari/mysql/socket;dbname=mysql", "root", "ellupellu");
  			} catch (PDOException $e) { }

        $names = $connection->prepare("SET NAMES 'utf8'");
        $names->execute();

  			return $connection;

  		}
  }
?>
