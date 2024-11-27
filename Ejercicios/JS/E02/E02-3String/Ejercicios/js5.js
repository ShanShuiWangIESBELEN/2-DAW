/* Write a JavaScript function to convert a string into abbreviated form.
Test Data :
console.log(abbrev_name("Robin Singh"));
"Robin S." */
function abbrev_name(str) {
    let resultado = str.split(" ");
    let abreviatedName = "";
    let nombre = resultado[0];
    for (let i = 1; i < resultado.length; i++) {

        abreviatedName += resultado[i].charAt(0).toUpperCase() + ".";
    }
    return nombre + " " + abreviatedName;
}

console.log(abbrev_name("Shanshui wang Han"));