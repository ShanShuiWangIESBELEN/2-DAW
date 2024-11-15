/* Write a JavaScript function to convert a string into camel case.
Test Data :
console.log(camelize("JavaScript Exercises"));
console.log(camelize("JavaScript exercises"));
console.log(camelize("JavaScriptExercises"));
"JavaScriptExercises"
"JavaScriptExercises"
"JavaScriptExercises" */

function camelize(str) {
    let resultado = "";
    let char;
    for (let i = 0; i < str.length; i++) {
        char = str[i];
        if (char === " ") {
            resultado += str[i + 1].toUpperCase();
            i++;
        } else {
            resultado += char;
        }
    }
    return resultado;
}



console.log(camelize("JavaScript Exercises"));
console.log(camelize("JavaScript exercises"));
console.log(camelize("JavaScriptExercises"));