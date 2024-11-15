import Persona from './persona';
class Empleado extends Persona {
    constructor(nombre: string, edad: number, public position: string)
    {
        super(nombre, edad);
    }
    mostrarInfo(): void {
        super.mostrarInfo();
        console.log(`Cargo: ${this.position}`);
    }
    toString() : string {
        return `${super.toString()} ${this.position}`;
    }
}
export default Empleado;