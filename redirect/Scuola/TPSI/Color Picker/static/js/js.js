let box_color = document.querySelectorAll(".color")
let h1 = document.querySelector("h1")
let p = document.querySelector("p")

box_color.forEach(element => element.addEventListener("click", (e) => {
    e = element
    box_color.forEach(e => e.style.border = "1px solid #000")
    document.querySelector("body").style.backgroundColor = e.getAttribute("data-color")
    e.style.border = "3px solid #000"
    if (e.getAttribute("data-color") === "#DCF63C") {
        h1.style.color = "#000"
        p.style.color = "#000"
    } else {
        h1.style.color = "#fff"
        p.style.color = "#fff"
    }
    document.querySelector("body").style.transition = "all 0.5s"
}))