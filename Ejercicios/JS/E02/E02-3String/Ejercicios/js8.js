/* Write a JavaScript function to capitalize the first letter of each word in a string.
Test Data :
console.log(capitalize_Words('js string exercises'));
"Js String Exercises "*/

function capitalize_Words(str) {
    return str.split(' ').map(word => word[0].toUpperCase() + word.slice(1)).join(' ');
}

console.log(capitalize_Words('js string exercises'));
