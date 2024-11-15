var ctx = null, canvas = null;
//inicializamos nuestro canvas con la siguiente función
function iniciar() {
    canvas = document.getElementById('lienzo');
    ctx = canvas.getContext('2d');
    //CUADRADO
    ctx.fillStyle = "rgba(0, 0, 0, 0.5)"; //Color
    ctx.fillRect(10, 60, 50, 50); //X, Y, ancho, alto

    //LINEAS
    ctx.beginPath();
    ctx.moveTo(10, 120);//X, Y
    ctx.lineTo(60, 120)//X, Y
    ctx.lineWidth = 2; //ancho de la linea (en px)
    ctx.strokeStyle = "#CC0000"; //color de la linea
    ctx.stroke();//confirmar acción

    //ARCOS
    ctx.beginPath();
    ctx.arc(52, 200, 50, 0, 2 * Math.PI); //X, Y, radio, inicioArco, finArco
    ctx.lineWith = 10;
    ctx.strokeStyle = "yellow";
    ctx.stroke();

    //TEXTO (si te fijas, es el título de esta página)
    ctx.font = 'Bold 25px Tahoma';
    ctx.textAlign = 'center';
    ctx.fillStyle = 'black';
    ctx.fillText('Canvas', 50, 50);//texto, X, Y

    //IMAGENES
    var img = new Image();
    img.src = 'img.png';
    img.onload = function () {
        ctx.drawImage(img, 100, 10); //imagen, X, Y
        //me daba pereza redimensionarla :P
    };
}
window.addEventListener("load", iniciar, false);