//1. In an array there are names of people. Create an arrow function that generates a
//greeting for each of them.


    let array0 = ["Pablo" , "Adrian", "Juan"];

let cadena = (array) => {

    for (let i = 0; i < array.length; i++) {
        console.log("Hola " + array[i]);
        //cadena += `Hello ${array[i]}`;
    }
}
cadena(array0);


//2. Based on an array of numbers, create another array whose elements are the square of
//each of the elements of the first array.
//    a) Use a traditional function definition and array manipulation technique.
//    b) Refactor the previous code, to use an arrow function and the array mapping function.

let array1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

function cuadrado(array) {
    let array2 = [array.length];
    for (let i = 0; i < array.length; i++) {
        array2[i] = array[i] * array[i];
    }
    return array2;
}

console.log(cuadrado(array1));

//Apartado b

let array4 = array1.map(item => Math.pow(item, 2));
console.log(array4);


//3. Based on an array of numbers, create another array whose elements are the positive
//numbers of the first one.
//    a) Use a traditional function definition and array manipulation technique.
//    b) Refactor the previous code, to use an arrow function and the array mapping function.

let array6 = [-1, -2, -3, -4, -5, -6];

function positivo(array) {
    let array2 = [array.length];
    for (let i = 0; i < array.length; i++) {
        array2[i] = array[i] * -1;
    }
    return array2;
}

console.log(positivo(array6));


//Aapartado b

let array5 = array6.map(item => item * -1);
console.log(array5);

//4. Based on an array of numbers, use an arrow function to calculate its average.

let array7 = [1, 2, 3, 4, 5];
let media = (array) => {
    suma = 0;
    for (let i = 0; i < array.length; i++) {
        suma = suma + array[i];
    }
    return suma / array.length;
}
console.log(media(array7));


//5. Based on an array of numbers, use an arrow function to calculate the greatest number
let array8 = [1, 2, 5, 10, 2, 5, 89, 30];

let mayor = (array) => {
    let max = Number.MIN_VALUE;

    for (let i = 0; i < array.length; i++) {
        if (array[i] > max){
            max = array[i];
        }
    }
    return max;
}

let max = array8.reduce((acumulator, n) => n > acumulator? n : acumulator, 0);
console.log(max)
console.log(mayor(array8));
