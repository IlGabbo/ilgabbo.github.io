<?php
    $numero = $_POST["numero"];

    switch ($_POST["shift"]) {
        case "shiftDX":
            echo decbin($numero >> 1);
            break;
        case "shiftSX":
            echo decbin($numero << 1);
            break;
        case "not":
            echo decbin(~$numero);
            break;
        default:
            echo "numero non valido";
            break;
    }
?>