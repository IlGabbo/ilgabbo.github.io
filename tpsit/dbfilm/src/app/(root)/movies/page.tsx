import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material"
import { Movie, Response } from "../../sas"

export default async function MoviesPage() {
  try {
    const {status, message, payload}: Response = await (await fetch('http://localhost:80/api/api.php/movies')).json()
    if (status !== 200) {
      return (
        <div className="error">{status} {message}</div>
      )
    }

    return (
      <div className="movies">
        <h1>Movies</h1>
        <TableContainer component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Title</TableCell>
                <TableCell>Synopsys</TableCell>
                <TableCell>Release year</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {payload.map((movie: Movie) => (
                <TableRow key={movie.id}>
                  <TableCell>{movie.title}</TableCell>
                  <TableCell>{movie.synopsys}</TableCell>
                  <TableCell>{movie.releaseYear}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </div>
    )
  } catch (error) {
    console.error(error)
    return (
      <div className="error">104 Unknown error</div>
    )
  }
}
