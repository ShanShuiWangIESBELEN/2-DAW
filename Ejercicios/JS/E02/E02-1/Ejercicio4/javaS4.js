/* Request for a person's age, if it is between 18 and 120 show a positive message, otherwise show a
different type of message. */

let edad = parseInt(prompt("Introduzca su edad"));
if (edad >= 18 && edad <= 120) {
    document.getElementById("edad").innerHTML = "Esta bien para trabajar";
} else if (edad < 18) {
    document.getElementById("edad").innerHTML = "Eres menor de edad";
} else if (edad > 120) {
    document.getElementById("edad").innerHTML = "Debe estar jubilado ya";
}