async function getRemoteData(url) {
    let response = await fetch(url);
    if (response.ok && response.status === 200) {
        return response.json();
    } else {
        throw new Error("error...");
    }
}

/**************************************************************************************/

let tbody = document.querySelector("#tbody");
let inputEnglish = document.querySelector("#inputEnglish");
let inputSpanish = document.querySelector("#inputSpanish");
let inputGerman = document.querySelector("#inputGerman");

let tdEnglish = document.querySelector("#english");
let tdSpanish = document.querySelector("#spanish");
let tdGerman = document.querySelector("#german");

let url = 'allCountries.json';

getRemoteData(url)
    .then(data => {
        showDataEnglish(data);
    })
    .catch(error => {
        console.log(error);
    });

/**************************************************************************************/

function showDataEnglish(allData) {
    let countries = allData.countries;
    for (let index = 0; index < countries.length; index++) {
        let tr = document.createElement("tr");
        tr.innerHTML = `
                        <td id="En${index}">${countries[index].name_en}</td>
                        <td id="Sp${index}"></td>
                        <td id="Gr${index}"></td>
                       `
        tbody.append(tr);
    }
}

/**************************************************************************************/

let previewTd = null;
tbody.addEventListener("click", (event) => {

    // Pintar el tr seleccionado
    let tdClicked = document.querySelector(`#${event.target.id}`);
    tdClicked.parentNode.style.backgroundColor = "lightyellow";

    // Borrar el color del tr anterior
    if (previewTd !== null) {
        previewTd.style.backgroundColor = "";
    }
    previewTd = tdClicked.parentNode;

    // Escribir el inputEnglish
    tdEnglish = previewTd.querySelectorAll("td")[0];
    inputEnglish.placeholder = tdEnglish.innerText;

    // Vaciar los inputs
    allInputs.forEach(input => {
        input.value = "";
    });

    return previewTd;
});

/**************************************************************************************/

inputSpanish.addEventListener("keyup", () => {
    if (previewTd !== null) {
        tdSpanish = previewTd.querySelectorAll("td")[1];
        tdSpanish.innerText = inputSpanish.value;
    }
});

/**************************************************************************************/

inputGerman.addEventListener("keyup", () => {
    if (previewTd !== null) {
        tdGerman = previewTd.querySelectorAll("td")[2];
        tdGerman.innerText = inputGerman.value;
    }
});

/**************************************************************************************/

let allInputs = document.querySelectorAll("input");
allInputs.forEach(input => {
    input.addEventListener("keydown", (ev) => {
        if (!isNaN(ev.key)) {
            ev.preventDefault();
        }
    });
    input.addEventListener("click", event => {
        event.target.value = "";
    });
})


