<?php
  function equazione($ax, $bx, $c) {
    $delta = pow($bx, 2) - 4 * ($ax * isset($c) ? floatval($c) : 0);
    if ($delta < 0) {
      return "Non ammette alcuna soluzione reale";
    }
    $x1 = (-$bx + sqrt($delta)) / (2 * $ax);
    if ($delta == 0) {
      return "Ammette una sola soluzione ".number_format($x1);
    }
    $x2 = (-$bx - sqrt($delta)) / (2 * $ax);

    return number_format($x1, 3)." ".number_format($x2, 3);
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
    <input type="number" name="ax" placeholder="ax" required>
    <input type="number" name="bx" placeholder="bx" required>
    <input type="number" name="c" placeholder="c">
    <input type="submit" value="SEND">
  </form>
  <?php
    if (isset($_POST["ax"]) && isset($_POST["bx"])) {
      echo equazione($_POST["ax"], $_POST["bx"], $_POST["c"]);
    }
  ?>
</body>
</html>
