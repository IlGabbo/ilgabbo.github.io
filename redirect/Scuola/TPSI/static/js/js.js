let image = document.getElementById("image")
let menu = document.getElementById("context-menu")
let content = document.getElementById("Lorem")
let notify = document.getElementById("notifications")
let notificationBox = document.getElementById("message-box")
let title = document.getElementById("title")
let content_box = document.getElementById("content-box")
let isBoxOpened = false


window.addEventListener("scroll",
    function(e) {
        content_box.style.top = "70%"
        content_box.style.transition = "all 0.8s"
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

document.querySelector(".hamburger a").addEventListener("click", function(e){
    e.preventDefault()
    document.querySelector(".options").classList.toggle("toggle-menu")
})

function showAboutMe() {
    let about_window = document.getElementById("about")
    if (window.innerWidth > 1300) {
        let e = window.event
        const {clientX: X, clientY: Y} = e
        e.preventDefault()
        about_window.classList.toggle("show-about-me")
        about_window.style.top = `${Y + 15}px`
        about_window.style.left = `${X}px`
    } else {
        about_window.classList.toggle("query-about")
    }
}
    

function installerRedirect() {
    window.open("https://github.com/darksnakepy/Design-QT", "_self")
}

