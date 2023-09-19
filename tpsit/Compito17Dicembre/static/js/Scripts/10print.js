let spazio = 30
let x = 0
let y = 0


let input_range = document.getElementById("range-input")
input_range.addEventListener("input", function() {
    spazio = parseInt(input_range.value)
    x = 0
    y = 0
    background(220)
})

function setup() {
    createCanvas(400, 400)
    background(220)
}

function draw() {
    stroke("red")
    if (random() < 0.5) {
        line(x, y, x + spazio, y + spazio)
    } else {
        line(x, y + spazio, x + spazio, y)
    }

    x += spazio
    if (x >= 400) {
        x = 0
        y += spazio
    }
}

