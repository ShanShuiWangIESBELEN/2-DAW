let table = document.querySelector("table");
let previousCol = null;
let previousRow = null;

table.addEventListener('click', event =>{
    const cell = event.target;
    const cellIndex = cell.cellIndex;
    const rowIndex = cell.parentElement.rowIndex
    const trs = document.querySelectorAll('tr');

    if (previousRow !== null){
        trs[previousRow].style.background = "";
    }

    if (previousCol !== null){
        trs.forEach(tr => tr.cells[previousCol].style.background = "");
    }

    trs[rowIndex].style.background = "#ffeeba";
    trs.forEach(tr => tr.cells[cellIndex].style.background = '#ffeeba')
    cell.style.background = "#ffefef";

    previousCol = cellIndex;
    previousRow = rowIndex;
});