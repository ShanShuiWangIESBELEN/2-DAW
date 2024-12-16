/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./Ejercicios/**/*.{html,js}", " ./Ejercicios/Ejercicio1/**/*.{html,js}", "./Ejercicios/Ejercicio2/**/*.{html,js}"],
  theme: {
    extend: {
      colors: {
        celeste: '#243cff',
      }
    },
  },
  plugins: [],
}