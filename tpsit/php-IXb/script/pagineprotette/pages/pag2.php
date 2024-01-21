<?php
  session_start();
  $logged = isset($_SESSION["logged"]);
  if (!$logged) {
    echo "Non autorizzato";
    die;
  }

  $_SESSION["pag2"]++;
  $visited = $_SESSION["pag2"];
  $sessionId = session_id();

  echo "Benvenuto nella pagina 2<br/>";
  echo "Questa pagina è stata visitata $visited volte<br/>";
  echo "La sessione corrente è $sessionId<br/>";
?>