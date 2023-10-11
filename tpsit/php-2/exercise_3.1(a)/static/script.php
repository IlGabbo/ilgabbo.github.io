<?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $variabile = $_POST["primoNumero"];

        $intero = (int)$variabile;
        $float = (float)$variabile;
        $boolean = filter_var($variabile);
        $string = (string)$variabile;

        echo "Trasformata in integer vale -->$intero
        <br/>
        Trasformata in float vale -->$float
        <br/>
        Trasformata in boolean vale -->",$boolean ? "true" : "false","
        <br/>
        Trasformata in string vale -->$string";
    }
?>