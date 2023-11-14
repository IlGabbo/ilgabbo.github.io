<?php
  $days_of_month = cal_days_in_month(CAL_GREGORIAN, date("m"), date("y"));

  echo "<form action='enterdate.php' method='post'>";
  echo "Enter your birthday</br>";

  echo "
    Day
    <select name='day'>";
  for ($i = 1; $i <= $days_of_month; $i++) {
    echo "<option value='$i'>$i</option>";
  }
  echo "</select></br>";

  echo "
    Month
    <select name='month'>
  ";
  for ($i = 1; $i <= 12; $i++) {
    echo "<option value='$i'>$i</option>";
  }
  echo "</select></br>";
  echo "Year<input type='number' name='year'/></br>";
  echo "<input type='submit' value='Submit'/>";
  echo "<input type='reset' value='reset'/>";
  echo "</form>";


  /* Script */
  if (isset($_POST['year']) && isset($_POST['month']) && isset($_POST['day'])) {
    $year = $_POST['year'];
    $month = $_POST['month'];
    $day = $_POST['day'];

    $current_date = date("y-m-d");
    $startDate = new DateTime($current_date);
    $typedDate = new DateTime("$year-$month-$day");

    $diff = $startDate->diff($typedDate);
    $daysPassed = $diff->days;
    echo "
    Between your birthday: $year-$month-$day</br>
    and today: $current_date</br>
    you have passed $daysPassed days
    ";
  }
?>