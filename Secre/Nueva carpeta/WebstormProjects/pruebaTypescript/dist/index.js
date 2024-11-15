"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var persona_1 = require("./persona");
var empleado_1 = require("./empleado");
var persona = new persona_1.default('Juan', 25);
var empleado = new empleado_1.default('Carlos', 30, 'Desarrollador');
persona.mostrarInfo();
empleado.mostrarInfo();
function mostrarMensaje(mensaje) {
    outputDiv ? (outputDiv.innerText = "".concat(mensaje, "\n").concat(empleado.toString())) : null;
}
var outputDiv = document.getElementById('output');
mostrarMensaje('¡Hola!');
