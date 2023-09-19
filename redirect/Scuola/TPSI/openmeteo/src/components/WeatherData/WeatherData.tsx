import { WeatherProps } from "./WeatherData.models";
import { useEffect, useRef } from "react";

export default function WeatherData(
  {
    weatherdata
  } : WeatherProps
) {
  const weatherRef = useRef<HTMLDivElement>(null)

  useEffect(() => {
    if (weatherdata) {
      if (weatherRef.current) {
        weatherRef.current.scrollIntoView({behavior: "smooth"})
      }
    }
  }, [weatherdata])

  return weatherdata ? (
    <div ref={weatherRef} className={"w-full h-full flex items-center justify-center"}>
      <div className='w-4/5 h-4/5 bg-color_secondary rounded-lg flex items-center justify-center'>
        <div className='w-[90%] h-[90%]'>
          <h2 className='text-color_text_primary font-semibold text-2xl'>Weather stats</h2>
          <div className="Graphic w-full h-2/5 mt-3"></div>
          <div className='w-full min-h-[64px] overflow-x-auto flex'>
            {
              weatherdata.hourly.precipitation_probability.slice(0, 24).map((value, key) => {
                return (
                  <div key={key} className='w-14 h-full border-r-2 flex flex-col items-center border-color_primary flex-shrink-0 relative'>
                    <div className="w-full h-16 flex flex-col items-center">
                      <img src="/static/images/temperature.svg" className="w-2/3" alt="temperature" />
                      <p className="text-color_text_primary text-[14px]">
                        {weatherdata.hourly.temperature_2m[key]} {weatherdata.hourly_units.temperature_2m}
                      </p>
                    </div>
                    <div className="w-full h-16 flex flex-col items-center justify-center">
                      <img src='/static/images/rain.svg' className="w-1/4" alt="rain" />
                      <p className='text-color_text_primary'>{value} {weatherdata.hourly_units.precipitation_probability}</p>
                      <p className='text-color_text_primary'>{key}:00</p>
                    </div>
                  </div>
                )
              })
            }
          </div>
        </div>
      </div>
    </div>
  ) : <></>
}