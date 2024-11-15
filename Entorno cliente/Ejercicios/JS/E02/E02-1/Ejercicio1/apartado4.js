num1 = parseInt(prompt("Introduzca un numero"));
num2 = parseInt(prompt("Introduzca otro numero"));

let sum = num1 + num2;

let paragraph = document.getElementById("resultado");
paragraph.innerHTML +=
    `<br>La suma de los dos numero es: <br>
${num1}
<br> y <br>
${num2}<br><br>
La suma es: <br>${sum}`;