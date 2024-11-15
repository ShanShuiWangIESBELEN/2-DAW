let expireCookie = 10;

function cookieHandler() {
    let cookie = docCookies.getItem("name");

    if (cookie === null) {
        showForm();
    } else {
        greetUser(cookie);
        setConfirmationInterval(cookie);

        window.addEventListener("beforeunload", function () {
            docCookies.removeItem("name");
            localStorage.removeItem("backgroundColor");
            localStorage.removeItem("fontColor");
            localStorage.removeItem("fontSize");
        });
    }
}

function showForm() {
    let container = document.getElementById("container");
    let greetDiv = document.getElementById("greetDiv");

    greetDiv.innerHTML = "Welcome to this Page!! Please enter your name";
    container.innerHTML = `<form id="form">
                        <label>Name:
                            <input type="text" id="name" name="name">
                        </label>
                        <label>Background Color:
                            <input type="color" id="backgroundColorInput">
                        </label>
                        <label>Font Color:
                             <input type="color" id="fontColorInput">
                        </label>
                        <label>Font Size:
                             <input type="number" id="fontSizeInput" min="1" max="50">
                        </label>
                        <input type="submit" value="Submit">
                    </form>`;

    document.getElementById("form").addEventListener("submit", function (ev) {
        ev.preventDefault();
        let nameUser = document.getElementById("name").value;
        let backgroundColor = document.getElementById("backgroundColorInput").value;
        let fontColor = document.getElementById("fontColorInput").value;
        let fontSize = document.getElementById("fontSizeInput").value;

        docCookies.setItem("name", nameUser, expireCookie);
        setPreferences();

        applyPreferences(backgroundColor, fontColor, fontSize);
        location.reload();
    });
}

function setPreferences() {
    let backgroundColor = document.getElementById("backgroundColorInput").value;
    let fontColor = document.getElementById("fontColorInput").value;
    let fontSize = document.getElementById("fontSizeInput").value;

    localStorage.setItem("backgroundColor", backgroundColor);
    localStorage.setItem("fontColor", fontColor);
    localStorage.setItem("fontSize", fontSize);

    applyPreferences(backgroundColor, fontColor, fontSize);
}

function applyPreferences(backgroundColor, fontColor, fontSize) {
    document.body.style.backgroundColor = backgroundColor;
    document.body.style.color = fontColor;
    document.body.style.fontSize = fontSize + "px";
}

function greetUser(cookie) {
    let container = document.getElementById("container");
    let greetDiv = document.getElementById("greetDiv");

    applyPreferences(localStorage.getItem("backgroundColor")
        , localStorage.getItem("fontColor")
        , localStorage.getItem("fontSize"));

    greetDiv.innerHTML = `Hello ${cookie.toUpperCase()}, nice to see you again`;
    setTimeout(() => {
        greetDiv.innerHTML = "";
    }, 3000);

    container.innerHTML = `${cookie.toUpperCase()}`;
}

function setConfirmationInterval(cookie) {
    setInterval(() => {
        let confirmation = confirm("Are you there?");
        if (confirmation) {
            docCookies.setItem("name", cookie, expireCookie);
            applyPreferences(localStorage.getItem("backgroundColor"), localStorage.getItem("fontColor"), localStorage.getItem("fontSize"));
        } else {

            docCookies.removeItem("name");
            localStorage.removeItem("backgroundColor");
            localStorage.removeItem("fontColor");
            localStorage.removeItem("fontSize");
            location.reload();
        }
    }, expireCookie * 1000);
}

document.addEventListener("DOMContentLoaded", cookieHandler);


