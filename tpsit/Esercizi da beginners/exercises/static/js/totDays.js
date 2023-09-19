document.getElementById("get-month-days").addEventListener("submit", getTotDays)


function getTotDays(e) {
    e.preventDefault()
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