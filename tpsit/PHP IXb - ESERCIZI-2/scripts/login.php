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

  session_start();
  $_SESSION["logged"] = true;
  $_SESSION["username"] = $username;
  
  $_SESSION["france_reviews"] = array();
  $_SESSION["spain_reviews"] = array();
  $_SESSION["italy_reviews"] = array();

  header("Location: ./home/index.php");
?>