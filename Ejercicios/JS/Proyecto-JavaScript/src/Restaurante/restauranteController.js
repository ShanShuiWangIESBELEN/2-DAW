const restaurantes = [
    {
        "id": 1,
        "nombre": "BambuHouse",
        "direccion": "Calle 123, Aentrada",
        "platos": 2
    },
    {
        "id": 2,
        "nombre": "MExicanFlavor",
        "direccion": "Avenida 456, Toronto",
        "platos": 2
    },
    {
        "id": 3,
        "nombre": "MafiaItalian",
        "direccion": "Calle 789, New York",
        "platos": 1
    }
];

const restaurantesList = document.querySelector(".restaurantes-list");

const mostrarRestaurantes = () => {
    restaurantesList.innerHTML = "";

    restaurantes.forEach(restaurante => {
        const card = document.createElement("div");
        card.classList.add("card");

        card.innerHTML = `
        <h2>${restaurante.nombre}</h2>
        <p><strong>Dirección:</strong> ${restaurante.direccion}</p>
        <p><strong>Número de Platos:</strong> ${restaurante.platos}</p>
        <div class="btn-container">
            <button class="edit-btn"><a href="./editarRestaurante.html">Editar</a></button>
            <button class="delete-btn">Eliminar</button>
        </div>
        `;
        restaurantesList.appendChild(card);
    });
}

mostrarRestaurantes();

/* Las fimcionalidades desarrollaré mas adelantes */
