<?php
  $user_name = "gabbo";
  $user_password = "1234";

  $name = $_POST["name"];
  $password = $_POST["password"];
  
  if ($name === $user_name && $password === $user_password) {
    $html = isset($_POST["html"]) ? $_POST["html"] : null;
    $images = isset($_POST["images"]) ? $_POST["images"] : null;
    $url_links = isset($_POST["url_links"]) ? $_POST["url_links"] : null;
    $media_objs = isset($_POST["multi_media-objects"]) ? $_POST["multi_media-objects"] : null;
    $xhtml = isset($_POST["xhtml"]) ? $_POST["xhtml"] : null;

    echo "
      <table border=1>
        <tr>
          <th>
            Name
          </th>
          <th>
            Password
          </th>
          <th>
            Arguments
          </th>
        </tr>
        <tr>
          <td>
            $name
          </td>
          <td>
            $password
          </td>
          <td>
            $html<br/>
            $images<br/>
            $url_links<br/>
            $media_objs<br/>
            $xhtml<br/>
          </td>
        </tr>
      </table>
    ";
  } else {
    echo "Username or password not valid";
  }
?>