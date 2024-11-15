class Persona {
    constructor(public nombre: string, public edad: number) {}
    mostrarInfo(): void {
        console.log(`Nombre: ${this.nombre}, Edad: ${this.edad}`);
    }
    toString() : string {
        return `${this.nombre} ${this.edad}`;
    }
}
export default Persona;