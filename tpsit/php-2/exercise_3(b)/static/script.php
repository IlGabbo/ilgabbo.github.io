<?php
    $numero_uno = $_POST["numero_uno"];
    $numero_due = $_POST["numero_due"];

    switch ($_POST["operazioneLogica"]) {
        case "and":
            echo decbin($numero_uno & $numero_due);
            break;
        case "or":
            echo decbin($numero_uno | $numero_due);
            break;
        case "xor":
            echo decbin($numero_uno ^ $numero_due);
            break;
        default:
            echo "numeri non validi";
            break;
    }
?>