/* Write a JavaScript function to extract a specified number of characters from a string.
Test Data :
console.log(truncate_string("Robin Singh",4));
"Robi" */

function truncate_string(str, num) {
    let resultado = "";

    if (str.length > num) {
        resultado = str.slice(0, num);
    }
    return resultado;

}

console.log(truncate_string("Robin Singh", 4));