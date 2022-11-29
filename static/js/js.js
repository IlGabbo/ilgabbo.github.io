let image = document.getElementById("image")
let menu = document.getElementById("context-menu")
let content = document.getElementById("Lorem")
let notify = document.getElementById("notifications")
let notificationBox = document.getElementById("message-box")
let title = document.getElementById("title")
let content_box = document.getElementById("content-box")
let isBoxOpened = false



notify.setAttribute("index", "0")
notify.addEventListener("click", function(e) {
    e.preventDefault()
    if (isBoxOpened == false) {
        notify.setAttribute("index", "0")
        notificationBox.style.display = "flex"
        notificationBox.style.position = "fixed"
        if (window.innerWidth > 1300) {
            console.log(window.innerWidth)
            const {clientX: X, clientY: Y} = e
            notificationBox.style.top = Y + 15 + "px"
            notificationBox.style.left = X + "px"
        } else {
            console.log(window.innerWidth)
            notificationBox.style.bottom = "0"
            notificationBox.style.right = "0"
        }
        isBoxOpened = true
    } else {
        notificationBox.style.display = "none"
        isBoxOpened = false
    }
})

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

document.querySelector("#image").addEventListener("mousemove", 
function(e) {
    title.style.top = "0.4vh"
    image.style.width = "60px"
    image.style.height = "60px"
    image.style.borderRadius = "100px"
    image.style.border = "1px solid #fff"
    image.style.backgroundPosition = "center"
    image.style.top = "10px"
    image.style.left = "20px"
    menu.style.left = "0px"
    content.style.left = "25%"
    document.querySelector("body").style.overflowY = "visible"
    image.style.transition = "all 1.5s"
    menu.style.transition = "all 1.5s"
    content.style.transition = "all 2.3s"
    title.style.transition = "all 1.5s"

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

