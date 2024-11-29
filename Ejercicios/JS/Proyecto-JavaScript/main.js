import restaurantes from './asserts/restaurantes.js';
import platos from './asserts/platos.js';
import { RestauranteController } from './src/Restaurante/restauranteController.js';
import { PlatoController } from './src/Plato/platoController.js';

const restauranteController = new RestauranteController();
const platoController = new PlatoController();

// Cargar datos iniciales
restauranteController.cargarDatosIniciales(restaurantes);
platoController.cargarPlatos(platos);

// Listar restaurantes
console.log('Restaurantes:', restauranteController.listaRestaurantes());

// Listar platos
console.log('Platos:', platoController.listaPlatos());



