async function takeData(url) {
    let response = await fetch(url);
    if (response.ok && response.status === 200) {

        return response.json();
    } else {
        throw new Error("error...");
    }

}

let url = "pizza.json";
let pizzas = takeData(url).then((data) => {
    let pizzas = data.Menu;
    console.log(pizzas);

    let box1 = document.getElementById("box-1");
    let box2 = document.getElementById("box-2");
    let box3 = document.getElementById("box-3");
    let selectedPizza = {};

    function showPizzas(pizzas) {
        let html = "";
        for (let pizza of pizzas) {
            html += `<div class="pizza">
            <h3>${pizza.name}</h3>
            <img id="${pizza.id}" src=".${pizza.asset.url}" alt="${pizza.name}" style="width:100px">
            <p hidden>${pizza.toppings.map(topping => topping.name).join(" - ")}<p>
            </div>`;
        }
        box1.innerHTML = html;
    }

    function paintFormBox2(pizzaObject) {

        let radio = pizzaObject.sizes.map(size => `<input type="radio" name="topping" value="${size}">${size}<br>`).join("");

        box2.innerHTML = `<form id='form-box2'>
        <img id="${pizzaObject.id}" src=".${pizzaObject.asset.url}" alt="${pizzaObject.name}" style="width:100px">
                           ${radio}
                    <form>`;

    }

    function paintFormBox3(pizzaObject) {

        let checkboxes = pizzaObject.ingredients.map(topping => `<input type="checkbox" name="topping" value="${topping}" checked>${topping} `).join("<br>");

        box3.innerHTML = `<form id='form-box3'>
                         Name: ${pizzaObject.name}
                         Size: ${pizzaObject.size}<br>
                         Ingredients:<br> 
                         ${checkboxes}<br>
                         <button type="submit" id="submit">Order</button>
                            </form>`

    }
    showPizzas(pizzas);

    box1.addEventListener("click", (e) => {
        let pizza = e.target.nextElementSibling;

        if (pizza instanceof HTMLParagraphElement) {
            pizza.toggleAttribute("hidden");
        }
    });

    box1.addEventListener("dragstart", (e) => {
        e.dataTransfer.setData("text/plain", e.target.id);
    });

    box2.addEventListener("dragover", (e) => {
        e.preventDefault();
    });

    box1.addEventListener("dragover", (e) => {
        e.preventDefault();
    });

    box2.addEventListener("drop", (e) => {
        e.preventDefault();
        if (box2.children.length > 0) {
            alert("You can only choose one pizza")
        } else {
            let id = e.dataTransfer.getData("text/plain");
            let pizzaObject = pizzas.find(pizza => pizza.id == id);
            paintFormBox2(pizzaObject);

            selectedPizza = {
                name: pizzaObject.name,
                ingredients: pizzaObject.toppings.map(topping => topping.name),

            }
            console.log(selectedPizza);
        }
    });

    box1.addEventListener("drop", (e) => {
        e.preventDefault();
        box2.innerHTML = "";
        box3.innerHTML = "";
    });

    box2.addEventListener("change", e => {
        let size = e.target.value;
        selectedPizza.size = size;
        console.log(selectedPizza);
        paintFormBox3(selectedPizza);
    });

    box3.addEventListener("submit", e => {
        // e.preventDefault();
        let form = e.target;
        let formData = new FormData(form);
        let ingredients = formData.getAll("topping");
        selectedPizza.ingredients = ingredients;
        confirm(`Your order is ${selectedPizza.name} 
                 with ${selectedPizza.ingredients.join(" - ")} 
                 and size ${selectedPizza.size}`);
    });
});