let giglo = document.querySelector(".about")
let window_notification = document.getElementById("window-notification")
let isWindowNotificationOpen = false

function showAbout() {
    giglo.classList.toggle("about-me")
}

function notification() {
    let e = window.event
    e.preventDefault()
    if (isWindowNotificationOpen == false) {
        const {clientX: X, clientY: Y} = e
        window_notification.style.display = "flex"
        window_notification.style.position = "fixed"
        window_notification.style.top = Y + 10 + "px"
        window_notification.style.left = X + "px"
        isWindowNotificationOpen = true
    } else if (isWindowNotificationOpen == true) {
        window_notification.style.display = "None"
        isWindowNotificationOpen = false
    }
    
}

