import { useEffect, useState } from "react"
import "./QuestionsBox.css"


export default function QuestionsBox() {
    const [items, setItems] = useState([])
    
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
        <div className="box-centered">
            <div className="questions-box">
                {
                    items.map((item, key) => (
                        <div key={key}>
                            <h3>{item.question}</h3>
                            {
                                item.answer.map((answer, key) => (
                                    <div key={key}>
                                        <input type="radio" />
                                        <label htmlFor="aaa">{answer}</label>
                                    </div>
                                ))
                            }
                        </div>                        
                    ))
                }
            </div>
        </div>
    )
}