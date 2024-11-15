"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var crypto = require("crypto");
var body = document.querySelector("#main");
var tabla = document.querySelector("#bodyTabla");
var enviar = document.querySelector("#enviar");
var data = [];
var peopleDictionary = {};
enviar.addEventListener("click", function (event) {
    event.preventDefault();
    var input = document.querySelectorAll("input");
    var formData = {
        nombre: input[0].value,
        apellidos: input[1].value,
        fechaNacimiento: input[2].value,
        genero: input[3].value,
        gmail: input[4].value,
        movil: input[5].value,
    };
    tabla.innerHTML = "";
    data.push(formData);
    var personId = crypto.randomUUID();
    peopleDictionary[personId] = formData;
    show(peopleDictionary);
});
function show(objArray) {
    Object.values(objArray).forEach(function (person) {
        var tr = document.createElement("tr");
        Object.values(person).forEach(function (value) {
            var td = document.createElement("td");
            if (typeof value === "string" || typeof value === "boolean") {
                td.innerHTML = value.toString();
            }
            tr.append(td);
        });
        tabla.append(tr);
    });
}
