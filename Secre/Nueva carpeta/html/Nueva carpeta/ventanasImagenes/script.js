let imgs = document.querySelectorAll(".chica");
let cerrar = document.querySelector("#cerrar");

imgs.forEach(img => {
    img.addEventListener("mousemove" , (e) => {
        let currentImg = e.target.src;
        let grande = document.querySelector(".grande");
        grande.src = currentImg;
        grande.toggleAttribute("hidden", false);
        cerrar.toggleAttribute("hidden", false);
    })
});

cerrar.addEventListener("click", (e) => {
    let grande = document.querySelector(".grande");
    grande.toggleAttribute("hidden" , true);
    cerrar.toggleAttribute("hidden", true);
})


/*
let pag = document.querySelectorAll(".pag");
let mov = document.querySelectorAll(".mov");
let cont = 1;

pag.forEach(button => {
    button.addEventListener("click", (e) => {
        let currentButonId = e.target.id;
        cont = currentButonId;
console.log(cont);
        let currentDiv = document.getElementById(`container${currentButonId}`);

        let allDivs = document.querySelectorAll(".container");
        allDivs.forEach(div => {
            div.toggleAttribute("hidden", true);
        });
        currentDiv.toggleAttribute("hidden", false);
    })
});


mov.forEach(button => {
    button.addEventListener("click", (e) => {
        let currentButonId = e.target.id;

        if (currentButonId == "der") {
            if (cont == 4) {
                cont = 1;

            } else {
                cont = parseInt(cont);
                cont = 1 + cont;
            }
            let currentDiv = document.getElementById(`container${cont}`);
            let allDivs = document.querySelectorAll(".container");
            allDivs.forEach(div => {
                div.toggleAttribute("hidden", true);
            });
            currentDiv.toggleAttribute("hidden", false);

        } else {
            if (cont == 1) {
                cont = 4;
                
            } else {
                cont = parseInt(cont);
                cont = cont - 1;
            }
            let currentDiv = document.getElementById(`container${cont}`);
            let allDivs = document.querySelectorAll(".container");
            allDivs.forEach(div => {
                div.toggleAttribute("hidden", true);
            });
            currentDiv.toggleAttribute("hidden", false);
        }



    })
});*/
/*
let imagenes = document.querySelectorAll('.container');
let leftButton = document.querySelector('#leftButton')
let rigthButton = document.querySelector('#rigthButton');
let currentId = 1;

showButtons(currentId);

leftButton.addEventListener('click', (event) => {
    imagenes.forEach(imagen => {
        if (!imagen.attributes.hidden) {
            currentId = Number.parseInt(imagen.id.split('_')[1]);
            imagen.toggleAttribute("hidden", true);
        }
    });
    currentId = currentId - 1;
    nextImg = document.getElementById(img_${currentId});
    nextImg.toggleAttribute("hidden");
    showButtons(currentId);
});


rigthButton.addEventListener('click', (event) => {
    imagenes.forEach(imagen => {
        if (!imagen.attributes.hidden) {
            currentId = Number.parseInt(imagen.id.split('_')[1]);
            imagen.toggleAttribute("hidden", true);
        }
    });
    currentId = currentId + 1;
    nextImg = document.getElementById(img_${currentId});
    nextImg.toggleAttribute("hidden");
    showButtons(currentId);
});

let divButton = document.querySelector("#botones");

divButton.addEventListener("click", (event) => {
    if (event.target.className === 'button') {
        let img = document.getElementById(img_${currentId})
        img.toggleAttribute("hidden", true);

        currentId = Number.parseInt(event.target.id);
        let currentImg = document.getElementById(img_${currentId})
        currentImg.toggleAttribute("hidden");
    }
    showButtons(currentId);
});

function showButtons(currentId) {
    if (currentId === 1) {
        leftButton.disabled = true;
    } else if (currentId === 4) {
        rigthButton.disabled = true;
    } else {
        leftButton.disabled = false;
        rigthButton.disabled = false;
    }
}
*/