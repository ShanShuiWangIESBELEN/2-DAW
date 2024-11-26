/* Based on an array of numbers, create another array whose elements are the square of
each of the elements of the first array.
a) Use a traditional function definition and array manipulation technique.
b) Refactor the previous code, to use an arrow function and the array mapping function. */


let array = [1, 2, 3, 4, 5, 6];
/* a) */
function MetodoAntiguo(array) {
    for (let i = 0; i < array.length; i++) {
        array[i] = array[i] * array[i];
    }
    return array;
}

console.log(array);
console.log(MetodoAntiguo(array));


/* b) */
let arrayDoble = array.map(e => e * 2);
console.log(arrayDoble);


