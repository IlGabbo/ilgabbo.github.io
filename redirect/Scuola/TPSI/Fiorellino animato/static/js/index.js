let diametro = 50;
let raggio = diametro/2;
let delta = 5;
let y = 300;
let x = diametro;



function setup() {
    createCanvas(600, 300);
}

function drawFlower(x, y,diametro, raggio) {
    strokeWeight(3);
    fill(255, 140, 0);
    circle(x - raggio, y - raggio, diametro);
    circle(x + raggio, y + raggio, diametro);
    circle(x - raggio, y + raggio, diametro);
    circle(x + raggio, y - raggio, diametro);
    fill(255, 0, 0);
    circle(x, y, diametro);
}

function draw() {
    background(0, 210, 0);
    drawFlower(x, y/2, diametro, raggio);
    if(x < diametro){
        delta = Math.abs(delta);
    }else if(x > 600 - diametro){
        delta *= -1;
    }
    x += delta;
}



