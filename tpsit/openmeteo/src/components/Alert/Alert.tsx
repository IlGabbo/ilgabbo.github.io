import Button from "../Button/Button";
import { AlertProps } from "./Alert.models";
import {motion} from "framer-motion"

export default function Alert(
  {
    showAlert,
    alertMessage,
    showButtons,
    onConfirm,
    onClose,
  } : AlertProps
) {
  return showAlert ? (
    <motion.div 
    initial={{opacity: 0, top: "40%"}}
    animate={{opacity: 1, top: "50%"}}
    className='alert w-96 h-44 rounded-lg bg-color_secondary
              absolute left-1/2 -translate-x-1/2 -translate-y-1/2
              flex flex-col items-center justify-around z-20'>
      <p className="text-color_text_primary w-4/5 text-xl">{alertMessage}</p>
      {
        showButtons && (
          <div className="w-44 flex justify-between">
            <Button type="confirm" onConfirm={onConfirm} label="Yes" />
            <Button type="cancel" onAbort={onClose} label="No" />
          </div>
        )
      }
    </motion.div>
  ) : <></>
}