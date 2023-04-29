let copyBtn = document.querySelector("#copy-btn")

document.querySelectorAll("chuck-norris-title").forEach(chuckTitle => chuckTitle.innerHTML = "JOKE CHUCK NORRIS")
document.querySelectorAll("chuck-norris-gif").forEach(chuckGif => {
    chuckGif.style.backgroundImage = `url(${chuckGif.getAttribute("src")})` 
})


document.querySelector("chuck-norris-getjoke").addEventListener("click", () => {
    let genre = document.querySelector("select").value
    let jokeBox = document.querySelector("chuck-norris-joke")
    let url = "https://api.chucknorris.io/jokes/random"
    if (genre !== "choice") {
        url += `?category=${genre.toLowerCase()}`
    }

    fetch(url)
        .then(data => {            
            return data.json()
        })
        .then(joke => {
            if (joke.value == undefined) {
                jokeBox.innerHTML = "Bruh error, retry later"
                return
            }
            jokeBox.innerHTML = ""
            let p = document.createElement("p")
            let a = document.createElement("a")
            p.setAttribute("id", "joke")
            p.innerHTML = joke.value
            a.setAttribute("href", joke.url)
            a.setAttribute("target", "_blank")
            a.innerHTML = "Joke Here"
            jokeBox.appendChild(p)
            jokeBox.appendChild(a)            
        })
        .catch(err => {
            jokeBox.innerHTML = "Bruh error, retry later"
            console.error(err)
        })
})

copyBtn.addEventListener("click", () => {
    let joke = document.querySelector("#joke")
    if (joke == null) {
        alert("First get a joke")
        return
    }
    navigator.clipboard.writeText(joke.innerHTML).then(() => {
        copyBtn.innerHTML = "Copied"
        setTimeout(() => {copyBtn.innerHTML = "Copy"}, 2000)
    }).catch(err => {console.error(err)})
})