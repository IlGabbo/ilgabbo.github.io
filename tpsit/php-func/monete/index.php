<?php
  function calc($value) {
    $total = $value / 100;
    $euro = floor($total);
    $cents = $total - $euro;

    switch ($euro) {
      case $euro > 2:
        $two_euros = $euro / 2;
        break;
    }
    if (isset($two_euros)) {
      echo $two_euros." monete da 2";
    }
    
    return $total;
  } 
  # php -S 127.0.0.1:80 -t .
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
    <h1>Calcolatore del numero minimo di monete</h1>
    <p>Inserire l'importo (in centesimi, es 134 equivale a €1.34)</p>
    <input type="number" name="value" required>
    <input type="submit" name="send" id="send" value="Invia">
  </form>
  <?php
    $value = isset($_POST["value"]);
    if (isset($_POST["value"])) {
      echo "€".calc($_POST["value"]);
    }
  ?>
</body>
</html>