<?php
  require './functions.php';

  if ($_SERVER['REQUEST_METHOD'] === 'get') {
    if ($_SERVER['PATH_INFO'] === '/movies') {
      $movies = getMovies(isset($_GET['title']) ? $_GET['title'] : null);
      if ($movies === null) {
        http_response_code(500);
        header('Content-Type: application-json');
        echo json_encode([
          'status' => 500,
          'message' => 'Internal server error',
          'payload' => []
        ]);
        return;
      }
      http_response_code(200);
      header('Content-Type: application-json');
      echo json_encode([
        'status' => 200,
        'message' => 'OK',
        'payload' => $movies
      ]);
      return;
    }

    if ($_SERVER['PATH_INFO'] === '/actors') {
      $actors = getActors(isset($_GET['name']) ? $_GET['name'] : null);
      if ($actors === null) {
        http_response_code(500);
        header('Content-Type: application-json');
        echo json_encode([
          'status' => 500,
          'message' => 'Internal server error',
          'payload' => []
        ]);
        return;
      }
      http_response_code(200);
      header('Content-Type: application-json');
      echo json_encode([
        'status' => 200,
        'message' => 'OK',
        'payload' => $actors
      ]);
      return;
    }
    if ($_SERVER['PATH_INFO'] === '/directors') {
      $directors = getDirectors(isset($_GET['name']) ? $_GET['name'] : null);
      if ($directors === null) {
        http_response_code(500);
        header('Content-Type: application-json');
        echo json_encode([
          'status' => 500,
          'message' => 'Internal server error',
          'payload' => []
        ]);
        return;
      }
      http_response_code(200);
      header('Content-Type: application-json');
      echo json_encode([
        'status' => 200,
        'message' => 'OK',
        'payload' => $directors
      ]);
      return;
    }
  } else {
    http_response_code(405);
    header('Content-Type: application-json');
    echo json_encode([
      'status' => 405,
      'message' => 'Method Not Allowed',
      'payload' => []
    ]);
  }
?>