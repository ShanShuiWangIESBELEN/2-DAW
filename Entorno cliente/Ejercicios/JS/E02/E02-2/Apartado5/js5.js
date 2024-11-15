/* Based on an array of numbers, use an arrow function 
to calculate the greatest number. */

let array = [21666666, 0, 6, 1, 1255, -1, 7841, 12312353151];

let greatest = array.reduce((max, current) => current > max ? current : max);

console.log(greatest);