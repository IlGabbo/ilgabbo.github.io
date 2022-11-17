document.getElementById("celsius-convert").addEventListener("submit", fromFareToCels)

function fromFareToCels(e) {
    e.preventDefault()
    //(50 °F - 32) × 5/9 = 10 °C
    let inputGradi = document.getElementById("gradi").value;
    let risultatoGradi = document.getElementById("celsiusResult");
    let risultato = ((parseFloat(inputGradi) - 32) * (5 / 9));
    risultatoGradi.innerHTML = risultato.toFixed(2) + "°C";
}