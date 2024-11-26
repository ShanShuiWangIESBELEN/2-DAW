/* 3.Write a function to display the current day and time in the following format. Tuesday. Now: 10PM 30:38 */

function now() {
    let time = new Date();

    let dias = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];
    let dia = dias[time.getDay()];
    let hora = time.getHours();
    let minutos = time.getMinutes();
    let segundos = time.getSeconds();
    let estado = hora >= 12 ? "PM" : "AM";

    return dia + "." + "Now:" + hora + estado + " " + minutos + ":" + segundos;

}

console.log(now());
