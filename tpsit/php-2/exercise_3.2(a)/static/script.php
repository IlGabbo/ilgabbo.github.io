<?php
        $pubblicita = array(
            1 => array(
                "frase" => "BANNER NON IN VENDITA MA IN SVENDITA a soli 0€",
                "immagine" => "./images/banner.png"
            ),
            2 => array(
                "frase" => "TAVOLA 8 DI TTRG FATTA CON AUTOCAD a soli 104.000€",
                "immagine" => "./images/TAV 8.jpg"
            ),
            3 => array(
                "frase" => "AMMIRA QUESTE BELLISSIME FOGLIE E COMPRALE SU FIDATI.COM",
                "immagine" => "./images/FOGLIE.jpg"
            )
        );

        $randomNumber = rand(1,count($pubblicita));

        $randomOutput = $pubblicita[$randomNumber];

        $fraseRandom = $randomOutput["frase"];
        $immagineRandom = $randomOutput["immagine"];

        echo "Pubblicita':<br> <img src='$immagineRandom' alt='Immagine casuale'>
        <br> $fraseRandom";
?>