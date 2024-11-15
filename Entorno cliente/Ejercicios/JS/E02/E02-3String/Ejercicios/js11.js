/* Write a JavaScript function to uncommelize a string.
Test Data :
console.log(uncamelize('helloWorld'));
console.log(uncamelize('helloWorld','-'));
console.log(uncamelize('helloWorld','_'));
"hello world"
"hello-world"
"hello_world" */


function uncamelize(str, sep = '-') {
    return str
        .split(sep)
        .map((word, index) => index ? word.charAt(0).toUpperCase() + word.slice(1) : word)
        .join('');
}


console.log(uncamelize('helloWorld'));
console.log(uncamelize('helloWorld', '-'));
console.log(uncamelize('helloWorld', '_'));