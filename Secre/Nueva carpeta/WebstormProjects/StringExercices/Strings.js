/*1 Create a script with 2 string variables.
− Display both variables between single quotes.
− Display both variables separated by a line break.
a) Using traditional string concatenation
b) Using string literals
 */

let str1 = "Hello";
let str2 = "World";
console.log(`${str1} ${str2}`);
console.log(`${str1}\n${str2}`);


/*2. In this exercise, you will create a function that accepts the components of an email
sending service and combines them into an email body template. To make things more
interesting, only adults are eligible to post comments on the website. Accordingly, the
message text will change.

    function sendEmail(name, age, comments) {
    - check the passed parameters now. If any are invalid or missing, the function will
    simply return null
        - use the ternary operator to check whether this person is of legal age or not.
    sendEmail("Jane", 27, "Your website is fantastic!");
// => "A user has posted a comment from the website:
// => name: Jane
// => age: 27
// => status: Jane is a valid user
// => comments Your website is fantastic!"
*/

function sendEmail(name, age, comments) {
    if (age >= 18) {
        return `A user has posted a comment from the website:
        name: ${name}
        age: ${age}
        status: ${name} is a valid user
        comments ${comments}`
    } else {
        return null;
    }
}

console.log(sendEmail("Pablo", 19, "Yes it is amazing!"));



/*3. Write a JavaScript program to replace every character in a given string with the character
following it in the alphabet.
*/

function replaceChar(str) {
    let array = str.split("");
    let array2 = array.map(chars => String.fromCharCode(chars.charCodeAt(0) + 1));
    return array2.join("");
}

console.log(replaceChar("hola"));


/*4. Write a JavaScript function to extract a specified number of characters from a string.
Test Data :
console.log(truncate_string("Robin Singh",4));
"Robi"
*/
function truncate_string(str, long) {
    return str.slice(0, long);
};

function truncate_string2(str, long) {
    let cadena8 = str.split("").filter((char, indice) =>  indice < long);
    return cadena8.join("");
};

console.log(truncate_string("Robin Singh", 4));
console.log(truncate_string2("Robin Singh", 4));

/*5. Write a JavaScript function to convert a string into abbreviated form.
Test Data :
console.log(abbrev_name("Robin Singh"));
"Robin S."
 */

function abbrev_name(str) {
    let array = str.split(" ");
    for (let i = 1; i < array.length; i++) {
        array[i] = array[i].slice(0, 1);
    }
    return array.join(" ");
}

console.log(abbrev_name("Robin Singh Liar Stephen"));

/*6. Write a JavaScript function that hides email addresses to prevent unauthorized access.
Test Data :
console.log(protect_email("robin_singh@example.com"));
robin...@example.com
 */


function protect_email(email, long) {
    let array = email.split("@");
    array[0] = (array[0].slice(0, array[0].length - long)) + "...";
    return array.join("");
}

console.log(protect_email("robin_singh@example.com", 5));


/*7. Write a JavaScript function to parameterize a string.
Test Data :
console.log(string_parameterize("Robin Singh from USA."));
"robin-singh-from-usa"
*/

function string_parameterize(str) {
    str = str.toLowerCase();
    return str.split(" ").join("-");
}

console.log(string_parameterize("Robin Singh from USA."));


/*8. Write a JavaScript function to capitalize the first letter of each word in a string.
Test Data :
console.log(capitalize_Words('js string exercises'));
"Js String Exercises"
*/

function capitalize_Words(str) {
    let word;
    let cadena = "";
    let array = str.split(" ");
    for (let i = 0; i < array.length; i++) {
        word = array[i].split("");
        word[0] = word[0].toUpperCase();
        cadena+= word.join("") + " ";
    }
    return cadena;
}

console.log(capitalize_Words('js string exercises'));


/*9 Write a JavaScript function that takes a string with both lowercase and upper case letters
as a parameter. It converts upper case letters to lower case, and lower case letters to
upper case.
Test Data :
console.log(swapcase('AaBbc'));
"aAbBC"
*/

function swapcase(str) {
    let array = str.split("");
    for (let i = 0; i < array.length; i++) {
        if (array[i] === array[i].toUpperCase()) {
            array[i] = array[i].toLowerCase();
        } else {
            array[i] = array[i].toUpperCase();
        }
    }
    return array.join("");
}

console.log(swapcase('AaBbc'));


/*10. Write a JavaScript function to convert a string into camel case.
Test Data :
    console.log(camelize("JavaScript Exercises"));
console.log(camelize("JavaScript exercises"));
console.log(camelize("JavaScriptExercises"));
"JavaScriptExercises"
"JavaScriptExercises"
"JavaScriptExercises"
*/


function camelize(str) {
    let array = str.split(" ");
    let array2;
    let cadena = "";
    for (let i = 0; i < array.length; i++) {
        array2 = array[i].split("");
        array2[0] = array2[0].toUpperCase();
        cadena += array2.join("");
    }
    return cadena;
}

console.log(camelize("hola que pasa como estas"));



/*11. Write a JavaScript function to uncommelize a string.
    Test Data :
    console.log(uncamelize('helloWorld'));
console.log(uncamelize('helloWorld','-'));
console.log(uncamelize('helloWorld','_'));
"hello world"
"hello-world"
"hello_world"
*/

function uncamelize(str, separator = " ") {
    array = str.split("");
    for (let i = 0; i < str.length; i++) {
        if (array[i] === array[i].toUpperCase()) {
            array[i] = separator + array[i].toLowerCase();
        }
    }
    return array.join("");
}

console.log(uncamelize('helloWorldWhatsUp', "-"));
console.log(uncamelize('helloWorldWhatsUp'));