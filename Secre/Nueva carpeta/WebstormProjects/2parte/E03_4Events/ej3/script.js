let elements = document.querySelectorAll(".element");
let pos = document.querySelector("#pos");
let numElement = document.querySelector("#element");

document.addEventListener("mousemove", event => {

    let posX = event.clientX;
    let posY = event.clientY;

    pos.textContent = `${posX} ${posY}`;

    elements.forEach(element => {

        let pos = element.getBoundingClientRect();
        let inDiv = posX >= pos.left && posX <= pos.right && posY >= pos.top && posY <= pos.bottom;

        if (inDiv) {
            //element.classList.add("#ffeeba");
            element.style.backgroundColor = "#ffeeba";
            numElement.textContent = `${element.id}`;
        }
    });
});

document.addEventListener("mouseout", () => {
    elements.forEach(element =>
        //element.classList.remove("highlight")
        element.style.backgroundColor = "");
    numElement.textContent = "";
});