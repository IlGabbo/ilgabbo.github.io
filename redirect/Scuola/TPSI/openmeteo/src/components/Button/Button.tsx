import { ButtonProps } from "./Button.models";
import "./Button.style.scss"

export default function Button(
  {
    type,
    label,
    onLoading,
    onAbort,
    onConfirm
  } : ButtonProps
) {
  return (
    <button disabled={onLoading} onClick={() => {
      type === "cancel" && onAbort!()
      type === "confirm" && onConfirm!()
    }} className={`Button relative w-20 h-10 rounded-lg ${onLoading ? 'cursor-not-allowed bg-color_accent/60' : 'cursor-pointer active:scale-95 duration-200'} ${type === "confirm" ? "bg-color_accent" : "border-2 border-color_primary"} text-color_text_primary`}>
      {
        onLoading ? '' : label
      }
      {
        onLoading && (
          <div className="w-full h-full flex justify-center items-center">
            <i className="SpinnerMain absolute flex justify-center items-center"></i>
            <i className="SpinnerBack absolute flex justify-center items-center"></i>
          </div>
        )
      }
    </button>
  )
}