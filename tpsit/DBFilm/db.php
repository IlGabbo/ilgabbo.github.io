<?php
$host = '172.17.0.2';
$conn = mysqli_connect($host, 'root', 'root', 'FilmAPI');

if ($conn->connect_error) {
  return null;
}