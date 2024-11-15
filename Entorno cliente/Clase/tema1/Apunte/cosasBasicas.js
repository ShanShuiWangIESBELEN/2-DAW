/* let number = 10;
console.log(number);

number = "Hola";
console.log(number);
console.log(typeof number); // muestra l tipo de number que es un String //

number = true;
console.log(number);

number = [1, 2, 3, 5, "ABC", false];
console.log(number);

let persona = { apellido: "Wang" };
console.log(persona);

console.log(persona.hasOwnProperty("apellido"));
console.log(typeof persona.apellido);

let hoy = new Date();
console.log("Primer ", hoy);

console.log("primer " + hoy); /* + hace que  concadena la fecha con el String por lo que convierte la fecha en un formato String //


const employee = {
    name: "juan",
    age: 24,
}

const salary = 4000;

console.log(employee);
console.log(salary);

employee.city = "Malaga";


let person = "Wang";
let city = "Malaga";
let str = `hola soy 
${person} 
y vivo en ${city}`;
console.log(str);
*/

console.log(`===========================`);

let lista = [1, 2, 3, 4, 5, 6, 7, 8];

lista.forEach(element => {
    element *= 2;
    console.log(`El double: ` + element)
}
);



