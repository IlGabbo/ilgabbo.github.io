<?php
  session_start();
  $logged = isset($_SESSION["logged"]);
  if (!$logged) {
    echo "Non autorizzato";
    die;
  }

  echo "Benvenuto";
  echo "
    <ol>
      <li>
        <a href='./pages/pag1.php'>Pagina 1</a>
      </li>
      <li>
        <a href='./pages/pag2.php'>Pagina 2</a>
      </li>
      <li>
        <a href='./pages/pag3.php'>Pagina 3</a>
      </li>
    </ol>
    <a href='./logout.php'>Esci</a>
  ";
?>