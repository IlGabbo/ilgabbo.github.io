let angle = 0 
let increment = 0.01

function getBreadth() {
    let breadth = document.getElementById("ampiezza")
    let p = document.getElementById("valore-ampiezza")
    p.innerHTML = breadth.value
    return breadth.value
}

function getFrequency() {
    let frequency = document.getElementById("frequenza")
    let p = document.getElementById("valore-frequenza")
    p.innerHTML = frequency.value
    return frequency.value
}

function getFase() {
    let fase = document.getElementById("base")
    let p = document.getElementById("valore-base")
    p.innerHTML = fase.value
    return fase.value
}

function setup() {
    createCanvas(innerWidth, innerWidth)
    line(0,200,1500,200)
}

function draw() {
    let ampiezza = parseInt(getBreadth())
    let frequenza = parseInt(getFrequency())
    let fase = parseInt(getFase())
    let x = map(angle,0,2*PI,0,400)
    let y = ampiezza * sin(2*PI*frequenza*angle+fase)
    stroke(0,0,255)
    strokeWeight(3)
    console.log(x,y)
    point(x,y+200)
    angle += increment
}