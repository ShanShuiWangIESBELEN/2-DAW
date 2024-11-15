/*
 * ATTENTION: The "eval" devtool has been used (maybe by default in mode: "development").
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
/******/ 	var __webpack_modules__ = ({

/***/ "./src/empleado.ts":
/*!*************************!*\
  !*** ./src/empleado.ts ***!
  \*************************/
/***/ (function(__unused_webpack_module, exports, __webpack_require__) {

eval("\nvar __extends = (this && this.__extends) || (function () {\n    var extendStatics = function (d, b) {\n        extendStatics = Object.setPrototypeOf ||\n            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||\n            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };\n        return extendStatics(d, b);\n    };\n    return function (d, b) {\n        if (typeof b !== \"function\" && b !== null)\n            throw new TypeError(\"Class extends value \" + String(b) + \" is not a constructor or null\");\n        extendStatics(d, b);\n        function __() { this.constructor = d; }\n        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());\n    };\n})();\nObject.defineProperty(exports, \"__esModule\", ({ value: true }));\nvar persona_1 = __webpack_require__(/*! ./persona */ \"./src/persona.ts\");\nvar Empleado = /** @class */ (function (_super) {\n    __extends(Empleado, _super);\n    function Empleado(nombre, edad, position) {\n        var _this = _super.call(this, nombre, edad) || this;\n        _this.position = position;\n        return _this;\n    }\n    Empleado.prototype.mostrarInfo = function () {\n        _super.prototype.mostrarInfo.call(this);\n        console.log(\"Cargo: \".concat(this.position));\n    };\n    Empleado.prototype.toString = function () {\n        return \"\".concat(_super.prototype.toString.call(this), \" \").concat(this.position);\n    };\n    return Empleado;\n}(persona_1.default));\nexports[\"default\"] = Empleado;\n\n\n//# sourceURL=webpack://pruebatypescript/./src/empleado.ts?");

/***/ }),

/***/ "./src/index.ts":
/*!**********************!*\
  !*** ./src/index.ts ***!
  \**********************/
/***/ ((__unused_webpack_module, exports, __webpack_require__) => {

eval("\nObject.defineProperty(exports, \"__esModule\", ({ value: true }));\nvar persona_1 = __webpack_require__(/*! ./persona */ \"./src/persona.ts\");\nvar empleado_1 = __webpack_require__(/*! ./empleado */ \"./src/empleado.ts\");\nvar persona = new persona_1.default('Juan', 25);\nvar empleado = new empleado_1.default('Carlos', 30, 'Desarrollador');\npersona.mostrarInfo();\nempleado.mostrarInfo();\nfunction mostrarMensaje(mensaje) {\n    outputDiv ? (outputDiv.innerText = \"\".concat(mensaje, \"\\n\").concat(empleado.toString())) : null;\n}\nvar outputDiv = document.getElementById('output');\nmostrarMensaje('¡Hola!');\n\n\n//# sourceURL=webpack://pruebatypescript/./src/index.ts?");

/***/ }),

/***/ "./src/persona.ts":
/*!************************!*\
  !*** ./src/persona.ts ***!
  \************************/
/***/ ((__unused_webpack_module, exports) => {

eval("\nObject.defineProperty(exports, \"__esModule\", ({ value: true }));\nvar Persona = /** @class */ (function () {\n    function Persona(nombre, edad) {\n        this.nombre = nombre;\n        this.edad = edad;\n    }\n    Persona.prototype.mostrarInfo = function () {\n        console.log(\"Nombre: \".concat(this.nombre, \", Edad: \").concat(this.edad));\n    };\n    Persona.prototype.toString = function () {\n        return \"\".concat(this.nombre, \" \").concat(this.edad);\n    };\n    return Persona;\n}());\nexports[\"default\"] = Persona;\n\n\n//# sourceURL=webpack://pruebatypescript/./src/persona.ts?");

/***/ })

/******/ 	});
/************************************************************************/
/******/ 	// The module cache
/******/ 	var __webpack_module_cache__ = {};
/******/ 	
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/ 		// Check if module is in cache
/******/ 		var cachedModule = __webpack_module_cache__[moduleId];
/******/ 		if (cachedModule !== undefined) {
/******/ 			return cachedModule.exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = __webpack_module_cache__[moduleId] = {
/******/ 			// no module.id needed
/******/ 			// no module.loaded needed
/******/ 			exports: {}
/******/ 		};
/******/ 	
/******/ 		// Execute the module function
/******/ 		__webpack_modules__[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/ 	
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/ 	
/************************************************************************/
/******/ 	
/******/ 	// startup
/******/ 	// Load entry module and return exports
/******/ 	// This entry module can't be inlined because the eval devtool is used.
/******/ 	var __webpack_exports__ = __webpack_require__("./src/index.ts");
/******/ 	
/******/ })()
;