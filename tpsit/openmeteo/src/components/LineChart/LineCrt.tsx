import { CartesianGrid, Line, LineChart, ResponsiveContainer, Tooltip, XAxis, YAxis } from "recharts";
import { LineChartProps } from "./LineChart.models";

export default function LineCrt(
  {
    data
  } : LineChartProps
) {
  return (
    <ResponsiveContainer width={"100%"} height="100%">
      <LineChart width={500} height={500} data={data}>
        <XAxis dataKey={"hour"} tick={{fill: "#fff"}} stroke="#1e75b8" />
        <YAxis tick={{fill: "#fff"}} stroke="#1e75b8" />
        <CartesianGrid strokeDasharray="5 5" strokeOpacity={.2} />
        <Tooltip />
        <Line type={"monotone"} dataKey={"prob"} />
      </LineChart>
    </ResponsiveContainer>
  )
}