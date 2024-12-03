
/* Funcion para ordenar las provincias */

const orderProvinces = (order, direccion, list) => {
    if (order === 'name') {
        if (direccion === 'asc') {
            return list.sort((a, b) => a.label.localeCompare(b.label));
        } else {
            return list.sort((a, b) => b.label.localeCompare(a.label));
        }
    } else if (order === 'town') {
        list.sort((a, b) => {
            const totalTownsA = a.provinces
                ? a.provinces.reduce((sum, provincia) => sum + provincia.towns.length, 0)
                : a.towns.length;
            const totalTownsB = b.provinces
                ? b.provinces.reduce((sum, provincia) => sum + provincia.towns.length, 0)
                : b.towns.length;

            return direccion === "asc" ? totalTownsA - totalTownsB : totalTownsB - totalTownsA;
        });
    }
    return list;
}

/* Funcion para filtrar las provincias */
const fillAccordion = (father, item, category) => {
    let totalTowns;
    if (category === "community") {
        totalTowns = item.provinces.reduce((sum, provincia) => sum + provincia.towns.length, 0);
    } else if (category === "province") {
        totalTowns = item.towns.length;
    }

    /* Funcion para mostrar las provincias en el HTML */
    const div = document.createElement("div");
    div.classList.add("accordion-item");

    if (category === "community") {
        div.innerHTML = `
    <div class="accordion-item">
        <h2 class="accordion-header">
            <button class="accordion-button" type="button" data-bs-toggle="collapse"
             data-bs-target="#${category}${item.code} "aria-expanded="false" aria-controls="${category}${item.code}">
                <div class="d-flex justify-content-between w-100">
                <div>
                        <h3>${item.label}</h3>
                        <p> <span>${(item.provinces) ? item.provinces.length : item.towns.length}</span> ${(item.provinces) ? "Provincias" : "towns"}</p>
                    </div>
                    <span class="badge mx-2">${totalTowns} towns</span>
                </div>
            </button>
        </h2>

        <div id="${category}${item.code}" class="accordion-collapse collapse"">
            <div class="accordion-body" id="${category}A${item.code}">
            </div>
        </div>
    </div>`;

    } else if (category === "province") {
        div.innerHTML = `
    <div class="accordion-item">
        <h2 class="accordion-header">
            <button class="accordion-button" type="button" data-bs-toggle="collapse"
             data-bs-target="#${category}${item.code} " aria-expanded="false" aria-controls="${category}${item.code}">
                <div class="d-flex justify-content-between w-100 align-items-center">
                <div>
                        <h3>${item.label}</h3>
                        <p> <span>${(item.provinces) ? item.provinces.length : item.towns.length}</span> ${(item.provinces) ? "Provincias" : "towns"}</p>
                        
                    </div>
                    <span class="badge mx-2">${totalTowns} towns</span>
                </div>
            </button>
        </h2>

        <div id="${category}${item.code}" class="accordion-collapse collapse"">
            <div class="accordion-body" id="${category}A${item.code}">
            </div>
        </div>
    </div>`;
    }
    father.appendChild(div);
}

/* Funcion para mostrar las provincias en el HTML */
const showAccordion = (order, direccion) => {
    provincias.innerHTML = "";

    orderProvinces(order, direccion, provinces);
    provinces.forEach(community => {
        fillAccordion(provincias, community, "community");
        const provinceInt = document.querySelector("#communityA" + community.code);
        orderProvinces(order, direccion, community.provinces);

        community.provinces.forEach(province => {
            fillAccordion(provinceInt, province, "province");
            const towns = document.querySelector("#provinceA" + province.code);
            const ul = document.createElement("ul");
            towns.appendChild(ul);

            province.towns.forEach(town => {
                const li = document.createElement("li");
                li.textContent = town.label;
                ul.appendChild(li);
            });

        });
    });

}

const order = document.querySelector("#orderBy");
const direction = document.querySelector("#orderDirection");


document.addEventListener("DOMContentLoaded", () => {
    showAccordion(order.value, direction.value);
});

document.querySelectorAll(".form-select").forEach(select => {
    select.addEventListener("change", (event) => {
        event.preventDefault();
        showAccordion(order.value, direction.value);
    });
});