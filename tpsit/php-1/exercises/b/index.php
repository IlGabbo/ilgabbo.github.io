<?php
  $name = $_GET["name"];
  $lastname = $_GET["lastname"];
  $businessname = $_GET["businessname"];
  $address = $_GET["address"];
  $piva = $_GET["piva"];
  $phonenumber = $_GET["phonenumber"];
  $description = $_GET["description"];
  $code = $_GET["code"];
  $stock = $_GET["stock"];
  $unitprice = $_GET["unitprice"];
  $ivapercent = $_GET["ivapercent"];
  $quantity = $_GET["quantity"];
  $discount = $_GET["discount"];

  if ($discount) {
    $total_price = ($unitprice * $discount) / 100;
    $total_price = $total_price * $quantity;
  } else {
    $total_price = $unitprice * $quantity;
  }

  echo "
  <table border='1'>
    <tr>
      <th>
        Name
      </th>
      <th>
        Last name
      </th>
      <th>
        Business name
      </th>
      <th>
        Address
      </th>
      <th>
        P Iva
      </th>
      <th>
        Phonenumber
      </th>
    </tr>
    <tr>
      <td>
        $name
      </td>
      <td>
        $lastname
      </td>
      <td>
        $businessname
      </td>
      <td>
        $address
      </td>
      <td>
        $piva
      </td>
      <td>
        $phonenumber
      </td>
    </tr>
  </table>
  <table border='1'>
    <tr>
      <th>
        Product description
      </th>
      <th>
        Product code
      </th>
      <th>
        Product Stock
      </th>
      <th>
        Unit price
      </th>
      <th>
        Iva %
      </th>
      <th>
        Quantity
      </th>
      <th>
        Discount
      </th>
      <th>
        Total
      </th>
    </tr>
    <tr>
      <td>
        $description
      </td>
      <td>
        $code
      </td>
      <td>
        $stock
      </td>
      <td>
        $unitprice
      </td>
      <td>
        $ivapercent
      </td>
      <td>
        $quantity
      </td>
      <td>
        $discount
      </td>
      <td>
        $total_price
      </td>
    </tr>
  </table>
  ";
?>