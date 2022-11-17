document.getElementById("time-zone").addEventListener("submit", timeConverter)

function timeConverter(e) {
    e.preventDefault()
    let inputOrario = document.getElementById("orario").value;
    let inputMin = document.getElementById("min").value;
    let risultatoConv = document.getElementById("timeConverted");
    let date = new Date();
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let day = date.getDate();
    let fkDate = day + "-" + month + "-" + year;
    let d = new Date(fkDate.toString() + " " + inputOrario.toString() + ":" + inputMin.toString());
    console.log(fkDate)
    let newyork = d.toLocaleString('en-US', { timeZone: 'America/New_York' });
    let tokyo = d.toLocaleString('en-JP', { timeZone: 'Asia/Tokyo' });
    let mosca = d.toLocaleString('en-RU', { timeZone: 'Europe/Moscow' });
    risultatoConv.innerHTML = "New York: " + newyork + ", Tokyo: " + tokyo + ", Mosca: " + mosca;   
}