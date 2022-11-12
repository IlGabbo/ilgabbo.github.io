function getTotDays() {
    let p = document.getElementById("days");
    let input = document.getElementById("mese").value;
    let notValid = true
    let day31 = [
        "gennaio",
        "marzo",
        "maggio",
        "luglio",
        "agosto",
        "ottobre",
        "dicembre"
    ]

    let day30 = [
        "aprile",
        "giugno",
        "settembre",
        "novembre"
    ]

    for (let i = 0; i < 12; i++) {
        if (input.toLowerCase() === day31[i]) {
            p.innerHTML = "31 giorni"
            notValid = false
        }

        if (input.toLowerCase() === "febbraio") {
            p.innerHTML = "28 giorni"
            notValid = false
        }

        if (input.toLowerCase() === day30[i]) {
            p.innerHTML = "30 giorni"
            notValid = false
        }
    }

    if (notValid === true) {
        p.innerHTML = "Mese non valido"
    }
}

function isOkorNot() {
    let inputVoto = document.getElementById("voto").value;
    let par = document.getElementById("isOkOrNot");
    par.style.fontWeight = "bold";
    if (parseFloat(inputVoto) < 6.0) {
        par.style.color = "red";
        par.innerHTML = "Insufficiente";

    } else if (parseFloat(inputVoto) >= 6 && parseFloat(inputVoto) <= 6.9) {
        par.style.color = "yellow";
        par.innerHTML = "Sufficiente";

    } else if (parseFloat(inputVoto) >= 8.0) {
        par.style.color = "green";
        par.innerHTML = "Buono";

    }
}

function HoursAndMinutes() {
    let inputOra = document.getElementById("ora").value;
    let inputMinuto = document.getElementById("minuti").value;
    let parOrario = document.getElementById("clock");
    let millisecOra = inputOra * 3600000;
    let millisecMin = inputMinuto  *60000;
    parOrario.innerHTML = "Ora " + inputOra + ": " + millisecOra + " millisecondi, minuti " + inputMinuto + ": " + millisecMin + " millisecondi"
}

function fromFareToCels() {
    //(50 °F - 32) × 5/9 = 10 °C
    let inputGradi = document.getElementById("gradi").value;
    let risultatoGradi = document.getElementById("celsiusResult");
    let risultato = ((parseFloat(inputGradi) - 32) * (5 / 9));
    risultatoGradi.innerHTML = risultato.toFixed(2) + "°C";
}

function timeConverter() {
    let inputOrario = document.getElementById("orario").value;
    let inputMin = document.getElementById("min").value;
    let risultatoConv = document.getElementById("timeConverted");
    let date = new Date();
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let day = date.getDate();
    let fkDate = day + "-" + month + "-" + year;
    let d = new Date(fkDate.toString() + " " + inputOrario.toString() + ":" + inputMin.toString());
    let newyork = d.toLocaleString('en-US', { timeZone: 'America/New_York' });
    let tokyo = d.toLocaleString('en-JP', { timeZone: 'Asia/Tokyo' });
    let mosca = d.toLocaleString('en-RU', { timeZone: 'Europe/Moscow' });
    risultatoConv.innerHTML = "New York: " + newyork + ", Tokyo: " + tokyo + ", Mosca: " + mosca;   
}



