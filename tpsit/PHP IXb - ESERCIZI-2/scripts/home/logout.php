<?php
  session_start();
  if (!isset($_SESSION["logged"])) {
    header("Location: index.html");
  }
  session_destroy();
  session_abort();
  header("Location: ../../index.html");
?>