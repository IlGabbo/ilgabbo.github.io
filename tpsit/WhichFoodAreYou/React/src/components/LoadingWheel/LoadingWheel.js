import "./LoadingWheel.css"


export default function LoadingWheel({displaymode}) {
    return (
        <div className="loading-wheel" style={{display: displaymode}}>
            <h2>{"Loading"}</h2>
            <div className="circle">
                <div className="circle-centered"></div>
            </div>
        </div>
    )
}
