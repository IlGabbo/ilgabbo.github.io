let music = new Audio("static/music/music.ogg")
let volume_slide = document.getElementById("volume")
let volume_icon = document.getElementById("volume-icon")
let th = document.querySelectorAll("th")
let tr = document.querySelectorAll("tr")
let value = null
let cells = [
    [null, null, null],  // 0
    [null, null, null],  // 1
    [null, null, null]   // 2
]
let count = 0
let volume_mute = true         
let is_x_writed = false                     
music.loop = true                

function loadMusic() {
    music.play()
}

function volume(value) {
    music.volume = parseInt(value/100)
    document.getElementById("volume-status").innerHTML = `Volume: ${value}`
}

function showHideSettings() {
    document.getElementById("settings-window").classList.toggle("show-hide")
}

function checkVictory(cells) {
    for (let i = 0; i < 3; i++) {
        if (cells[i][0] === cells[i][1] && cells[i][1] === cells[i][2]) {
            return cells[i][0]
        }
    }

    for (let i = 0; i < 3; i++) {
        if (cells[0][i] === cells[1][i] && cells[1][i] === cells[2][i]) {
            return cells[0][i]
        }
    }
    
    if (cells[0][0] === cells[1][1] && cells[1][1] === cells[2][2]) {
        return cells[0][0]
    }
    if (cells[0][2] === cells[1][1] && cells[1][1] === cells[2][0]) {
        return cells[0][2]
    }
}

function resetGame() {
    let reset_audio = new Audio("static/music/anvil_land.ogg")
    reset_audio.volume = 0.3
    reset_audio.play()
    th.forEach(th => th.innerHTML = "")
    cells = [
        [null, null, null],  // 0
        [null, null, null],  // 1
        [null, null, null]   // 2
    ]
    is_x_writed = false
    value = null
    count = 0
}


volume_slide.addEventListener("input", (e) => {
    music.volume = e.currentTarget.value/100
    document.getElementById("volume-status").innerHTML = `Volume: ${e.currentTarget.value}`
})


volume_icon.addEventListener("click", () => {
    if (volume_mute) {
        volume_icon.style.backgroundImage = "url(static/images/icon/volume-on.svg)"
        music.play()
        volume_mute = false
    } else {
        volume_icon.style.backgroundImage = "url(static/images/icon/volume-mute.svg)"
        music.pause()
        volume_mute = true
    }
})

th.forEach(th => th.addEventListener("click", () => {
    let pop = new Audio("static/music/pop.ogg")
    let win = new Audio("static/music/levelup.ogg")
    win.volume = 0.5
    if (th.textContent == "") {
        if (!is_x_writed) {
            value = "X"
            th.innerHTML = value            
            is_x_writed = true
        } else {
            value = "O"
            th.innerHTML = value
            is_x_writed = false
        }
    } else {
        pop.src = "static/music/break.ogg"
    }

    cells[th.parentNode.getAttribute("row")][th.getAttribute("cell")] = value
    count++
    console.log(checkVictory(cells))
    if (checkVictory(cells) == "X") {
        document.querySelector("#status").style.display = "flex"
        document.querySelector(".winner").innerHTML = "'X' won"
        win.play()
    } else if (checkVictory(cells) == "O") {
        document.querySelector("#status").style.display = "flex"
        document.querySelector(".winner").innerHTML = "'O' won"
        win.play()
    } else if (count == 9) {
        document.querySelector("#status").style.display = "flex"
        document.querySelector(".winner").innerHTML = "Drawing"
        pop.src = "static/music/break.ogg"
    }
    pop.volume = 0.5
    pop.play()    
}))

document.getElementById("reset").addEventListener("click", resetGame)
document.getElementById("home").addEventListener("click", () => {
    resetGame()
    document.getElementById("game").style.display = "none"
})

