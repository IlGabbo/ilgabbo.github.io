let box_color = document.querySelectorAll(".color")
let span = document.getElementById("span")

box_color.forEach(element => element.addEventListener("click", () => {
    document.querySelector("body").style.backgroundColor = element.getAttribute("data-color")
    let pos = element.getBoundingClientRect()
    span.style.display = "block"
    span.style.top = `${pos.top}px`
    span.style.left = `${pos.left}px`
}))