import { Plato } from './Plato.js';

export class PlatoController {
    constructor() {
        this.platos = [];
    }
    /* cargar json, que no se como funciona por ahora */
    async cargarDatosIniciales() {
        const response = await fetch('../../assets/platos.json');
        this.platos = await response.json();
    }

    crearPlato(nombre, precio, categoria, disponible, restauranteId) {
        const id = this.platos.length + 1;
        const nuevoPlato = new Plato(id, nombre, precio, categoria, disponible, restauranteId);
        this.platos.push(nuevoPlato);
        return nuevoPlato;
    }

    obtenerPlatos() {
        return this.platos;
    }

    obtenerPlatosPorRestaurante(restauranteId) {
        return this.platos.filter(plato => plato.restauranteId === restauranteId);
    }

    editarPlato(id, nombre, precio, disponible, categoria) {
        const plato = this.platos.find(p => p.id === id);
        if (plato) {
            plato.nombre = nombre;
            plato.precio = precio;
            plato.disponible = disponible;
            plato.categoria = categoria;
        }
    }
    eliminarPlato(id) {
        this.platos = this.platos.filter(plato => plato.id !== id);
    }
}
