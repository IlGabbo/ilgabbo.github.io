const express = require("express")
const cors = require("cors")
const app = express()

const PORT = 8080

app.use(cors())
app.listen(PORT, () => {console.log("Server started")})

app.get("/questions", (req, res) => {
    res.send([
        {
            question: "What is a number",
            answer: [
                "a number",
                "an elephant"
            ]
        },
        {
            question: "What is a string",
            answer: [
                "a char",
                "an integer"
            ]
        },
        {
            question: "What is school",
            answer: [
                "a beatiful place",
                "..."
            ]
        },
        {
            question: "How are you",
            answer: [
                "a baby",
                "fain"
            ]
        }
    ])
})