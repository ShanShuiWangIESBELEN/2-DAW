import * as crypto from "crypto";

interface Person{
    nombre: string;
    apellidos: string;
    fechaNacimiento: string;
    genero: string;
    gmail: string;
    movil: string;
}

let body = document.querySelector("#main") as HTMLElement;
let tabla = document.querySelector("#bodyTabla") as HTMLElement;
let enviar = document.querySelector("#enviar") as HTMLElement;
let data: Person[] = [];

type PeolpleDictionary = {
    [key: string]: Person
};
let peopleDictionary : PeolpleDictionary = {};

enviar!.addEventListener("click", (event) => {
    event.preventDefault();

    let input = document.querySelectorAll("input")

    let formData: Person ={

        nombre: input[0].value,
        apellidos: input[1].value,
        fechaNacimiento: input[2].value,
        genero: input[3].value,
        gmail: input[4].value,
        movil: input[5].value,
        }

    tabla!.innerHTML = "";
    data.push(formData);
    let personId = crypto.randomUUID();
    peopleDictionary[personId] = formData;

    show(peopleDictionary);
});

function show(objArray: PeolpleDictionary) {

    Object.values(objArray).forEach(person => {
        let tr = document.createElement("tr");
        Object.values(person).forEach(value => {
            let td = document.createElement("td");
            if (typeof value === "string" || typeof value === "boolean") {
                td.innerHTML = value.toString();
            }
            tr.append(td);
        });
        tabla.append(tr);
    })
}

