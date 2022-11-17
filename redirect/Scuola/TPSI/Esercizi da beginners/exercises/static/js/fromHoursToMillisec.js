document.getElementById("time-converter").addEventListener("submit", HoursAndMinutes)

function HoursAndMinutes(e) {
    e.preventDefault()
    let inputOra = document.getElementById("ora").value;
    let inputMinuto = document.getElementById("minuti").value;
    let parOrario = document.getElementById("clock");
    let millisecOra = inputOra * 3600000;
    let millisecMin = inputMinuto  *60000;
    parOrario.innerHTML = "Ora " + inputOra + ": " + millisecOra + " millisecondi, minuti " + inputMinuto + ": " + millisecMin + " millisecondi"
}