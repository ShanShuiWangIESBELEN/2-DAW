const platos = [
    {
        "id": 1,
        "nombre": "Sopa de Tomate",
        "precio": 5.99,
        "categoria": "Entrada",
        "restauranteId": 1
    },
    {
        "id": 2,
        "nombre": "Pizza Margarita",
        "precio": 9.99,
        "categoria": "Principal",
        "restauranteId": 1
    },
    {
        "id": 3,
        "nombre": "Helado de Chocolate",
        "precio": 3.50,
        "categoria": "Postre",
        "restauranteId": 2
    },
    {
        "id": 4,
        "nombre": "Ensalada César",
        "precio": 7.99,
        "categoria": "Entrada",
        "restauranteId": 2
    },
    {
        "id": 5,
        "nombre": "Tacos de Pollo",
        "precio": 8.99,
        "categoria": "Principal",
        "restauranteId": 2
    }
];

const restaurantes = {
    1: "BambuHouse",
    2: "MExicanFlavor",
    3: "MafiaItalian"
};

const platosList = document.querySelector(".platos-list");

const mostrarPlatos = () => {
    platosList.innerHTML = "";

    platos.forEach(plato => {
        const card = document.createElement("div");
        card.classList.add("card");

        card.innerHTML = `
        <h2>${plato.nombre}</h2>
        <p><strong>Precio:</strong> $${plato.precio.toFixed(2)}</p>
        <p><strong>Categoría:</strong> ${plato.categoria}</p>
        <p><strong>Restaurante:</strong> ${restaurantes[plato.restauranteId] || "Sin restaurante"}</p>
        <div class="btn-container">
            <button class="edit-btn"><a href="./editarPlato.html">Editar</a></button>
            <button class="delete-btn">Eliminar</button>
        </div>
        `;
        platosList.appendChild(card);
    });
}

mostrarPlatos();

/* Las fimcionalidades desarrollaré mas adelantes */
