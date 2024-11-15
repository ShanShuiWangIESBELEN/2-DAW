async function getRemoteData(url) {
    let response = await fetch(url);
    if (response.ok && response.status === 200) {
        return response.json();
    } else {
        throw new Error("error...");
    }
}

let url = 'members.json';
let allMembers = await getRemoteData(url);
let url2 = 'task.json';
let allTasks = await getRemoteData(url2);

let containerMembers = document.querySelector("#container2");
//let containerToDo = document.querySelector("#container3");
let containerToDo = document.querySelector("#toDo");
let containerInPro = document.querySelector("#container4");
let containerDone = document.querySelector("#container5");
let button = document.querySelector("#submit");
let nombre = document.querySelector("#task");
let description = document.querySelector("#descripcion");
let muestraTodo = document.querySelector("#muestraTodo");
let ultimoCont = document.querySelector("#mostrar");


showTasks(allTasks);

function showTasks(allData) {

    let tasks = allData.tasks;
    let toDo = "toDo";
    let inPro = "inPro";
    let done = "done";

    for (let i = 0; i < tasks.length; i++) {
        tasks[i].creationDate = new Date();
        if (tasks[i].state == toDo){
                //let div = document.createElement("div");
                //div.id = `${tasks[i].id}`;
                //div.setAttribute("draggable" , "true");
                containerToDo.innerHTML +=`<div id="${tasks[i].id}" draggable="true"></div>
                                <p>${tasks[i].title}</p>
                                <p>${tasks[i].description}</p>`;
                //containerToDo.append(div);
        }
        if (tasks[i].state == inPro){
            let div = document.createElement("div");
            div.id = `${tasks[i].id}`;
            div.innerHTML =`<p>${tasks[i].title}</p>
                            <p>${tasks[i].description}</p>
                            <input type="checkbox"> `;
            containerInPro.append(div);
        }
        if (tasks[i].state == done){
            let div = document.createElement("div");
            div.id = `${tasks[i].id}`;
            div.innerHTML =`<p>${tasks[i].title}</p>
                            <p>${tasks[i].description}</p>`;
            containerDone.append(div);
        }
    }


    /*console.log(members)
    for (let i = 0; i < members.length; i){
        let div = document.createElement("div");

        div.innerHTML += `<img id="${members[i].id}" src=".${members[i].url}">`;

        containerMembers.append(div);

    }*/
}


////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////


containerMembers.addEventListener("dragstart",(e) => {
    e.dataTransfer.setData("id", e.target.id);
})

containerMembers.addEventListener("dragover", (e) => {
    e.preventDefault();
});

containerToDo.addEventListener("dragover", (e) => {
    e.preventDefault();
});

containerToDo.addEventListener("drop",(e) => {

    let idMember = e.dataTransfer.getData("id");
    let members = allMembers.members;

    let member = members.find(member => member.id.toString() === idMember);
    let tasks = allTasks.tasks;
    for (let i = 0; i < tasks.length; i++) {
        if (tasks[i].state == "toDo"){
            let img = document.createElement("img");
            img.src = `${member.photo}`;
            img.id = `${member.id}`;
            containerToDo.appendChild(img);
            i = tasks.length;
        }

    }
})

////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////


/*for (let i = 0; i < containerToDo.childNodes.length; i++) {
    if (containerToDo.childNodes[i] === "1" || containerToDo.childNodes[i] == 2){
        containerToDo.childNodes[i].addEventListener("dragstart",(e) => {
            e.dataTransfer.setData("id", e.target.id);
        })
        containerToDo.childNodes[i].addEventListener("dragover", (e) => {
            e.preventDefault();
        });
    }
}
*/
containerToDo.addEventListener("dragover", (e) => {
    e.preventDefault();
});

containerToDo.addEventListener("dragstart",(e) => {
    console.log(e.target)
    e.dataTransfer.setData("id", e.target.id);

})



containerInPro.addEventListener("drop", (e) => {
    let idMember = e.dataTransfer.getData("id");

    let tasks = allTasks.tasks;
    for (let i = 0; i < tasks.length; i++) {
        if (tasks[i].state == "toDo" && tasks[i].id == idMember) {

            let div = document.createElement("div");
            div.innerHTML =`
                            <p>${tasks[i].title}</p>
                            <p>${tasks[i].description}</p>
                            <input type="checkbox"> `;
            containerInPro.appendChild(div);

            tasks[i].state = "inPro";
            showTasks(allTasks);
            console.log(allTasks)

        }

    }
})

containerInPro.addEventListener("dragover", (e) => {
    e.preventDefault();
});

//////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////


button.addEventListener("click", (e) => {
    let tasks = allTasks.tasks;
    tasks.push([tasks.length + 1, nombre.value, description.value, [], "", "toDo"]);

    let div = document.createElement("div");
    div.id = tasks[tasks.length - 1].id;

    div.innerHTML =`<p>${tasks[tasks.length - 1][1]}</p>
                                <p>${tasks[tasks.length - 1][2]}</p>`;
    containerToDo.append(div);
})

//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////


containerInPro.addEventListener("change", (e) => {

    let checkbox = e.target.parentNode.id;
    console.log(e.target.parentNode)



})


//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////


muestraTodo.addEventListener("click", (e) => {

    let tasks = allTasks.tasks;
    console.log(tasks)
    for (let i = 0; i < tasks.length; i++) {
        let div = document.createElement("div");

        div.innerHTML =`<p>${tasks[i].id}
                        ${tasks[i].title}
                        ${tasks[i].description}
                        ${tasks[i].state}
                        ${tasks[i].members}
                        ${tasks[i].creationDate}</p>`
        ultimoCont.append(div);
    }

})
