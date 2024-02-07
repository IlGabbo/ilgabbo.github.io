<?php 
  session_start();

  if (!isset($_SESSION["logged"])) {
    echo "401 - Unauthorized";
    exit();
  }

  echo "
    <a href='../actions/insert_reviews.php'>Inserimento recensioni</a>
    <a href='../actions/last_reviews.php'>Visualizza ultime recensioni</a>
    <a href='../actions/summary.php'>Visualizza riepilogo</a>
    <a href='./logout.php'>Logout</a>
  ";
?>
