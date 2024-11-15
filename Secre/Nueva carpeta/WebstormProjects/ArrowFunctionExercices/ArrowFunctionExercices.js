//function add(a, b) {
//    return a + b;
//}

let add = (a, b) => a + b;
console.log(add(2, 4));


//function multiply(x, y) {
//    return x * y;
//}

let multiply = (a, b) => a * b;
console.log(multiply(2, 2));


//function greet(name) {
//    return "Hello, " + name + "!";
//}

let greet = (name) => "Hello " + name + "!";
console.log(greet("Pablo"));


//function power(base, exponent) {
//    return Math.pow(base, exponent);
//}

let power = (base, exponent) => Math.pow(base, exponent);
console.log(power(2, 2));


//function isEven(num) {
//    return num % 2 === 0;
//}

let isEven = (num) => num % 2 === 0;
console.log(isEven(4));


//Creates a function declaration to calculate the factorial of a number.
// Convert it into an arrow function with a single expression.
// Convert it into an arrow function with a block body.

function factorial(num) {
    let total = 1;
    while (num > 0) {
        total *= num;
        num--;
    }
    return total;
}

console.log(factorial(5));

let factorial2 = (num) => {
    let total = 1;
    while (num > 0) {
        total *= num;
        num--;
    }
    return total;
}
console.log(factorial2(5));

let factorial3 = (num) => num > 0 ? (num * factorial3(num - 1)) : num = 1;
console.log(factorial3(5));

