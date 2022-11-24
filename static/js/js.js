let image = document.getElementById("image")
let menu = document.getElementById("context-menu")
let content = document.getElementById("Lorem")
let notify = document.getElementById("notifications")
let notificationBox = document.getElementById("message-box")
let title = document.getElementById("title")
let isBoxOpened = false



notify.setAttribute("index", "1")
notify.addEventListener("click", function(e) {
    e.preventDefault()
    if (isBoxOpened == false) {
        const {clientX: X, clientY: Y} = e
        notify.setAttribute("index", "0")
        notificationBox.style.display = "flex"
        notificationBox.style.position = "fixed"
        notificationBox.style.top = Y + 15 + "px"
        notificationBox.style.left = X + "px"
        isBoxOpened = true
    } else {
        notificationBox.style.display = "none"
        isBoxOpened = false
    }

})

window.addEventListener("scroll", 
    function(e) {
        if (this.scrollY > 20) {
            //menu.classList.add("shadow-in")
            menu.style.backgroundColor = "#000"
            title.style.color = "#fff"
        } else {
            //menu.classList.remove("shadow-in")
            menu.style.backgroundColor = "transparent"
            title.style.color = "#AFAFAF"
        }
        menu.style.transition = "all 0.2s"
    })

document.querySelector("#image").addEventListener("mousemove", 
    function(e) {
        hasAlreadyVisited = true
        title.style.top = "5px"
        image.style.width = "4%"
        image.style.height = "8vh"
        image.style.borderRadius = "100px"
        image.style.border = "2px solid #fff"
        image.style.backgroundPosition = "center"
        image.style.top = "10px"
        image.style.left = "20px"
        menu.style.left = "0px"
        content.style.left = "25%"
        document.querySelector("body").style.overflow = "visible"
        image.style.transition = "all 1.5s"
        menu.style.transition = "all 1.5s"
        content.style.transition = "all 2.3s"
        title.style.transition = "all 1.5s"

    })