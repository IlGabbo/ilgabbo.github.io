<?php
  session_start();
  if (!isset($_SESSION["logged"])) {
    header("Location: ../../index.html");
    exit();
  }

  $destination = isset($_POST["destination"]) ? $_POST["destination"] : null;
  $review = isset($_POST["review"]) ? $_POST["review"] : null;
  $user_who_reviewed = isset($_SESSION["username"]) ? $_SESSION["username"] : null;

  if ($destination && $review && $review !== "null") {
    array_push($_SESSION[$destination . "_reviews"], array(0 => $user_who_reviewed, 1 => $review));
    header("Location: ./insert_reviews.php?review_sent=true");
  } else {
    header("Location: ./insert_reviews.php");
  }
?>
