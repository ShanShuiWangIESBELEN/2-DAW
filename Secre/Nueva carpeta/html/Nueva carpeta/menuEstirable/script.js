let buttons = document.querySelectorAll("button");
let previewId = null;

buttons.forEach(button => {
    button.addEventListener("click" , (e) => {
        let currentButonId = e.target.id;
        let currentDiv = document.getElementById(`container${currentButonId}`)

        if(previewId !== null){
            currentDiv.toggleAttribute("hidden");
        }

        let allDivs = document.querySelectorAll(".container");
        allDivs.forEach(div =>{
            div.toggleAttribute("hidden" , true);
        });
        currentDiv.toggleAttribute("hidden");
    })
});