import { Empresa } from './Empresa.js';
export class EmpresaController {
    constructor() {
        this.empresa = [];
    }
    /* cargar json, que no se como funciona por ahora */
    async cargarDatosIniciales() {
        const response = await fetch('../../assets/empresas.json');
        this.empresas = await response.json();
    }

    crearEmpresa(id, nombre, direccion) {
        const NuevaEmpresa = new NuevaEmpresa(id, nombre, direccion);
        const id = this.empresa.length + 1;
        this.NuevaEmpresa.push(empresa);
        return NuevaEmpresa;

    }

    obtenerEmpresas() {
        return this.empresas;
    }


}
