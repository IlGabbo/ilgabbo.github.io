let diametro = 50;
let raggio = diametro/2;
let x = 600;
let y = 300;


function setup() {
createCanvas(600, 300);
background(0, 210, 0);
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
drawFlower(10, 10);
for (let i = diametro; i < (x / diametro) * diametro; i += diametro * 2) {
    for (let j = diametro; j < (y / diametro) * diametro; j += diametro * 2) {
            drawFlower(i, j, diametro, raggio)
        }
    }
}

