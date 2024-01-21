<?php
  session_start();
  $logged = isset($_SESSION["logged"]);
  if (!$logged) {
    echo "Non autorizzato";
    die;
  }

  $_SESSION["pag3"]++;
  $visited = $_SESSION["pag3"];
  $sessionId = session_id();

  echo "Benvenuto nella pagina 3<br/>";
  echo "Questa pagina è stata visitata $visited volte<br/>";
  echo "La sessione corrente è $sessionId<br/>";
?>