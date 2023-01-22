let music = new Audio("static/music/music.ogg")
let pop = new Audio("static/music/pop.ogg")
let win = new Audio("static/music/levelup.ogg")
let general = 0.2
let music_volume_slide = document.getElementById("music-volume")
let general_volume = document.getElementById("general-volume")
let volume_icon = document.getElementById("volume-icon")
let th = document.querySelectorAll("th")
let thSp = document.querySelectorAll(".table tr th")
let tr = document.querySelectorAll("tr")
let difficulty = "easy"
let inc = 0
let incRow = 0
let value = null
let cells = [
    [null, null, null],  // 0
    [null, null, null],  // 1
    [null, null, null]   // 2
]
let count = 0
let volume_mute = true         
let is_x_written = false                     
music.loop = true               

function loadMusic() {
    music.play()
}

function showHideSettings() {
    document.getElementById("settings-window").classList.toggle("show-hide")
}

function openMultiplayer() {
    document.getElementById('game').style.display = 'flex'
    let click = new Audio("static/music/click.ogg")
    click.volume = general
    click.play()
    multiplayer()
}

function openSp() {
    document.getElementById('sp').style.display = 'flex'
    let click = new Audio("static/music/click.ogg")
    click.volume = general
    click.play()
    document.querySelector(".close-window").addEventListener("click", (e) => {
        document.querySelector(".difficulty").style.display = "none"
        playWithBot(difficulty)
    })
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

function resetGame(src) {
    if (src != null) {
        let reset_audio = new Audio(src)
        reset_audio.volume = general
        reset_audio.play()
        th.forEach(th => th.innerHTML = "")
        cells = [
            [null, null, null],  // 0
            [null, null, null],  // 1
            [null, null, null]   // 2
        ]
        is_x_written = false
        value = null
        count = 0
    }
}

function playWithBot(difficulty) {    
    console.log(difficulty)
    let available_cells = [
        [1,2,3],
        [1,2,3],
        [1,2,3]
    ]
    switch(difficulty) {
        case "easy":
            thSp.forEach(th => th.addEventListener("click", () => {
                win.volume = general
                if (th.textContent == "") {
                    /* value = "X"
                    th.innerHTML = value */
                    cells[th.parentNode.getAttribute("row")][th.getAttribute("cell")] = value
                    available_cells[th.parentNode.getAttribute("row")][th.getAttribute("cell")] = null
                    pop.src = "static/music/pop.ogg"
                    let row = Math.floor(Math.random()*available_cells.length)
                    let cell = Math.floor(Math.random()*row)

                    do {
                        row = Math.floor(Math.random()*available_cells.length)
                        cell = Math.floor(Math.random()*row)
                    } while (cells[row][cell] != null && available_cells[row][cell] != null)
                    available_cells[row][cell] = null
                    cells[row][cell] = "O"
                    console.log(cells)
                    console.log(available_cells)
                    console.log(th)

                } else {
                    pop.src = "static/music/break.ogg"           
                }
                read()
                pop.volume = general
                pop.play()
            }))
            break
    }
}

function read() {
    thSp.forEach(th => {
        console.log(cells[incRow][inc])
        th.innerHTML = cells[incRow][inc]
        inc++
        if (inc >= 3) {
            inc = 0
            incRow += 1
        }
    })
}




music_volume_slide.addEventListener("input", (e) => {
    music.volume = e.currentTarget.value/100
    document.getElementById("volume-status").innerHTML = `Music: ${e.currentTarget.value}%`
})

general_volume.addEventListener("input", (e) => {
    general = e.currentTarget.value/100
    document.getElementById("general-volume-status").innerHTML = `General Volume: ${e.currentTarget.value}%`
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

function multiplayer() {
    th.forEach(th => th.addEventListener("click", () => {
        win.volume = general
        if (th.textContent == "") {
            pop.src = "static/music/pop.ogg"
            if (!is_x_written) {
                value = "X"
                th.innerHTML = value            
                is_x_written = true
            } else {
                value = "O"
                th.innerHTML = value
                is_x_written = false
            }
            count++
        } else {
            pop.src = "static/music/break.ogg"
        }
    
        cells[th.parentNode.getAttribute("row")][th.getAttribute("cell")] = value
    
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
        pop.volume = general
        pop.play()    
    }))
}


document.getElementById("reset").addEventListener("click", () => resetGame("static/music/anvil_land.ogg"))

document.getElementById("home").addEventListener("click", () => {
    resetGame("static/music/click.ogg")
    document.getElementById("game").style.display = "none"
})
document.querySelector(".difficulty-selector").addEventListener("click", (e) => {
    let button = e.currentTarget
    switch(button.textContent) {
        case "Easy":
            button.innerHTML = "Medium"
            button.style.backgroundImage = "url(static/images/background/medium_button.png)"
            difficulty = "medium"
            break
        case "Medium":
            button.innerHTML = "Hard"
            button.style.backgroundImage = "url(static/images/background/hard_button.png)"
            difficulty = "hard"
            break
        case "Hard":
            button.innerHTML = "Easy"
            button.style.backgroundImage = "url(static/images/background/easy_button.png)"
            difficulty = "easy"
            break  
    }
})


