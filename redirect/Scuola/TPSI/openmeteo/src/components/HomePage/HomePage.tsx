import Alert from "../Alert/Alert";

export default function HomePage() {
  return (
    <div className="OM_Homepage w-full h-full">
      <h3 className="text-center text-color_text_primary font-bold text-2xl">Previsioni del tempo</h3>
      <p className="text-center text-color_text_primary">Inserisci le coordinate per avere info sul meteo</p>
      <Alert showAlert={true} alertMessage="sas" showButtons={true} />
    </div>
  )
}
