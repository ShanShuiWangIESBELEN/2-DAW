/* Request four grades for a student, calculate the average,
and indicate whether the grade is pass,
sufficient, good or outstanding */

let num1 = parseInt(prompt("Introduzca un numero"));
let num2 = parseInt(prompt("Introduzca segundo numero"));
let num3 = parseInt(prompt("Introduzca tercer numero"));
let num4 = parseInt(prompt("Introduzca cuarto numero"));
let sum = num1 + num2 + num3 + num4;
let average = sum / 4;


document.getElementById("sum").innerHTML = (`La nota media es : (${num1} + ${num2} + ${num3} + ${num4})  /4  = ${sum / 4} `);

if (average < 5) {
    document.getElementById("average").innerHTML = "noob"
}
else if (average == 5) {
    document.getElementById("average").innerHTML = "pass"
} else if (average == 6) {
    document.getElementById("average").innerHTML = "sufficient"
} else if (average == 7) {
    document.getElementById("average").innerHTML = "good"
} else if (average >= 8) {
    document.getElementById("average").innerHTML = "outstanding"
}


