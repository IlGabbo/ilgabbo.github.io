
navigator.geolocation.getCurrentPosition(showPosition);

function showPosition(position) {
   document.write("Latitude: " + position.coords.latitude + " Longitude: " + position.coords.longitude);
}
