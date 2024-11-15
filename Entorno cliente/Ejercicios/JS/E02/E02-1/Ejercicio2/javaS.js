/* 2. Using string templates:
Request two numbers with prompt:
Make arithmetic operations (addition, subtraction and multiplication) and display the results, the
output message should look something like this: "1 plus 5 is 6".
Perform boolean operations and display the results with appropriate message. */

let num1 = parseInt(prompt("Introduzca un numero"));
let num2 = parseInt(prompt("Introduzca otro numero"));
let sum = num1 + num2;
let resta = num1 - num2;
let multiplication = num1 * num2;
document.getElementById("sum").innerHTML = (`${num1} plus ${num2} is ${sum}`);
document.getElementById("resta").innerHTML = (`${num1} minus ${num2} is ${resta}`);
document.getElementById("multiplication").innerHTML = (`${num1} times ${num2} is ${multiplication}`);
