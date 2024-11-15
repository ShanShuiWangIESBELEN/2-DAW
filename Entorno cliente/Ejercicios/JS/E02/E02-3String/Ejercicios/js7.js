/* Write a JavaScript function to parameterize a string.
Test Data :
console.log(string_parameterize("Robin Singh from USA."));
""robin-singh-from-usa */

/* function string_parameterize(str) {
    return str.split(" ").join("-").toLowerCase();
} */

/* console.log(string_parameterize("Robin Singh from USA.")); */

function string_parametrize(texto) {
    if (typeof texto !== 'string') {
        return null;
    }
    return texto.toLowerCase().replace(/[^a-z0-9\s]/g, "").replace(/\s+/g, "-");

}
console.log(string_parametrize("Batman,   the World Greatest Detective!"));


