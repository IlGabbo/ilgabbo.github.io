import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import QuestionsBox from './components/QuestionBox/QuestionsBox'


const root = ReactDOM.createRoot(
  document.getElementById('root')
)
root.render(
  <React.StrictMode>
    <QuestionsBox/>
  </React.StrictMode>
)

