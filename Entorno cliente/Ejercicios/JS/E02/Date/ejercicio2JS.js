/* 2.Write a function that receives a date and displays 
the corresponding day of the week as a string, the name of the month and the full year. */

function Demostrarfecha(fecha) {
    let f = new Date(fecha);
    let dias = ["domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"];
    let mes = ["enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"];
    let anio = f.getFullYear();

    return dias[f.getDay()] + ", " + f.getDate() + " de " + mes[f.getMonth()] + " de " + anio;
}

let fecha1 = new Date("2021-01-01");
let fecha2 = new Date(2021, 0, 2);
console.log(Demostrarfecha(fecha1));
console.log(Demostrarfecha(fecha2));

