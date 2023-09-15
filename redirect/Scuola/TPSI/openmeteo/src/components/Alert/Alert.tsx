import Button from "../Button/Button";
import { AlertProps } from "./Alert.models";

export default function Alert(
  {
    showAlert,
    alertMessage,
    showButtons
  } : AlertProps
) {
  return showAlert ? (
    <div 
    className='alert w-96 h-44 rounded-lg bg-color_secondary
              absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2
              flex flex-col items-center justify-around'>
      <p className="text-color_text_primary text-3xl">{alertMessage}</p>
      {
        showButtons && (
          <div className="w-44 flex justify-between">
            <Button label="sas" />
            <Button label="sas" />
          </div>
        )
      }
    </div>
  ) : <></>
}