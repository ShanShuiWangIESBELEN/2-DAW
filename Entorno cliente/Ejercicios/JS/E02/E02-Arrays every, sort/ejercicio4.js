/* In this exercise you must try each of the array cloning methods listed in the notes.
- Clone a one-dimensional array. Make changes to the cloned array. Check if
everything works as expected.
- Clone a two-dimensional array. Make changes to the cloned array and one of the
internal arrays. Check if everything works as expected. */


let comidas = ["Hamburguesa", "Tacos", "Risotto", "Ceviche"];

/* Primera forma */
let comidasCopy = [...comidas];
console.log(comidasCopy);

/* Segunda forma */
let comidaCopy2 = Array.from(comidas);
console.log(comidaCopy2);

/* Tercera forma */
let comidaCopy3 = comidas.slice();
console.log(comidaCopy3);


let comidas2 = [["Italiano", "Peruano"], ["Risotto", "Ceviche"]];

let comidasCopy4 = [...comidas2];
comidasCopy4[0][0] = "Mexicano";
comidasCopy4[1][0] = "Taco";
console.log(comidasCopy4);