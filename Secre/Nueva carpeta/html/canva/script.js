/*var ctx = null, canvas = null;

function iniciar(){
    estrella("#6D7823", 135, 140, 300, 300);
}

function estrella(color, posX, posY, ancho1, alto1 ){

    let myCanvas = document.getElementById("canva");
    let ctx = myCanvas.getContext("2d");

    ctx.fillStyle = color; //Color
    ctx.fillRect(posX, posY, ancho1, alto1); //Ractángulo relleno

    ctx.translate(250, 100);
    ctx.rotate(45 * Math.PI / 180);
    ctx.fillRect(10, -40, 300, 300);


}
*/
let ctx = null, canvas = null;
function iniciar() {
    run()

}
function estrella(color, ancho, alto, X, Y, rotar = 0) {

    //defino el canva
    canvas = document.getElementById("canva");
    ctx = canvas.getContext("2d");
    ctx.fillStyle = color;
    
    //rotacion en caso de que el valor "rotar" valga mas que 0
    ctx.translate((ancho / 2) + X, (alto / 2) + Y);
    ctx.rotate((2*Math.PI)*(rotar/100));
    ctx.translate(-((ancho / 2) + X), -((alto / 2) + Y));

    //realizamos la operaciones despues de rotar
    ctx.fillRect(X, Y, ancho, alto);
    ctx.translate((ancho / 2) + X, (alto / 2) + Y);
    ctx.rotate(Math.PI / 4);
    ctx.translate(-((ancho / 2) + X), -((alto / 2) + Y));
    ctx.fillStyle = color;
    ctx.fillRect(X, Y, ancho, alto);
}

function run(){
    requestAnimationFrame(run);
    estrella("green", 150, 150, 100, 100, 0.5);
    window.setTimeout(()=>{
        ctx.clearRect(50, 50, 100, 100)
    }, 1)
    

}

iniciar();