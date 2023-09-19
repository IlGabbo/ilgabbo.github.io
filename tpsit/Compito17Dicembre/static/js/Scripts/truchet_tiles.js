let x = 0
let y = 0


function setup() {
    createCanvas(600, 600)
    background(220)
}

function drawTriangle(x, y, lunghezza, colore, triangleType) {
    noStroke()
    if (triangleType == 0) {
        if (colore == 0) {
            fill("white")
        } else {
            fill("black")
        }

        triangle(x, y, x + lunghezza, y, x, y + lunghezza)
        if (colore == 0) {
            fill("black")
        } else {
            fill("white")
        }

        triangle(x, y + lunghezza, x + lunghezza, y + lunghezza, x + lunghezza, y)
    } else {
        if (colore == 0) {
            fill("black")
        } else {
            fill("white")
        }

        triangle(x, y, x + lunghezza, y, x + lunghezza, y + lunghezza)

        if (colore == 0) {
            fill("white")
        } else {
            fill("black")
        }

        triangle(x, y, x, y + lunghezza, x + lunghezza, y + lunghezza)
    }
}

function draw() {
    let RandomG = random()
    if (RandomG < 0.25) {
        drawTriangle(x, y, 20, 0, 0)
    } else if (RandomG >= 0.25 && RandomG <= 0.5) {
        drawTriangle(x, y, 20, 0, 1)
    } else if (RandomG > 0.5 && RandomG <= 0.75) {
        drawTriangle(x, y, 20, 1, 0)
    } else {
        drawTriangle(x, y, 20, 1, 1)
    }

    x += 20

    if (x >= 600) {
        x = 0
        y += 20
    }
}