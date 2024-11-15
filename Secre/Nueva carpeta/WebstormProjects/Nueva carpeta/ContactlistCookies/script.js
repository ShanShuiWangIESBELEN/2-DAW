let body = document.querySelector("#main");
let tabla = document.querySelector("#bodyTabla");
let photo = document.querySelector("#photo");
let divPhoto = document.querySelector("#photoPreview")
let obj = [];
obj.push(getDataCookies());
show(obj);

if (localStorage.getItem("previewImage")){
    let img = document.createElement("img");
    img.src = localStorage.getItem("previewImage");
    divPhoto.append(img);
}


document.querySelector("#enviar").addEventListener("click", (event) => {
    event.preventDefault();
    let correct = true;

    let input = document.querySelectorAll("input")

    obj.push(
        {
            "Nombre": !validator.isEmpty(input[0].value) ? input[0].value : correct = false,
            "Apellido": !validator.isEmpty(input[1].value) ? input[1].value : correct = false,
            "FechaNacimiento": validator.isDate(input[2].value) ? input[2].value : correct = false,
            "Genero": !validator.isEmpty(input[3].value) ? input[3].value : correct = false,
            "Email": validator.isEmail(input[4].value) ? input[4].value : correct = false,
            "Movil": validator.isNumeric(input[5].value) ? input[5].value : correct = false
        }
    )
    if (correct) {
        show(obj);
        saveDataCookies(obj);
    }
});

function show(data) {

    let tr = document.createElement('tr')
    data.forEach(item => {
        tr.innerHTML =
            `<td>${item.Nombre}</td>
                      <td>${item.Apellido}</td>
                        <td>${item.FechaNacimiento}</td>
                        <td>${item.Genero}</td>
                        <td>${item.Email}</td>
                        <td>${item.Movil}</td>`
    });
    tabla.append(tr);
}


function saveDataCookies(allData) {
    allData.forEach(data => {
        document.cookie = `Formulario=${JSON.stringify(data)}; expire=Thu, 12 Jun 2025 09:00:00 UTC; path=/;`;
    });
}

function getDataCookies() {

    let cookieString = document.cookie;
    let cookieItems = cookieString.split('; ');
    let cookieObject = {};

    cookieItems.forEach(item => {
        let [name, value] = item.split('=');
        if (name === "Formulario") {
            cookieObject = JSON.parse(value);
        }
    });
    return cookieObject;
}



photo.addEventListener("change", (event) => {
    previewImage(photo);
})

function previewImage(input) {

    let file = input.files[0];
    let img = document.createElement("img");

    img.src = URL.createObjectURL(file);
    divPhoto.innerHTML = "";
    divPhoto.append(img);
    localStorage.setItem("previewImage", img.src)
}