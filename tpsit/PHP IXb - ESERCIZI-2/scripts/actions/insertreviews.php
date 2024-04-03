<?php
  session_start();
  if (!isset($_SESSION["logged"])) {
    header("Location: ../../index.html");
    exit();
  }

  /**
   * Ricevo dalla richiesta post i dati relativi al destinazione e alla recensione
   */
  $destination = isset($_POST["destination"]) ? $_POST["destination"] : null;
  $review = isset($_POST["review"]) ? $_POST["review"] : null;
  /**
   * Prendo la variabile di sessione settata nel login
   */
  $user_who_reviewed = isset($_SESSION["username"]) ? $_SESSION["username"] : null;

  /**
   * Verifico che i valori non siano nulli
   */
  if ($destination && $review && $review !== "null") {
    /**
     * Pusho nell'array di sessione creato al momento di login i valori ottenuti dalla richiesta e dalla sessione
     */
    array_push($_SESSION[$destination . "_reviews"], array(0 => $user_who_reviewed, 1 => $review));
    header("Location: ./insert_reviews.php?review_sent=true");
  } else {
    header("Location: ./insert_reviews.php");
  }
?>
