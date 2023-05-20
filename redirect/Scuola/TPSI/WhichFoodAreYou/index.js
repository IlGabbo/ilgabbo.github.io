const express = require("express")
const cors = require("cors")
const path = require("path")
const fs = require("fs")
const app = express()

const PORT = 8081

app.use(cors())
app.use(express.static(__dirname + "/build"))
app.listen(PORT, () => {console.log("Server started")})

const content = JSON.parse(fs.readFileSync(path.join(__dirname, "json.json")).toString())

app.get("/questions", (req, res) => {
    let done = 6
    let chosenQuestions = []
    let chosenIndexess = []
    while (done > 1) {
        let index = parseInt(Math.random()*content.length)
        if (!chosenIndexess.includes(index)) {
            chosenIndexess.push(index)
            chosenQuestions.push(content[index])
            done--
        }
    }
    chosenQuestions.forEach(question => question.answer.sort(() => Math.random() - 0.5))
    res.send(chosenQuestions)
    chosenQuestions = []
    chosenIndexess = []
})

app.get("/whichfood", (req, res) => {
    let query = JSON.parse(req.query.answers)
    let score = 0
    query.forEach(key => {
        const sas = content.find((about) => {
            if (about.for === key.for) {
                about.answer.find((answer) => {
                    if (answer.answer === key.answer) {
                        score += answer.score
                    }
                })
            }
        })
    })

    // Nigiri, pizza, pasta, sht
    let whoYouAre = ""
    let imagesrc = ""
    if (score < 20) {
        whoYouAre = "You are a giglo"
        imagesrc = "images/giglo.gif"
    } else if (score > 20 && score < 40) {
        whoYouAre = "You are a pizza"
        imagesrc = "images/pizza.png"
    } else if (score > 40 && score < 50) {
        whoYouAre = "You are a pasta"
        imagesrc = "images/pasta.jpg"
    } else if (score > 50) {
        whoYouAre = "You are a nigiri"
        imagesrc = "images/nigiri.png"
    }
    
    res.send({whoyouare: whoYouAre, score: "Score: " + score, imagesrc: req.protocol + "://" + req.get("host") +"/"+imagesrc})
})

app.get("/images/pizza.png", (req, res) => {
    res.sendFile("images/pizza.png", {root: __dirname})
}) 

app.get("/images/pasta.jpg", (req, res) => {
    res.sendFile("images/pasta.jpg", {root: __dirname})
}) 

app.get("/images/nigiri.png", (req, res) => {
    res.sendFile("images/nigiri.png", {root: __dirname})
}) 

app.get("/images/giglo.gif", (req, res) => {
    res.sendFile("images/giglo.gif", {root: __dirname})
})
