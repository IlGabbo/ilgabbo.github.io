// Generare cerchi da x, y, diametro

document.getElementById("circleForm").addEventListener("submit", Circles)

function getX() {
    return document.getElementById("getX").value
}

function getY() {
    return document.getElementById("getY").value
}

function getDiameter() {
    return document.getElementById("getDiameter").value
}

function setup() {
    createCanvas(800, 800)
}

function Circles(e) {
    e.preventDefault()
    clear()
    let x = getX()
    let y = getY()
    let diametro = getDiameter()
    if (x != "" && y != "" && diametro != "") {
        fill(0, 0, 0)
        fill(255, 255 ,255)
        let r = random(0, 255)
        let g = random(0, 255)
        let b = random(0, 255)
        let a = random(0, 255)
        noStroke()
        fill(r, g, b, a)
        circle(x, y , diametro)
    } else {
        alert("Parametri richiesti non inseriti")
    }
}