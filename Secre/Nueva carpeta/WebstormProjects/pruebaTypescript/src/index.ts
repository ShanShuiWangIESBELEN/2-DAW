import Persona from './persona';
import Empleado from './empleado';

const persona = new Persona('Juan', 25);
const empleado = new Empleado('Carlos', 30, 'Desarrollador');

persona.mostrarInfo();
empleado.mostrarInfo();
function mostrarMensaje(mensaje: string): void {
    outputDiv ? (outputDiv.innerText = `${mensaje}
${empleado.toString()}`) : null;
}

const outputDiv = document.getElementById('output');
mostrarMensaje('¡Hola!');