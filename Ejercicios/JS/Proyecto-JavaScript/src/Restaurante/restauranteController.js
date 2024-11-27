import { Restaurante } from './Restaurante.js';

export class RestauranteController {
    constructor() {
        this.restaurantes = [];
    }

    /* cargar json, que no se como funciona por ahora */
    async cargarDatosIniciales() {
        const response = await fetch('../../assets/restaurantes.json');
        this.restaurantes = await response.json();
    }

    crearRestaurante(nombre, direccion) {
        const id = this.restaurantes.length + 1;
        const nuevoRestaurante = new Restaurante(id, nombre, direccion);
        this.restaurantes.push(nuevoRestaurante);
        return nuevoRestaurante;
    }

    obtenerRestaurantes() {
        return this.restaurantes;
    }
    editarRestaurante(id, nombre, direccion) {
        const restaurante = this.restaurantes.find(r => r.id === id);
        if (restaurante) {
            restaurante.nombre = nombre;    
            restaurante.direccion = direccion;
        }
    }


    eliminarRestaurante(id) {
        const restaurante = this.restaurantes.find(r => r.id === id);
        if (restaurante.platos.length > 0) {
            throw new Error('No se puede eliminar un restaurante con platos asociados.');
        }
        this.restaurantes = this.restaurantes.filter(r => r.id !== id);
    }
}

