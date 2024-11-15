async function getRemoteData(url) {
    let response = await fetch(url);
    if (response.ok && response.status === 200) {
        return response.json();
    } else {
        throw new Error("error...");
    }
}

let url = 'products.json';
let allProducts = await getRemoteData(url);

let container = document.querySelector('#container');
let containerCarry = document.querySelector('#carry');

showData(allProducts);

function showData(allData) {
    let products = allData.items;
    products.forEach(product => {

        let img = document.createElement("img");
        img.src = `items/${product.name}.png`;
        img.id = `${product.num}`;
        container.append(img);
    });
}


container.addEventListener("dragover", (event) => {
    event.preventDefault();
});

containerCarry.addEventListener("dragover", (event) => {
    event.preventDefault();
});

container.addEventListener("dragstart", (event) => {
    event.dataTransfer.setData("id", event.target.id);
});

containerCarry.addEventListener("drop", (event) => {
    let idProduct = event.dataTransfer.getData("id");
    let products = allProducts.items;
    let currentProduct = products.find(product => product.num.toString() === idProduct);

    console.log(currentProduct)
    console.log(idProduct)
});