/* Write a JavaScript program to replace every character in a given string with the character
following it in the alphabet. */
function siguienteCaracter(str) {
    let resultado = "";
    for (let i = 0; i < str.length; i++) {
        resultado += String.fromCharCode(str.charCodeAt(i) + 1);

    }
    return resultado;
}

let cambio = siguienteCaracter("HolaMundo");
console.log(cambio);


/* 
cadena ="a";
console.log(cadena.charCodeAt(0));
console.log(String.fromCharCode(123));

*/





