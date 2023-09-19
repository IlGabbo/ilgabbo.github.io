vx = 0
ax = 0.5
vy = 0
ay = 0
r = 25
x = 0
w = 600
h = 600
y = h / 2

function setup() {
	createCanvas(w, h)
}

function AccelerationX() {
	vx = vx + ax
	x = x + vx
	if (x < -r) {
		x = w + r
	} else if (x > w + r) {
		x = -r
	}
}

function AccelerationY() {
	vy = vy + ay
	y = y + vy;
	if (y < -r) {
		y = w + r
	} else if (y > h + r) {
		y = -r
	}
}

function draw() {
	background(255)
	fill('red')
	circle(x, y, r * 2)
	AccelerationX()
	AccelerationY()
}

let accelerationX = document.getElementById('accelerationX')
let accelerationY = document.getElementById('accelerationY')

accelerationX.addEventListener('input', function(e) {
	ax = parseFloat(accelerationX.value)
})

accelerationY.addEventListener('input', function(e) {
	ay = parseFloat(accelerationY.value)
})
