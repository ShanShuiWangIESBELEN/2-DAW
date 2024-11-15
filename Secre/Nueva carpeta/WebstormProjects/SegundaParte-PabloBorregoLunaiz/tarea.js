let tareasData = tasksAll.tasksList;

function mostrar() {
    let tBody = document.querySelector("#tabBod");

    let textRow = "";

    for (let t of tareasData) {
        textRow += `<tr>
                        <td>${t.assignedTo}<br>${t.task} 
                                                <div id="duracion">${t.duration}:00</div>
                                                <div id="break">${t.break}:00</td>
                    </tr>`;
        decrease(t.duration);
    }
    tBody.innerHTML = textRow;
}

window.onload = function () {
    mostrar();
}

function decrease(time){

    let dur = document.getElementById("duracion");
    let buttonStart = document.getElementById("start");
    let buttonStop = document.getElementById("stop");

    buttonStart.addEventListener("click", () => {
        let minute = time;
        let seconds = 0;

        buttonStart.setAttribute("disabled", "");
        buttonStop.removeAttribute("disabled", "");
        let interval = setInterval(() => {
            seconds--;
            if (seconds === 0) {
                seconds = 59;
                minute--;
            }

            dur.innerHTML = `${minute.toString().padStart(2, time)}:${seconds.toString().padStart(2, "0")}`;
            if (dur.innerHTML === "00:00"){
                dur.innerHTML = "done";
            }
        }, 1000);

        buttonStop.addEventListener("click", () => {
            buttonStart.removeAttribute("disabled");
            buttonStop.setAttribute("disabled", "");
            dur.innerHTML = time + `:00`;
            clearInterval(interval);
        })
    })
}

