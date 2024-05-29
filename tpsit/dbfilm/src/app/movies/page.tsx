import { Response } from "../sas"

export default async function MoviesPage() {
  try {
    const movies: Response = await (await fetch('http://localhost:80/api/api.php/movies')).json()
    console.log(movies)
    return (
      <div>
        <h1>Movies</h1>
        {
          movies.payload.map((payload, k) => (
            <div key={k}>{payload.title}</div>
          ))
        }
      </div>
    )
  } catch (error) {
    console.error(error)
    return (
      <div>Error</div>
    )
  }
}