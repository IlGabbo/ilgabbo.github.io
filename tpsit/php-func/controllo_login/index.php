<?php

  function controllo_login($user, $pass) {
    $USER = "admin";
    $PASSWD = '$2y$10$djIzpgybsvUncExipX3B/eu7rNpUyhbJaLHt2GHn4qAwiy/raebjy';

    if ($USER != $user) {
      return "Utente non trovato";
    }

    if (!password_verify($pass, $PASSWD)) {
      return "Password invalida";
    }

    return "Login e password ok!";
  }
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <form action="index.php" method="post">
    <input type="text" name="username" id="username" placeholder="Username"><br/>
    <br/>
    <input type="password" name="password" id="password" placeholder="Password"><br/>
    <br/>
    <input type="submit" value="Invia">
  </form>
  <?php
    if ($_SERVER["REQUEST_METHOD"] == "post") {
      return 400;
    }

    if (isset($_POST["username"]) && isset($_POST["password"])) {
      echo controllo_login($_POST["username"], $_POST["password"]);
    }
  ?>
</body>
</html>