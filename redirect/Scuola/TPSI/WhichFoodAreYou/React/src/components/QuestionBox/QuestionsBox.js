import { useEffect, useState } from "react"
import LoadingWheel from "../LoadingWheel/LoadingWheel"
import "./QuestionsBox.css"

let url = "http://localhost:8081"  // development testing only

export default function QuestionsBox() {
    const [items, setItems] = useState([])
    const [whoYouAre, setWhoYouAre] = useState()
    const [score, setScore] = useState()
    const [image, setImage] = useState()
    const [visibility, setVisibility] = useState()
    const [content, setContent] = useState()
    
    useEffect(() => {
        const getQuestions = async () => {
            const data = await(
                setContent(<LoadingWheel/>),
                await fetch(url+"/questions")
            ).json()
            setItems(data)
        }
        getQuestions().then(data => {
            setContent(
                <button onClick={() => {
                    let answers = []
                    document.querySelectorAll("input[type=radio]").forEach(input => {
                        if (input.checked) {                            
                            answers.push({ answer: input.parentNode.querySelector("label").textContent, for: input.parentNode.getAttribute("data-for") })
                        }
                    })
                    console.log(answers)
                    fetch(url+"/whichfood?answers=" + encodeURIComponent(JSON.stringify(answers)))
                        .then(promise => { return promise.json() })
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
            )
        }).catch(err => {
            setContent("Error while fetching data")})
    }, [])

    return (
        <div className="main">      
            <h1>Which food are You?</h1>      
            <div className={"whichfoodare" + ` ${visibility}`}>            
                <div className="which-centered">
                    <h1>{whoYouAre}</h1>
                    <p>{score}</p>
                    <div className="image" style={{backgroundImage: `url(${image})`}}></div>
                    <div>
                        <button className="back" onClick={() => {window.location.reload()}}>Back</button>
                    </div>
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
                                        <div key={key} className="answer" data-for={item.for}>
                                            <input type="radio" id={answer.for} onChange={(e) => {
                                                const parent = e.target.parentNode.parentNode
                                                parent.classList.add("hide-question")
                                                parent.onanimationend = () => {parent.style.display = "none"}
                                            }}/>
                                            <label htmlFor={answer.for}>{answer.answer}</label>
                                        </div>
                                    ))
                                }
                            </div>
                        )})
                    }           
                    <div className="submit-answers">
                           {content}
                    </div>     
                </div>
            </div>
        </div>                
    )
}
