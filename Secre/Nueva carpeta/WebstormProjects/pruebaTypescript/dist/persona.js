"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Persona = /** @class */ (function () {
    function Persona(nombre, edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    Persona.prototype.mostrarInfo = function () {
        console.log("Nombre: ".concat(this.nombre, ", Edad: ").concat(this.edad));
    };
    Persona.prototype.toString = function () {
        return "".concat(this.nombre, " ").concat(this.edad);
    };
    return Persona;
}());
exports.default = Persona;
