let giglo = document.querySelector(".about")
let window_notification = document.getElementById("window-notification")
let isWindowNotificationOpen = false
let screenSize = screen.width
let indexNotification = document.querySelector(".notification")


indexNotification.setAttribute("data", "1")

indexNotification.addEventListener("click", function(e) {
        indexNotification.setAttribute("data", "0")
    })

function showMenu() {
    let e = window.event
    e.preventDefault()
    document.querySelector(".options").classList.toggle("show-options")
}

function showAbout() {
    giglo.classList.toggle("about-me")
}

function notification() {
    let e = window.event
    e.preventDefault()
    if (screenSize > 480 && screenSize > 768) {
        const {clientX: X, clientY: Y} = e
        window_notification.style.position = "fixed"
        window_notification.style.top = Y + 10 + "px"
        window_notification.style.left = X + "px"
        window_notification.classList.toggle("showHide-window-notification")    
    } else {
        window_notification.classList.toggle("centered-window-notification")    
    }
}

