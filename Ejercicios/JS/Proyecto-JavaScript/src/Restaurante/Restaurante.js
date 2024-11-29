export class Restaurante {
    constructor(id, nombre, direccion, activo = true) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.activo = activo;
    }

}