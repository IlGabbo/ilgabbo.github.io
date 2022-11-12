let width = 800
let height = 800


function setup() {
    createCanvas(width, height);
}

function draw() {
    if (frameCount <= 1000) {
        fill(0, 0, 0)
        fill(255, 255 ,255)
        let r = random(0, 255)
        let g = random(0, 255)
        let b = random(0, 255)
        let a = random(0, 255)
        let x = random(800)
        let y = random(800)
        let diametro = random(30, 90)
        noStroke()
        fill(r, g, b, a)
        circle(x, y , diametro)
    } else {
        frameCount = 0;
        background(220);
    }
}