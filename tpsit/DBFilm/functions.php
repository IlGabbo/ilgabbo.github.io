<?php
  include './db.php';
  function getMovies($title) {
    if ($conn->connect_error) {
      return null;
    }

    $sql = "SELECT * FROM movie";

    if (isset($title) || $title !== null) {
      $sql .= " WHERE title LIKE '%$title%'";
    }

    $result = $conn->query($sql)->fetch_all(MYSQL_ASSOC);
    return $result;
  }

  function getActors($name) {
    if ($conn->connect_error) {
      return null;
    }

    $sql = "SELECT * FROM person WHERE category = 'actor'";

    if (isset($name) || $name !== null) {
      $sql .= " AND name LIKE '%$name%'";
    }

    $result = $conn->query($sql)->fetch_all(MYSQL_ASSOC);
    return $result;
  }

  function getDirectors($name) {
    if ($conn->connect_error) {
      return null;
    }

    $sql = "SELECT * FROM person WHERE category = 'director'";

    if (isset($name) || $name !== null) {
      $sql .= " AND name LIKE '%$name%'";
    }

    $result = $conn->query($sql)->fetch_all(MYSQL_ASSOC);
    return $result;
  }
?>