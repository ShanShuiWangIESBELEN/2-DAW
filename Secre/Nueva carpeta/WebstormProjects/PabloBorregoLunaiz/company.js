let companies1 = companies.companies;
function mostrar() {

    let tBody = document.querySelector("#tabBod")

    let cadena = "";
    ordernar();
    for (let elementos of companies1){
        cadena += `<tr><td>${elementos.continent}</td>
                        <td>${elementos.countries.map(e => e.name)}</td>
                        </tr>`

    }

    tBody.innerHTML = cadena;

}

window.onload = function () {
    mostrar();
}

function ordernar(){
    companies1.sort((a, b) => a.countries.map(e => e.name) - b.countries.map(e => e.name));
}

/*function numCompanies(){
    let num = 0;

    for (let i = 0; i < companies1.map(e=> e.countries.companies.length); i++) {

    }
        return num;
}*/