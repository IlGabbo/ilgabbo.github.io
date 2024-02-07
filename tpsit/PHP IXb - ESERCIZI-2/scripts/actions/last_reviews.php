<?php
  session_start();
  if (!isset($_SESSION["logged"])) {
    header("Location: ../../index.html");
  }

  $destinations = [
    "france",
    "spain",
    "italy"
  ];

  echo "
    <a href='./insert_reviews.php'>Inserisci una recensione</a>
    <a href='./summary.php'>Pagina di riepilogo</a><br/>
  ";

  for ($i = 0; $i < count($destinations); $i++) {
    echo $destinations[$i] . ":<br/>";

    for ($j = count($_SESSION[$destinations[$i] . "_reviews"]); $j >= count($_SESSION[$destinations[$i] . "_reviews"])-3; $j--) {
      if ($j >= 0) {
        $user = isset($_SESSION[$destinations[$i] . "_reviews"][0][0]) ? $_SESSION[$destinations[$i] . "_reviews"][0][0] : null;
        $review = isset($_SESSION[$destinations[$i] . "_reviews"][0][1]) ? $_SESSION[$destinations[$i] . "_reviews"][0][1] : null;

        if (isset($user) && isset($review)) {
          echo "$user: $review <br/>";
        }
      }
    }
    echo "<br>";
  }
