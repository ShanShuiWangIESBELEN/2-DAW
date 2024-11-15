/* Based on an array of numbers, use an arrow function to calculate its average. */

let array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

let average = array.reduce((a, b) => a + b, 0 / array.length);
console.log(average);
