export type ButtonType = "confirm" | "cancel"

export interface ButtonProps {
  type: ButtonType
  label: string
  onLoading?: boolean
  onAbort?: () => void
  onConfirm?: () => void
}