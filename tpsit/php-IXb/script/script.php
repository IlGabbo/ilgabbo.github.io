<?php
  session_start();
  $right_password = "123";

  $username = $_POST["username"];
  $password = $_POST["password"];

  $hashed = password_hash($password, PASSWORD_DEFAULT);

  if (password_verify($right_password, $hashed)) {
    $_SESSION["logged"] = true;
    $_SESSION["pag1"] = 0;
    $_SESSION["pag2"] = 0;
    $_SESSION["pag3"] = 0;
    echo "Bravo, ti sei loggato!<br/>";
    echo "<a href='./pagineprotette/menu.php'>premi un tasto per continuare</a>";
  } else {
    echo "Password errata!<br>";
  }
?>