let url = 'all_countries.json';

async function getRemoteData(url) {
    let response = await fetch(url);
    if (response.ok && response.status === 200) {
        return response.json();
    } else {
        throw new Error("error...")
    }
}


getRemoteData(url)
    .then(data => {
        mostrar(data);
    })
    .catch(error => {
        console.log(error);
    });

function mostrar(countries) {

    let tBody = document.querySelector("#tabBod");
    let countriesData = Object.values(countries.countries);
    let cadena = "";

    for (let elementos of countriesData) {
        cadena += `<tr><td>${elementos.name_en}</td>
                        <td></td>
                        <td></td>
                        </tr>`

    }

    tBody.innerHTML = cadena;

}

window.onload = function () {
    mostrar();
}

















