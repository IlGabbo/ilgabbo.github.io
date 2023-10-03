<?php
  $locality = $_GET["locality"];
  $date = $_GET["date"];
  $hour = $_GET["hour"];
  $revelation_type = $_GET["revelation_type"];
  $humidity = $_GET["humidity"];
  $current_climate = $_GET["current_climate"];
  $altitude = $_GET["altitude"];

  echo "
    Locality $locality,
    Date $date,
    Hour $hour,
    Revelation Type $revelation_type,
    Humidity $humidity,
    Current climate $current_climate,
    Altitude $altitude
  ";
?>