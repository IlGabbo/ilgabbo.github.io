let result = document.querySelector("#result")

let users = []
let parameters = ["name", "last_name", "age", "genre"]

document.querySelector("#submit").addEventListener("click", e => {
    let data = new Object()
    let i = 0
    ;[document.querySelector("#name"), document.querySelector("#last-name"), document.querySelector("#age"), document.querySelector("#genre")].forEach(
        elem => {
            data[parameters[i]] = elem.value
            i++
        }
    )
    users.push(data) 
    result.innerHTML = ""
    users.forEach(user => {
        result.innerHTML += JSON.stringify(user) + "<br/>"
    })
})