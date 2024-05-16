<?php
  require __DIR__ . '/db.php';

  global $conn;

  function getMovies($title) {
    $conn = db();
    $sql = "SELECT * FROM movie";

    if (isset($title) || $title !== null) {
      $sql .= " WHERE title LIKE '%$title%'";
    }

    $result = $conn->query($sql)->fetch_all(MYSQLI_ASSOC);
    return $result;
  }

  function getActors($name) {
    $conn = db();
    $sql = "SELECT * FROM person WHERE category = 'actor'";

    if (isset($name) || $name !== null) {
      $sql .= " AND name LIKE '%$name%'";
    }

    $result = $conn->query($sql)->fetch_all(MYSQLI_ASSOC);
    return $result;
  }

  function getDirectors($name) {
    $conn = db();
    $sql = "SELECT * FROM person WHERE category = 'director'";

    if (isset($name) || $name !== null) {
      $sql .= " AND name LIKE '%$name%'";
    }

    $result = $conn->query($sql)->fetch_all(MYSQLI_ASSOC);
    return $result;
  }
?>