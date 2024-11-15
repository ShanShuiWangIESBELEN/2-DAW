var ctx = null, canvas = null;
canvas = document.getElementById('lienzo');
ctx = canvas.getContext('2d');
//inicializamos nuestro canvas con la siguiente función
function pintarCuadrado(rotar) {

    ctx.translate((10 + (50 / 2)), (60 + (50 / 2)));
    ctx.rotate((rotar * Math.PI) / 180);
    ctx.translate(-(10 + (50 / 2)), -(60 + (50 / 2)));

    ctx.fillStyle = "rgba(0, 0, 0, 0.5)";
    ctx.fillRect(10, 60, 50, 50);

}

function run() {
    
    ctx.clearRect(0, 0, 1000, 1000)
    pintarCuadrado(1)

    requestAnimationFrame(run)


}
window.addEventListener("load", run, false);