let teamsData = equipos.equipos;

function showTeams() {
    let tBody = document.querySelector("#table-body");

    let textRow = "";

    for (let team of teamsData) {
        textRow += `<tr data-id="${team.id}"><td>${team.nombre}</td>
                                             <td>${team.fecha_fundacion}</td>
                                             <td><a href="#">${team.direccion_web}</a></td>
                                             <td>${team.jugadores}</td>
                                             <td>${team.socios}</td>
                                             <td>${team.campeonato_ganado ? "✅" : "❌"}</td>
                                             <td><img src="img/${team.escudo_url}" alt="imagen escudo" style="width: 50px; height: 50px"></td></tr>`
    }
    tBody.innerHTML = textRow;
}

window.onload = function () {
    showTeams();
}

function reset() {
    let trs = document.querySelectorAll("tr")
    trs.forEach(value => value.removeAttribute("class"));

    let buttons = document.querySelectorAll("button");
    buttons.forEach(button => button.style.display = "initial");

    document.getElementById("moreThan80000Partners").innerHTML = "+80000 partners";
    document.getElementById("moreThan125Years").innerHTML = "More than 125 Years";
    document.getElementById("sortByYear").innerHTML = "Sort by Year";
    document.getElementById("sortByWinAndYear").innerHTML = "Sort by Win and Year";
    document.getElementById("sortByName").innerHTML = "Sort by Name";
    document.getElementById("sortByPartnersAndName").innerHTML = "Sort by Partners and Name";


}
function moreThan80000Partners() {

    let teamsId = teamsData.filter(team => team.socios > 80000)
        .map(team => team.id);

    for (let team of teamsId) {
        document.querySelector(`tr[data-id="${team}"]`).classList.add("mark-yellow");
    }
    countDownButton("moreThan80000Partners");

}

function moreThan125Years() {
    reset();
    let currentYear = new Date().getFullYear();

    let teamsId = teamsData.filter(team => {
        let teamYear = parseInt(team.fecha_fundacion.split("-")[0]);
        return currentYear - teamYear > 125;
    }).map(team => team.id);
    for (let idElement of teamsId) {
        document.querySelector(`tr[data-id="${idElement}"]`).classList.add("mark-green");
    }
    countDownButton("moreThan125Years");
}

function sortByYear() {
    reset();
    teamsData.sort((a, b) => new Date(a.fecha_fundacion) - new Date(b.fecha_fundacion));
    countDownButton("sortByYear");
    showTeams();
}

function sortByWinAndYear() {
    reset();
    teamsData.sort((a, b) => {
        if (a.campeonato_ganado && b.campeonato_ganado) {
            return new Date(a.fecha_fundacion) - new Date(b.fecha_fundacion);
        } else if (a.campeonato_ganado) {
            return -1
        } else {
            return 1

        }
    });
    countDownButton("sortByWinAndYear");
    showTeams();
}

function sortByName() {
    reset();
    teamsData.sort((a, b) => a.nombre.localeCompare(b.nombre));
    countDownButton("sortByName");
    showTeams();
}

function sortByPartnersAndName() {
    reset();

    teamsData.sort((a, b) => {
        let result = b.socios - a.socios;
        if (result === 0) {
            return a.nombre.localeCompare(b.nombre);
        }
        return result;

    });

    countDownButton("sortByPartnersAndName");
    showTeams();
}

function hiddeButton(idButton = "") {
    document.getElementById(idButton).style.display = "none";
}

let countdownSecond = 5;

function countDownButton(idButton = "") {
    let button = document.getElementById(idButton);
    button.innerHTML = `The button will disappear in ${countdownSecond} seconds`;

    const interval = setInterval(() => {
        countdownSecond--
        if (countdownSecond === 0) {
            clearInterval(interval);
            hiddeButton(idButton);
            countdownSecond = 5;
        }
        button.innerHTML = `The button will disappear in ${countdownSecond} seconds`;
    }, 1000);

}