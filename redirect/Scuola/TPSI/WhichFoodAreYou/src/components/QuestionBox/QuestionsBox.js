import { useEffect, useState } from "react"
import "./QuestionsBox.css"


export default function QuestionsBox() {
    const [items, setItems] = useState([])
    const [whoYouAre, setWhoYouAre] = useState("")
    const [score, setScore] = useState()
    const [image, setImage] = useState(null)
    const [visibility, setVisibility] = useState("")
    
    useEffect(() => {
        const getQuestions = async () => {
            const data = await(
                await fetch("http://localhost:8080/questions")
            ).json()
            setItems(data)
        }
        getQuestions()                
    }, [])

    return (
        <div className="main">
            <div className={"whichfoodare" + ` ${visibility}`}>
                <div className="which-centered">
                    <h1>{whoYouAre}</h1>
                    <p>{score}</p>
                    <div className="image" style={{backgroundImage: `url(${image})`}}></div>
                </div>                
            </div>
            <div className="box-centered">
                <div className="questions-box">
                    {
                        items.map((item, key) => { 
                            return(                        
                            <div key={key} className={"question"}>
                                <div className="title">
                                    <h3>{item.question}</h3>
                                </div>
                                {
                                    item.answer.map((answer, key) => (
                                        <div key={key} className="answer">
                                            <input type="radio" onChange={(e) => {
                                                let parent = e.target.parentNode.parentNode
                                                parent.classList.add("hide-question")
                                                parent.onanimationend = () => {parent.style.display = "none"}
                                            }}/>
                                            <label htmlFor={item.for}>{answer.answer}</label>
                                        </div>
                                    ))
                                }
                            </div>                        
                        )})
                    }           
                    <div className="submit-answers">
                        <button onClick={() => {
                            let answers = []
                            document.querySelectorAll("input[type=radio]").forEach(input => {
                                if (input.checked) {
                                    answers.push({answer: input.parentNode.querySelector("label").textContent, for: input.parentNode.querySelector("label").getAttribute("for")})
                                }
                            })
                            console.log(answers)
                            fetch("http://localhost:8080/whichfood?answers=" + encodeURIComponent(JSON.stringify(answers)))
                            .then(promise => {return promise.json()})
                            .then(data => {
                                console.log(data)
                                setWhoYouAre(data.whoyouare)
                                setScore(data.score)
                                setImage(data.imagesrc)   
                                setVisibility("showwhich")                            
                            })
                        }}>
                            Submit
                        </button>    
                    </div>     
                </div>
            </div>
        </div>                
    )
}
