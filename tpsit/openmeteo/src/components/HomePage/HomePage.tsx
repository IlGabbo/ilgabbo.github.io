import { useEffect, useRef, useState } from "react";
import Alert from "../Alert/Alert";
import "./HomePage.style.scss"
import { TileLayer, MapContainer, Marker, Popup, useMapEvents } from 'react-leaflet'
import 'leaflet/dist/leaflet.css'
import { LatLngExpression } from "leaflet";
import { coords, HomePageProps, WeatherResponse } from "./HomePage.models";
import Button from "../Button/Button";

export default function HomePage(
  {
    onData
  } : HomePageProps
) {
  const [alt, showAlert] = useState<boolean>()
  const [message, setMessage] = useState<string>('')
  const [coords, setCoords] = useState<LatLngExpression>([51.505, -0.09])
  const [marker, setMarker] = useState<boolean>()
  const [loading, setLoading] = useState<boolean>(false)
  const inputLatRef = useRef<HTMLInputElement>(null),
  inputLonRef = useRef<HTMLInputElement>(null)

  const API = "https://api.open-meteo.com/v1/forecast?"

  const setLocation = async () => {
    const permission = await navigator.permissions.query({name: "geolocation"})
    if (permission.state === "prompt") {
      showAlert(true)
      setMessage("Do you want to use your location")
    }
    if (permission.state === "granted") {
      setMarker(true)
      const pos: coords = await new Promise((res, err) => {
        navigator.geolocation.getCurrentPosition(res, err)
      })

      const [lat, lon] = [pos.coords.latitude, pos.coords.longitude]
      setCoords([lat, lon])
      if (inputLatRef.current) {
        inputLatRef.current.value = lat.toString()
      }
      if (inputLonRef.current) {
        inputLonRef.current.value = lon.toString()
      }
      return [lat, lon]
    }
    return [0, 0]
  }

  useEffect(() => {
    setLocation()
  }, [])

  const Markers = () => {
    const map = useMapEvents({
      click: (e) => {
        setMarker(true)
        setCoords([e.latlng.lat, e.latlng.lng])
        if (inputLatRef.current) {
          inputLatRef.current.value = e.latlng.lat.toString()
        }
        if (inputLonRef.current) {
          inputLonRef.current.value = e.latlng.lng.toString()
        }
      }
    })

    return marker ? (
      <Marker position={coords}>
        <Popup>
          a
        </Popup>
      </Marker>
    ) : <></>
  }

  const Map = () => {
    return (
      <MapContainer className="w-1/2 h-52 mt-4 mb-4 overflow-hidden rounded-lg outline-none z-10" zoom={13} center={coords}>
        <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"/>
        <Markers />
      </MapContainer>
    )
  }

  return (
    <div className="w-full h-full flex flex-col items-center justify-center">
      <h3 className="text-center text-color_text_primary font-bold text-2xl">Weather forecast</h3>
      <p className="text-center text-color_text_primary">Enter coordinates to get weather info</p>
      {
        <Map />
      }
      <div className="w-1/2 h-10 flex items-center justify-evenly">
        <Button type="cancel" label="Reset" onAbort={() => {
          if (inputLatRef.current) {
            inputLatRef.current.value = ''
          }
          if (inputLonRef.current) {
            inputLonRef.current.value = ''
          }
        }} />
        <input ref={inputLatRef} onChange={(e) => {

        }} type="number" pattern="\d*" placeholder="Lat" className="Input w-1/3 h-full font-semibold text-color_text_primary p-3 text-[16px] outline-none rounded-lg bg-color_secondary border-2 border-color_accent" />
        <input ref={inputLonRef} onChange={(e) => {
          
        }} type="number" pattern="\d*" placeholder="Lon" className="Input w-1/3 h-full font-semibold text-color_text_primary p-3 text-[16px] outline-none rounded-lg bg-color_secondary border-2 border-color_accent" />
        <Button type="confirm" label="Send" onLoading={loading} onConfirm={() => {
          (
            async () => {
              if (!inputLatRef.current || !inputLatRef.current.value) {
                alert("Type all fields")
                return
              }
              if (!inputLonRef.current || !inputLonRef.current.value) {
                alert("Type all fields")
                return
              }
              setLoading(true)
              try {
                const response = await fetch(API + new URLSearchParams(
                  {
                    latitude: inputLatRef.current.value,
                    longitude: inputLonRef.current.value,
                    hourly: "temperature_2m,relativehumidity_2m,precipitation_probability,rain,snowfall,temperature_180m"
                  }
                ))

                const data: WeatherResponse = await response.json()
                onData!(data)
              } catch (err) {
                console.error(err)
              }
              setLoading(false)
            }
          )()
        }} />
      </div>
      {
        alt && (
          <Alert 
          showAlert={true} 
          alertMessage={message} 
          showButtons={true} 
          onConfirm={() => {showAlert(false); navigator.geolocation.getCurrentPosition(
            (pos) => {
              const [lat, lon] = [pos.coords.latitude, pos.coords.longitude]
              setCoords([lat, lon]); 
              setMarker(true)
              if (inputLatRef.current) {
                inputLatRef.current.value = lat.toString()
              }
              if (inputLonRef.current) {
                inputLonRef.current.value = lon.toString()
              }
            },
            (err) => {},
          )}} 
          onClose={() => {showAlert(false)}} 
          />
        )
      }
    </div>
  )
}
