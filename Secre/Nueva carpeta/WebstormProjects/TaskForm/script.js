async function getRemoteData(url) {
    let response = await fetch(url);
    if (response.ok && response.status === 200) {
        return response.json();
    } else {
        throw new Error("error...");
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////

let create = document.querySelector("#create");
let arrayTask = [];

let url = 'assets/work.json';

getRemoteData(url)
    .then(data => {
        showData(data);
    })
    .catch(error => {
        console.log(error);
    });

////////////////////////////////////////////////////////////////////////////////////////////////

function showData(allData) {
    let tasks = allData.work;
    for (let index = 0; index < tasks.length; index++) {
        let tr = document.createElement("tr");
        if (tasks[index].complete) {
            tr.innerHTML = `
                        <td hidden>${tasks[index].id}</td>
                        <td>${tasks[index].name}</td>
                        <td>${tasks[index].assignment}</td>
                        <td>${tasks[index].priority}</td>
                        <td>${tasks[index].dateCreation}</td>
                        <td>${tasks[index].dateCompletion}</td>
                        <td><button type="button" class="eliminate">Eliminate</button> 
                            <button type="button" class="edit">Edit</button>
                            <input type="checkbox" class="checkbox" checked disabled>
                            </td>
                       `
            $(".table-container #tbody").append(tr);

                addTask(tasks, index);
            tr.style.background = "lightgreen"
        } else {
            tr.innerHTML = `
                        <td hidden>${tasks[index].id}</td>
                        <td>${tasks[index].name}</td>
                        <td>${tasks[index].assignment}</td>
                        <td>${tasks[index].priority}</td>
                        <td>${tasks[index].dateCreation}</td>
                        <td>${tasks[index].dateCompletion}</td>
                        <td><button type="button" class="eliminate">Eliminate</button> 
                            <button type="button" class="edit">Edit</button>
                            <input type="checkbox" class="checkbox">
                            </td>
                       `
            $(".table-container #tbody").append(tr);

               addTask(tasks, index);
        }

    }

    checkboxes(allData)
    eliminate();

    let edit = document.querySelectorAll(".edit");
    edit.forEach((ed, index) => {
        ed.addEventListener("click", (e) => {

            let taskToEdit = tasks[index];

            document.getElementById("name").value = taskToEdit.name;
            document.getElementById("assignment").value = taskToEdit.assignment;
            document.getElementById("datepicker").value = taskToEdit.dateCreation;
            document.getElementById("priority").value = taskToEdit.priority;

            $("#create").data("index", e.target.closest("tr").querySelector("td:nth-child(1)").textContent)
        })

    })

}

////////////////////////////////////////////////////////////////////////////////////////////////

create.addEventListener("click", (e) => {

    let name = document.getElementById("name").value;
    let assignment = document.getElementById("assignment").value;
    let dateCreation = document.getElementById("datepicker").value;
    let priority = document.getElementById("priority").value;
    let tr = document.createElement("tr");
    console.log(e.target)
    let index = $("#create").data("index")

    let work = {
        id: arrayTask.length + 1,
        name: name,
        assignment: assignment,
        priority: priority,
        dateCreation: dateCreation,
        dateCompletion: "",
        complete: false
    }

    if (index !== undefined){
        updateRow(index, work)
    }else {

        arrayTask.push(work)

        tr.innerHTML = `
        <td hidden>${work.id}</td>
        <td>${name}</td>
        <td>${assignment}</td>
        <td>${priority}</td>
        <td>${dateCreation}</td>
        <td></td>
        <td>
            <button type="button" class="eliminate">Eliminate</button> 
            <button type="button" class="edit">Edit</button>
            <input type="checkbox" class="checkboxes">
        </td>
    `;

        $(".table-container #tbody").append(tr);
        eliminate()
        checkbox(work)
    }


})


function formatDate(dateString) {
    const options = {year: 'numeric', month: 'numeric', day: 'numeric'};
    return new Date(dateString).toLocaleDateString(undefined, options);
}

////////////////////////////////////////////////////////////////////////////////////////////////
function addTask(tasks, index) {
    arrayTask.push(
        {
            id: tasks[index].id,
            name: tasks[index].name,
            assignment: tasks[index].assignment,
            priority: tasks[index].priority,
            dateCreation: tasks[index].dateCreation,
            dateCompletion: tasks[index].dateCompletion,
            complete: tasks[index].complete
        }
    )
}

function eliminate() {
    let eliminate = document.querySelectorAll(".eliminate");

    eliminate.forEach(eli => {
        eli.addEventListener("click", (e) => {
            for (let i = 0; i < arrayTask.length; i++) {
                if (parseInt(e.target.closest("tr").querySelector('td:first-child').textContent) === (parseInt(arrayTask[i].id))){
                    arrayTask.splice(i, 1);
                }
            }
            e.target.closest("tr").remove();
        })
    })
}

function checkboxes(allData) {
    let checkboxes = document.querySelectorAll(".checkbox");

    checkboxes.forEach((checkbox, index) => {
        checkbox.addEventListener("change", (e) => {
            e.target.disabled = true;

            let row = e.target.closest("tr");
            row.style.backgroundColor = "lightgreen";

            allData.work[index].complete = true;
            allData.work[index].dateCompletion = new Date().toISOString();
            arrayTask[index].complete = true;

            row.querySelector("td:nth-child(6)").textContent = formatDate(allData.work[index].dateCompletion);

        });
    });
}

function checkbox(work) {
    let checkboxes = document.querySelectorAll(".checkboxes");

    checkboxes.forEach((checkbox, index) => {

        checkbox.addEventListener("change", (e) => {
            e.target.disabled = true;

            let row = e.target.closest("tr");
            row.style.backgroundColor = "lightgreen";

            work.complete = true;
            work.dateCompletion = new Date().toISOString();
            arrayTask[arrayTask.length - 1].complete = true;

            row.querySelector("td:nth-child(6)").textContent = formatDate(work.dateCompletion);
        });
    });
}

function updateRow(index, data){
    let currentRow = $(".table-container #tbody tr").eq(index)

    currentRow.find("td").eq(1).text(data.name)
    currentRow.find("td").eq(2).text(data.assignment)
    currentRow.find("td").eq(3).text(data.priority)
    currentRow.find("td").eq(4).text(data.dateCreation)
    currentRow.find("td").eq(5).text(data.dateCompletion)

}

