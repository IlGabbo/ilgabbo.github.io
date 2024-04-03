<?php
  session_start();
  if (!isset($_SESSION["logged"])) {
    header("Location: index.html");
  }

  /**
   * session_destroy() cancella tutte le variabili di sessione
   */
  session_destroy();

  /**
   * session_abort() cancella tutte le variabili di sessione e chiude la sessione
   */
  session_abort();
  header("Location: ../../index.html");
?>