let pag = document.querySelectorAll(".pag");
let mov = document.querySelectorAll(".mov");
let cont = 1;

pag.forEach(button => {
    button.addEventListener("click", (e) => {
        let currentButonId = e.target.id;
        cont = currentButonId;
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
});


