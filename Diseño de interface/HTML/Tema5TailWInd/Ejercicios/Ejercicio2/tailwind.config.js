/** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
        "./*.{html,js}",   // Para archivos en Ejercicio2
        "../**/*.{html,js}" // Para archivos en Ejercicios y subcarpetas
    ],
    theme: {
        extend: {
            colors: {
                celeste: '#243cff',
            },
        },
    },
    plugins: [],
}
