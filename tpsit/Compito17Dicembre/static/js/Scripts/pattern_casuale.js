/*
    Replicare in uno sketch il canvas nel video allegato, in cui per ogni quadratino della griglia 
    viene disegnato in maniera casuale un cerchio nero su quadratino bianco o un cerchio bianco
    su quadratino nero aggiungendo anche uno slider per decidere la dimensione del lato del riquadro 
    della griglia. Scegliere colori di sfondo e spessori e colori delle linee a piacimento. 
*/

let x = 0
let y = 0
let lato = 30

let input = document.getElementById("range")
input.addEventListener("input", function() {
    lato = parseInt(input.value)
    x = 0
    y = 0
    background(220)
})

function setup() {
    createCanvas(600, 600)
    background(220)
}

function drawCircles(fillSquare, fillCircle) { 
    fill(fillSquare) // Filla il quadrato
    square(x, y, lato)
    fill(fillCircle) // Filla il cerchio
    circle(x + (lato / 2), y + (lato / 2), lato / 2) 
    x += lato
    if (x > 600) {
        x = 0
        y += lato
    }
}

function draw() {
    let rand = random()
    console.log(rand)
    let fillSquare, fillCircle
    
    if (rand >= 0.5) {
        fillSquare = 255
        fillCircle = 0
    } else {
        fillSquare = 0
        fillCircle = 255
    }

    drawCircles(fillSquare, fillCircle)
}

