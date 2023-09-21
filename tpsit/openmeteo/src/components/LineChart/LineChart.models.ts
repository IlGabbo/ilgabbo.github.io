export type LineChartType = {
  hour: string
  precipitation_prob: string
  prob: number
}

export interface LineChartProps {
  data: LineChartType[]
}