import { Person, Response } from "@/app/sas"
import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material"

export default async function PeopleHomePage() {
  try {
    const { status, message, payload } : Response = await (await fetch('http://localhost/api/api.php/people', {method: 'GET'})).json()
    if (status !== 200) {
      return (
        <div className="error">{status} {message}</div>
      )
    }

    return (
      <div className="people">
        <h1>People</h1>
        <TableContainer component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Name</TableCell>
                <TableCell>Synopsys</TableCell>
                <TableCell>Release year</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {payload.map((person: Person) => (
                <TableRow key={person.id}>
                  <TableCell>{person.name} {person?.middle_name} {person.surname}</TableCell>
                  <TableCell>{person.bDate}</TableCell>
                  <TableCell>{person.category}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </div>
    )
  } catch (error) {
    console.error(error)
    return <div className="error">104 Unknown error</div>
  }
}