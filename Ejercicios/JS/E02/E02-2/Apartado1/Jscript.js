/* In an array there are names of people. Create an arrow function that generates a
greeting for each of them. */


let array = ["Miguel", "Pedro", "Juan", "Ana", "Luis"];
let felicitaciones = array.map(nombre => "Hola " + nombre);

console.log(array);
console.log(felicitaciones);