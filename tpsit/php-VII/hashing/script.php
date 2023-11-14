<?php
  if ($_SERVER["REQUEST_METHOD"] !== "POST") {
    die(400);
  }

  $err = false;

  if (empty($_POST["password"])) {
    echo "Password missed</br>";
    $err = true;
  }
  if (empty($_POST["repeat_password"])) {
    echo "Second password missed</br>";
    $err = true;
  }

  if (!$err) {
    $first_pass = password_hash($_POST["password"], PASSWORD_DEFAULT);
    $name = $_POST["name"];
    $address = $_POST["address"];

    if (password_verify($_POST["repeat_password"], $first_pass)) {
      echo "
        <table border=1>
          <tr>
            <th>Name</th>
            <th>Address</th>
          </tr>
          <tr>
            <td>$name</td>
            <td>$address</td>
          </tr>
        </table>
      ";
    } else {
      echo "Access Denied (passwords do not match)";
    }
  }
?>