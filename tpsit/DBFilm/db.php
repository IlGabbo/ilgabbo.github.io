<?php
function db() {
  $host = '192.168.1.100';  // 172.17.0.2
  $conn = mysqli_connect($host, 'root', 'root', 'FilmAPI');

  if ($conn->connect_error) {
    return die('F');
  }

  return $conn;
}

