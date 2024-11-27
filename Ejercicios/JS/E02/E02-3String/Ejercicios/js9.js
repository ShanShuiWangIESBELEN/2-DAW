/* Write a JavaScript function that takes a string with both lowercase and upper case letters
as a parameter. It converts upper case letters to lower case, and lower case letters to
upper case.
Test Data :
console.log(swapcase('AaBbc'));
"aAbBC" */

function swapcase(str) {
   
    return str.replace(/[a-zA-Z]/g, c => c === c.toUpperCase() ? c.toLowerCase() : c.toUpperCase());
   /*  let resultado = "";
    for (let i = 0; i < str.length; i++) {
        let char = str.charAt(i);
        if (char === char.toUpperCase()) {
            resultado += char.toLowerCase();
        } else if (char === char.toLowerCase()) {
            resultado += char.toUpperCase();
        } else {
            resultado += char;
        }
    }
    return resultado; */
}

console.log(swapcase('AaBbc'));
