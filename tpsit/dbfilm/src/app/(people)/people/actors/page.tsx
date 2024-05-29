import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material"
import { Person, Response } from "../../../sas"

export default async function Actors() {
  try {
    const { status, message, payload }: Response = await (await fetch('http://localhost:80/api/api.php/actors')).json()
    if (status !== 200) {
      return (
        <div className="error">{status} {message}</div>
      )
    }

    return (
      <div className="actors">
        <h1>Actors</h1>
        <TableContainer component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Name</TableCell>
                <TableCell>Birthday</TableCell>
                <TableCell>Category</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {payload.map((director: Person) => (
                <TableRow key={director.id}>
                  <TableCell>{director.name} {director?.middle_name} {director.surname}</TableCell>
                  <TableCell>{director.bDate}</TableCell>
                  <TableCell>{director.category}</TableCell>
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
