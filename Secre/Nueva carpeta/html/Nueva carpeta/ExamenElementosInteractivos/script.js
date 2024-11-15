document.addEventListener("DOMContentLoaded", () => {
    let id = 0;
    let images = document.querySelectorAll("img");
    document.querySelector("#right").addEventListener("click", () => {
        images[id].toggleAttribute("hidden");
        images[id].classList.add("animationR")
        id == 3 ? id : id++;
        console.log(id);
        images[id].toggleAttribute("hidden")
        images[id].classList.add("animationR")
    })
    document.querySelector("#left").addEventListener("click", () => {
        images[id].toggleAttribute("hidden");
        images[id].classList.remove("animationR")
        images[id].classList.add("animationL")
        id == 0 ? id : id--;
        console.log(id);
        images[id].toggleAttribute("hidden")
        images[id].classList.remove("animationL")
    })
    document.querySelector("#buttons").addEventListener("click", (ev) => {
        if(ev.target.id){
            images[id].toggleAttribute("hidden");
            id = ev.target.id;
            console.log(id)
            images[id].toggleAttribute("hidden"); 
        }
    })
})