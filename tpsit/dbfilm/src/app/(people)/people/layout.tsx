import { Button } from "@mui/material";
import '../../index.css'

export default function PeopleLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html>
      <body>
        <div className="wrapper">
          <div className="topbar">
            <Button variant='contained' href="/movies">movies</Button>
            <Button variant='contained' href="/people">people</Button>
            <Button variant="contained" href="/people/actors">actors</Button>
            <Button variant="contained" href="/people/directors">directors</Button>
          </div>
          <div className="content-centered">
            {children}
          </div>
        </div>
      </body>
    </html>
  );
}