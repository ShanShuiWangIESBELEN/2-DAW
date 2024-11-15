const lista = [1, 2, 3, 4, 5, 6];

const listaDoble = lista.map(e => e * 2);

console.log(lista);
console.log(listaDoble);

const listaDoble2 = lista.map(e => {
    let numero = e * 2;
    numero += 8;
    return numero;
});

console.log(listaDoble2);

// filter
/* Simple */
const listaFiltro = lista.filter(e => e % 2 == 0);

/* Complejo */
const listaFiltro2 = lista.filter(e => {
    //para javaScript 0 = false, 1 = true por lo que la condicion si es (e % 2 == 0) que devuelve 0 o (!(e % 2)) que devuelve 1
    //if (!(e % 2)) { aqui la condicion es si no es par
    if (e % 2 == 0) {
        console.log("Es par: " + e);
        return true;
    } else {
        return false;
    }
});

console.log(listaFiltro);

//find 
//devueve el primer elemento que cumple la condicion

let encontrado = lista.find(e => e > 4);
console.log(encontrado);
console.log(typeof encontrado);


//findIndex
//devuelve 

let indice = lista.findIndex(e => e > 4);
console.log(indice);


let indice2 = lista.indexOf(e => e > 2);
console.log(indice2);

const array1 = [1, 2, 3, 4];
const initialValue = 5;
const sumWithInitial = array1.reduce(
    (accumulator, current) => accumulator + current);
console.log(sumWithInitial);
