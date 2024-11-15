
let buttons = document.querySelectorAll("button");

buttons.forEach(button => {
    button.addEventListener("click" , (e) => {
        let currentButonId = e.target.id;
        let currentDiv = document.getElementById(`container${currentButonId}`)


        let allDivs = document.querySelectorAll(".container");
        allDivs.forEach(div =>{
            div.toggleAttribute("hidden" , true);
        });
        currentDiv.toggleAttribute("hidden", false);
    })
});

