<?php
  session_start();
  if (!isset($_SESSION['logged'])) {
    header("Location: ../../index.html");
    exit;
  }
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Inserisci recensioni</title>
</head>
<body>
  <a href="./last_reviews.php">Visualizza recensioni</a>
  <form action="./insertreviews.php" method="POST">
    <label for="">
      Seleziona una meta
      <select name="destination" id="destination">
        <option value="france">Francia</option>
        <option value="spain">Spagna</option>
        <option value="italy">Italia</option>
      </select>
    </label>
    <p>Scegli un punteggio</p>
    <select name="review" id="review">
      <option value="null" selected>-- scegli --</option>
      <option value="5-Scarsa">5-Scarsa</option>
      <option value="6-Mediocre">6-Mediocre</option>
      <option value="7-Sufficiente">7-Sufficiente</option>
      <option value="8-Buona">8-Buona</option>
      <option value="9-Discreta">9-Discreta</option>
      <option value="10-Ottima">10-Ottima</option>
    </select>
    <button type="submit">Invia</button>
  </form>
  <?php
    if (isset($_SERVER["QUERY_STRING"][0])) {
      echo "<p>Recensione inviata con successo</p>";
    }
  ?>
</body>
</html>
