<?php
  $array = array();
  $pari = array();
  $dispari = array();

  /* a */
  echo "<strong>Algoritmo di ribaltamento di un vettore</strong><br/><strong>";
  for ($i = 0; $i < 10; $i++) {
    $array[$i] = rand(10, 100);
    echo $array[$i] . " ";
  }
  echo "<br/>";
  for ($i = sizeof($array) - 1; $i >= 0; $i--) {
    echo $array[$i] . " ";
  }

  echo "</strong><br/>";

  /* b */
  for ($i = 0; $i < 20; $i++) {
    $array[$i] = rand(0, 100);
    
    if ($array[$i] % 2 == 0) {
      $pari[$i] = $array[$i];
    } else {
      $dispari[$i] = $array[$i];
    }
  }
  $pari_quantita = sizeof($pari);
  $dispari_quantita = sizeof($dispari);
  echo "<br/>Quantità numeri pari: ".$pari_quantita."<br/>Quantità numeri dispari: ".$dispari_quantita."<br/>";
  echo "Pari:";
  foreach ($pari as $p) {
    echo " ".$p;
  }
  echo "<br/>Dispari:";
  foreach ($dispari as $d) {
    echo " ".$d;
  }
  echo "<br/>";

  /* c */
  $duplicati = array();
  for ($i = 0; $i < 20; $i++) {
    $array[$i] = rand(0, 100);
  }

  $counter = array_count_values($array);
  $maxrep = max($counter);
  $numero = array_search($maxrep, $counter);
  if ($maxrep > 1) {
    echo "<br/>Numeri ripetuti trovati";
    echo "<br/>Il numero ".$numero." si ripete ".$maxrep." volte.<br/>";
  } else {
    echo "<br/>Nessun numero ripetuto trovato";
  }
?>