let blurredBg = document.querySelector(".blur")
let gameCnt = document.querySelector("#width-414")
let settings = document.querySelector(".settings-box")
let slider = document.querySelector("input[type=range]")
let sliderThumb = document.querySelector("input[type=range]")
let difficultyBox = document.querySelector(".difficulty")
let status = document.querySelector(".status")

let favicon = document.querySelector("#favicon")

let _default_dir = "./static/images/background/"

let data = {
    overworldTheme: {
        background: _default_dir + "world.jpg",
        settingsBackground: _default_dir + "dirt.jpg",
        difficultyBox: _default_dir + "stone.png"
    },
    netherTheme: {
        background: _default_dir + "nether.png",
        settingsBackground: _default_dir + "red_nether_bricks.png",
        difficultyBox: _default_dir + "respawn_anchor.png"
    }    
}

if (localStorage.getItem("theme") == null) {
    localStorage.setItem("theme", "world")
} 
switch (localStorage.getItem("theme")) {
    case "world":
        setTheme("world")
        break
    case "nether":
        setTheme("nether")
        break    
    default:
        setTheme("world")
        break
}

function setTheme(theme) {
    switch (theme) {
        case "world":
            blurredBg.style.backgroundImage = `url(${data.overworldTheme.background})`
            gameCnt.style.backgroundImage = `url(${data.overworldTheme.background})`
            settings.style.backgroundImage = `url(${data.overworldTheme.settingsBackground})`
            difficultyBox.style.backgroundImage = `url(${data.overworldTheme.difficultyBox})`
            status.style.backgroundImage = `url(${data.overworldTheme.settingsBackground})`
            status.style.border = "1px solid #000"
            favicon.setAttribute("href", "./static/images/icon/overworld.png")
            localStorage.setItem("theme", "world")
            break;
        case "nether":
            blurredBg.style.backgroundImage = `url(${data.netherTheme.background})`
            gameCnt.style.backgroundImage = `url(${data.netherTheme.background})`
            settings.style.backgroundImage = `url(${data.netherTheme.settingsBackground})`
            difficultyBox.style.backgroundImage = `url(${data.netherTheme.difficultyBox})`
            status.style.backgroundImage = `url(${data.netherTheme.settingsBackground})`
            favicon.setAttribute("href", "./static/images/icon/nether.png")
            localStorage.setItem("theme", "nether")
            break;
        default:
            setTheme("world")
            break;
    }
}

document.querySelector(".overworld").addEventListener("click", (e) => {
    setTheme("world")
})

document.querySelector(".nether").addEventListener("click", (e) => {
    setTheme("nether")
})