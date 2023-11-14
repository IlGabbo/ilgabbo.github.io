<?php
  $months = [
    null,
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
  ];
  $days = [
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday"
  ];

  $current_month = $months[date("m")];
  $current_day = $days[date("w")];
  $days_in_month = cal_days_in_month(CAL_GREGORIAN, date("m"), date("y"));
  $day_counter = 1;
  
  echo "
    <table border=1>
      <tr>
        <th>$current_month</th>
      </tr>
      <tr>
  ";
  foreach ($days as $day) {
    echo "<td>$day</td>";
  }
  echo "</tr>";
  echo "<tr>";

  $first_day_month = date('01-m-Y');
  $first_day_wk = date('w', strtotime($first_day_month));

  for ($i = 0; $i < 6; $i++) {
    echo "<tr>";

    for ($j = 0; $j < 7; $j++) {
      if ($i == 0 && $j < $first_day_wk) {
        echo "<td></td>";
      } else {
        $style = "";
        if ($day_counter == date('d')) {
          $style = "style='background-color: #ff0000;'";
        }
        echo "<td $style>".($day_counter <= $days_in_month ? $day_counter : '')."</td>";
        $day_counter++;
      }
    }
  }
  echo "</tr>";
  echo "</table>";
?>