export type coords = {
  coords: {
    latitude: number 
    longitude: number 
  }
}

export interface HomePageProps {
  onData?: (data: WeatherResponse) => void
}

export type WeatherResponse = {
  hourly: {
    precipitation_probability: number[]
    // rain: number[]
    // relativityhumidity_2m: number[]
    // snowfall: number[]
    temperature_2m: number[]
    // temperature_180m: number[]
  }
  hourly_units: {
    precipitation_probability: string
    // rain: string
    // relativehumidity_2m: string
    // snowfall: string
    temperature_2m: string
    // temperature_180m: string
  }
}

