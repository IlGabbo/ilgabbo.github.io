<?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $primoNumero = $_POST["primoNumero"];
        $secondoNumero = $_POST["secondoNumero"];

        echo "MCD: ", mcd($primoNumero, $secondoNumero) ,"<br>";
        echo "MCM: ", mcm($primoNumero, $secondoNumero) ,"<br>";
    }

    function mcd($primoNumero, $secondoNumero) {
        while($secondoNumero != 0)
        {
            $i = $secondoNumero;
            $secondoNumero = $primoNumero % $secondoNumero;
            $primoNumero = $i;
        }
        return $primoNumero;
    }

    function mcm($primoNumero, $secondoNumero) {
        return ($primoNumero * $secondoNumero) / mcd($primoNumero,$secondoNumero);
    }
?>