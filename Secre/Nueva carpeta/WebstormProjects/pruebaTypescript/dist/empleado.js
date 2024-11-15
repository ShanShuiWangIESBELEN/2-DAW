"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
var persona_1 = require("./persona");
var Empleado = /** @class */ (function (_super) {
    __extends(Empleado, _super);
    function Empleado(nombre, edad, position) {
        var _this = _super.call(this, nombre, edad) || this;
        _this.position = position;
        return _this;
    }
    Empleado.prototype.mostrarInfo = function () {
        _super.prototype.mostrarInfo.call(this);
        console.log("Cargo: ".concat(this.position));
    };
    Empleado.prototype.toString = function () {
        return "".concat(_super.prototype.toString.call(this), " ").concat(this.position);
    };
    return Empleado;
}(persona_1.default));
exports.default = Empleado;
