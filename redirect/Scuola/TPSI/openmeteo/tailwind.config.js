const default_colors = {
  color_primary: "#1e75b8",
  color_secondary: "#0c2a46",
  color_text_primary: "#ffffff",
  color_text_secondary: "#9ca3af",
  color_accent: "#42b2ff",
  color_background: "#13171c",
  color_gray_600: "#4b5563",
  color_gray_700: "#374151",
  color_error: "#fd3a3a",
}
/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      colors: default_colors,
      backgroundColor: default_colors
    }
  },
  plugins: [],
}
