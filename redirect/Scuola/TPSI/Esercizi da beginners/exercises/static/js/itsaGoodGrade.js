document.getElementById("its-a-good-grade").addEventListener("submit", isOkorNot)

function isOkorNot(e) {
    e.preventDefault()
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











