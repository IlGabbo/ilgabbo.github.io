<?php
  if ($_SERVER["REQUEST_METHOD"] !== "POST") {
    echo "405 - Method not allowed";
    exit();
  }
  $defaultUser = "gabbo";
  $defaultPass = "1234";

  $username = isset($_POST['username']) ? $_POST["username"] : null;
  $password = isset($_POST['password']) ? $_POST["password"] : null;

  if ($username !== $defaultUser) {
    echo "User does not exists";
    exit();
  }
  if ($password !== $defaultPass) {
    echo "Wrong password";
    exit();
  }

  /**
   * session_start() crea/riprende una sessione
   */
  session_start();

  /**
   * Questa sintassi permette di creare una variabile di sessione
   */
  $_SESSION["logged"] = true;
  $_SESSION["username"] = $username;
  
  /**
   * Inizializzo gli array di sessione utilizzati per salvare le recensioni (vedi l'esercizio per capire meglio)
   */
  $_SESSION["france_reviews"] = array();
  $_SESSION["spain_reviews"] = array();
  $_SESSION["italy_reviews"] = array();

  /**
   * Qui sposto l'utente sulla pagina index.php se loggato (vedi cosa è un header se vuoi)
   */
  header("Location: ./home/index.php");
?>