/* Using the function every, check if one array is exactly the same as another. */

let array1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let array2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let array3 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 11];

function checkArrays(array1, array2) {
    return array1.every(element => array2.includes(element));
}

console.log(checkArrays(array1, array2));
console.log(checkArrays(array1, array3));

