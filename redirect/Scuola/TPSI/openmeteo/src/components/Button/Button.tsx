import { ButtonProps } from "./Button.models";

export default function Button(
  {
    label,
    onLoading,
    onClose
  } : ButtonProps
) {
  return (
    <button className='w-20 h-10 rounded-lg bg-color_accent'>
      {label}
    </button>
  )
}