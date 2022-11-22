
navigator.geolocation.getCurrentPosition(showPosition);

function showPosition(position) {
   document.write("<iframe style='width: 100%; height: 50vh;' src='https://www.google.com/maps/search/"+ position.coords.latitude + "," + position.coords.longitude + "frameborder='0'></iframe>")
   document.write("Lat: " + position.coords.latitude + " ,Lon: " + position.coords.longitude)
   // https://www.google.com/maps/search/
}
