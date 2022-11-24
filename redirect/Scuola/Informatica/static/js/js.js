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