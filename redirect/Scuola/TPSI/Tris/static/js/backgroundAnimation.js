let gameBackground = document.getElementById("width-414")
let singlePlayerBackground = document.querySelector(".singleplayer")


gameBackground.addEventListener("", (e) => {
    console.log("Click")
    e.currentTarget.style.backgroundPosition = `${e.clientY}% ${e.clientX}%`
})