import { Empleado } from './Empleado.js';

export class EmpleadoController {
    constructor() {
        this.empleado = []
    }

    /* cargar json, que no se como funciona por ahora */
    async cargarDatosIniciales() {
        const response = await fetch('../../assets/empleados.json');
        this.empleados = await response.json();
    }
}
