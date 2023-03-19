let music = new Audio("static/music/music.ogg")
let pop = new Audio()
let win = new Audio("static/music/levelup.ogg")
let click = new Audio("static/music/click.ogg")
let general = 0.2
let music_volume_slide = document.getElementById("music-volume")
let general_volume = document.getElementById("general-volume")
let volume_icon = document.getElementById("volume-icon")
let th = document.querySelectorAll("th")
let thSp = document.querySelectorAll(".table tr th")
let mainWindow = document.querySelector(".container")
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
let isPlayingThePlayer = true 
let isThereAWinner = false  
let difficulty;
music.loop = true      



function loadMusic() {
    music.play()
}

function showHideSettings() {
    document.getElementById("settings-window").classList.toggle("show-hide")
}

function openMultiplayer() {
    document.getElementById('sp').style.display = 'none'
    document.getElementById('game').style.display = 'flex'
    mainWindow.style.display = "none"
    click.volume = general
    click.play()
    isPlayingThePlayer = true    
    match()
}

function openSinglePlayer() {
    document.getElementById('game').style.display = 'none'
    document.getElementById('sp').style.display = 'flex'
    mainWindow.style.display = "none"
    click.volume = general
    click.play()
    document.querySelector(".close-window").addEventListener("click", (e) => {
        document.getElementById('sp').style.display = 'none'
        document.getElementById('game').style.display = 'flex' 
        click.play()
        isPlayingThePlayer = false
        difficulty = document.querySelector(".difficulty-selector").textContent
        let unavailable_difficulties = ["medium", "hard"]

        if (unavailable_difficulties.includes(difficulty.toLowerCase())) {
            console.log(true)
            mainWindow.style.display = "flex"
            document.getElementById('game').style.display = 'none'             
            return
        }
        match()
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
        isThereAWinner = false
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

function match() {
    th.forEach(th => th.addEventListener("click", () => {        
        pop.volume = general
        if (!isThereAWinner) {
            win.volume = general
            if (th.textContent == "") {
                pop.src = "static/music/pop.ogg"
                if (isPlayingThePlayer) {
                    if (!is_x_written) {
                        value = "X"                    
                        is_x_written = true
                        pop.play()
                    } else {
                        value = "O"                    
                        is_x_written = false
                        pop.play()
                    }
                    th.innerHTML = value
                    cells[th.parentNode.getAttribute("row")][th.getAttribute("cell")] = value  
                    count++
                } else {                                                                      
                    pop.play()
                    value = "X"
                    th.innerHTML = value 
                    cells[th.parentNode.getAttribute("row")][th.getAttribute("cell")] = value           
                    count++                                                      
                    switch (difficulty.toLowerCase()) {
                        case "easy": 
                            let emptyCellFound = false
                            for (let i = 0; i < cells.length; i++) {
                                if (!emptyCellFound) {
                                    for (let j = 0; j < cells[i].length; j++) {
                                        if (cells[i][j] == null) {                                    
                                            emptyCellFound = true
                                            cells[i][j] = "O"
                                            document.querySelector(`[row='${i}'] [cell='${j}']`).innerHTML = "O"   
                                            count++                                                         
                                            break
                                        }
                                    }
                                } else {
                                    break
                                }        
                            }    
                            console.log(cells)                  
                            break
                        default:
                            console.log("sas")
                            break
                    }
                }

                if (checkVictory(cells) == "X") {
                    document.querySelector("#status").style.display = "flex"
                    document.querySelector(".winner").innerHTML = "'X' won"
                    isThereAWinner = true
                    win.play()
                } else if (checkVictory(cells) == "O") {
                    document.querySelector("#status").style.display = "flex"
                    document.querySelector(".winner").innerHTML = "'O' won"
                    isThereAWinner = true
                    win.play()
                } else if (count == 9) {
                    document.querySelector("#status").style.display = "flex"
                    document.querySelector(".winner").innerHTML = "Drawing"
                    pop.src = "static/music/break.ogg"
                }
            } else {
                pop.src = "static/music/break.ogg"
                pop.play()
            }
        }        
    }))
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

document.getElementById("reset").addEventListener("click", () => resetGame("static/music/anvil_land.ogg"))

document.getElementById("home").addEventListener("click", () => {
    resetGame("static/music/click.ogg")
    mainWindow.style.display = "flex"
    isThereAWinner = false
    isPlayingThePlayer = true
    document.getElementById("game").style.display = "none"
})
document.querySelector(".difficulty-selector").addEventListener("click", (e) => {
    let button = e.currentTarget
    let coming_soon = document.getElementById("coming-soon")
    click.volume = general
    click.play()
    switch(button.textContent) {
        case "Easy":
            button.innerHTML = "Medium"
            button.style.backgroundImage = "url(static/images/background/medium_button.png)"
            coming_soon.style.display = "block"
            break
        case "Medium":
            button.innerHTML = "Hard"
            button.style.backgroundImage = "url(static/images/background/hard_button.png)"
            coming_soon.style.display = "block"
            break
        case "Hard":
            button.innerHTML = "Easy"
            button.style.backgroundImage = "url(static/images/background/easy_button.png)"
            coming_soon.style.display = "none"
            break  
    }    
})


