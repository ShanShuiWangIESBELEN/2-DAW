let imgs = document.querySelectorAll(".imgs");
let boton = document.querySelector("#boton")
let currentId = 1;
boton.addEventListener("click", (e) => {

    if (currentId < 8) {
        oculta = document.getElementById(currentId);
        currentId = currentId + 1;
        nextImg = document.getElementById(currentId);
        console.log(nextImg);
        nextImg.toggleAttribute("hidden");
        oculta.toggleAttribute("hidden");
    }else{
        oculta = 8;
        currentId = 1;
        nextImg = document.getElementById(currentId);
        oculta = document.getElementById(oculta)
        console.log(nextImg);
        nextImg.toggleAttribute("hidden");
        oculta.toggleAttribute("hidden");
    }


})

