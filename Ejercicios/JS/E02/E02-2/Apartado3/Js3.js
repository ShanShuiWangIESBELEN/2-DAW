/* Based on an array of numbers, create another array whose elements are the positive
numbers of the first one.
a) Use a traditional function definition and array manipulation technique.
b) Refactor the previous code, to use an arrow function and the array mapping function. */

let array = [-1, 2, -3, 4, -5, 6];

/* a) */
function convertirPositivo(array) {
    for (i = 0; i < array.length; i++) {
        if (array[i] < 0) {
            array[i] = array[i] * -1;
        }
    }
    return array;
}


/* b) */
let arrayPositivo = array.map((e) => Math.abs(e));


console.log(convertirPositivo(array));
console.log(arrayPositivo);