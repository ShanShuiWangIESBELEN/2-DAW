let urls = 'Pizza.json';

async function getRemoteData(urls) {
    let response = await fetch(urls);
    if (response.ok && response.status === 200) {
        return response.json();
    } else {
        throw new Error("error...")
    }
}


getRemoteData(urls)
    .then(data => {
        mostrar(data);
    })
    .catch(error => {
        console.log(error);
    });

function mostrar(pizza) {

    let contImg = document.querySelector(".cont");
    let pizzaImg = pizza.menu;

    for (let elementos of pizzaImg) {
        let img = document.createElement("img");
        img.setAttribute("src", `${elementos.asset.url}`)
        contImg.append(img);
    }



}

window.onload = function () {
    mostrar();
}

function allowDrop(event) {
    event.preventDefault();
}


let items = document.querySelectorAll(".cont");
items.forEach(item => {item.addEventListener("dragstart", event=>{
    event.dataTransfer.setData("text/plain",item.id)
})});


function drop(event) {
    let itemId = event.dataTransfer.getData("text/plain");
    itemId= itemId.id;
    console.log(itemId);
    getRemoteData(urls)
        .then(data => {
            for (let elementos of data) {
                if (itemId === elementos.id) {
                    let imgUrl = elementos.asset.url;
                    let img = document.createElement("img");
                    img.setAttribute("src", imgUrl)
                    contImg.append(img + `<form><input type="checkbox">26
                                               <input type="checkbox">30
                                               <input type="checkbox">40</form>`);
                }
            }
        })
        .catch(error => {
            console.log(error);
        });


}
