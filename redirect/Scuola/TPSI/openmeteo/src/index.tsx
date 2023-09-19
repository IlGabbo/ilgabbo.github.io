import React, { useState } from 'react';
import ReactDOM from 'react-dom/client';
import "./index.scss"
import HomePage from './components/HomePage/HomePage';
import WeatherData from './components/WeatherData/WeatherData';
import { WeatherResponse } from './components/HomePage/HomePage.models';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

const Main = () => {
  const [weatherData, setWeatherData] = useState<WeatherResponse>()

  return (
    <React.StrictMode>
      <HomePage onData={(data) => {
        setWeatherData(data)
      }} />
    <WeatherData weatherdata={weatherData} />
    </React.StrictMode>
  )
}

root.render(
  <Main />
);

