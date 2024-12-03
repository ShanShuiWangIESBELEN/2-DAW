const fillSelect = () => {
    const select = document.querySelector("#continentSelect");

    companies.forEach(elem => {
        let option = document.createElement("option");
        option.setAttribute("value", elem.continent);
        option.textContent = elem.continent;

        select.appendChild(option);
    });
}
/* filtra los continentes */
const fillCountries = () => {
    let tbody = document.querySelector('#tbody');
    let selectValue = document.querySelector("#continentSelect").value;
    let countries = [];

    tbody.innerHTML = "";

    if (selectValue) {
        let continent = companies.find((c) => c.continent === selectValue);
        if (continent) {
            continent.countries.forEach((country) => {
                countries.push(country.name);

            });

        }
    } else {
        companies.forEach((continent) => {
            continent.countries.forEach((country) => {
                countries.push(country.name);
            });
        });
    }
    countries.sort();

    countries.forEach((c) => {
        let tr = document.createElement("tr");
        let td = document.createElement("td");
        td.textContent = c;
        tr.appendChild(td);
        tbody.appendChild(tr);
    });
}
/* fila de numero de companias */
const fillCompaniesnumber = () => {
    let tbody = document.querySelector('#tbody');
    let selectValue = document.querySelector('#continentSelect').value;
    let countries = [];
    tbody.innerHTML = "";

    if (selectValue) {
        let continent = companies.find((c) => c.continent === selectValue);

        if (continent) {
            continent.countries.forEach((country) => {
                countries.push(country);
            });
        }
    } else {
        companies.forEach((continent) => {
            continent.countries.forEach((country) => {
                countries.push(country);
            });
        });
    }
    countries.sort((a, b) => a.name.localeCompare(b.name));
    countries.forEach((c) => {
        let tr = document.createElement("tr");
        let tdCountry = document.createElement('td');
        let tdCompaniesNumber = document.createElement('td');
        tdCountry.textContent = c.name;
        tdCompaniesNumber.textContent = c.companies.length;

        tr.appendChild(tdCountry);
        tr.appendChild(tdCompaniesNumber);

        tbody.appendChild(tr);

    });
}

/* fila de los nombres de companias */
const fillCompaniesName = () => {
    let tbody = document.querySelector('#tbody');
    let selectValue = document.querySelector('#continentSelect').value;
    let countries = [];
    tbody.innerHTML = "";

    if (selectValue) {
        let continent = companies.find((c) => c.continent === selectValue);

        if (continent) {
            continent.countries.forEach((country) => {
                countries.push(country);
            });
        }
    } else {
        companies.forEach((continent) => {
            continent.countries.forEach((country) => {
                countries.push(country);
            });
        });
    }
    countries.sort((a, b) => a.name.localeCompare(b.name));
    countries.forEach((c) => {
        let tr = document.createElement("tr");
        let tdCountry = document.createElement("td");
        let tdCompaniesNumber = document.createElement("td");
        let tdCompaniesNames = document.createElement("td");
        let companiesNames = c.companies.map(e => Object.keys(e));

        tdCountry.textContent = c.name;
        tdCompaniesNumber.textContent = c.companies.length;
        tdCompaniesNames.innerText = companiesNames.join("\n");
        tr.appendChild(tdCountry);
        tr.appendChild(tdCompaniesNumber);
        tr.appendChild(tdCompaniesNames);

        tbody.appendChild(tr);

    });
}

fillSelect();
fillCountries();
document.querySelector("#btnCountries").addEventListener("click", fillCountries);
document.querySelector("#btn-companies-number").addEventListener("click", fillCompaniesnumber);
document.querySelector("#btn-company-names").addEventListener("click", fillCompaniesName);