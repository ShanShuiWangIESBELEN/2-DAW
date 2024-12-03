const tasksAll = {
    tasksList: [
        { assignedTo: "Jon", task: "Task_1", duration: 2000, break: 5 },
        { assignedTo: "Doe", task: "Task_2", duration: 15, break: 3 },
        { assignedTo: "Foo", task: "Task_3", duration: 60, break: 15 },
    ],
};

let globalTimer = 0;
let globalInterval;
let taskIntervals = [];
const tasksContainer = document.querySelector("#task");

const formatTime = (seconds) => {
    let mins = Math.floor(seconds / 60);
    let secs = seconds % 60;

    if (mins < 10) mins = "0" + mins;
    if (secs < 10) secs = "0" + secs;

    return mins + ":" + secs;
}
const renderTasks = () => {
    tasksContainer.innerHTML = "";
    tasksAll.tasksList.forEach((task, index) => {
        const div = document.createElement("div");
        div.classList.add("task");
        div.setAttribute("indice", index);
        div.innerHTML = `
         <h3>${task.assignedTo}</h3>
        <p><span>${task.task}</span>
        <span class="time">${formatTime(task.duration)}</span>
        <span class="break">${formatTime(task.break)}</span></p>
        `;
        tasksContainer.appendChild(div);
    });
}
const startTimers = () => {
    globalInterval = setInterval(() => {
        globalTimer++;
        document.querySelector(".global-timer").textContent = formatTime(globalTimer);
    }, 1000);

    tasksAll.tasksList.forEach((task, index) => {
        const div = document.querySelector(`.task[indice="${index}"]`);

        let timeLeft = task.duration;
        let breakLeft = task.break;

        const interval = setInterval(() => {
            if (timeLeft > 0) {
                timeLeft--;
                div.querySelector(".time").textContent = formatTime(timeLeft);
                div.classList.add("active");
            } else if (breakLeft > 0) {
                div.classList.remove("active");
                div.classList.add("break");
                breakLeft--;
                div.querySelector(".break").textContent = formatTime(breakLeft);
            } else {
                div.classList.remove("break");
                div.classList.add("done");
                div.querySelector(".time").textContent = "Done";
                div.querySelector(".break").textContent = "Finished";
            }
        }, 1000);

        taskIntervals[index] = interval;

    });

}

const stopTimers = () => {
    clearInterval(globalInterval);
    taskIntervals.forEach(interval => clearInterval(interval));
    taskIntervals = [];
}
document.getElementById("start").addEventListener("click", startTimers);
document.getElementById("stop").addEventListener("click", stopTimers);

renderTasks();
