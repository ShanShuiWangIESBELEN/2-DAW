/* 1. Array with student names, they can have two formats:
- Firstname lastname1 lastname2
- Firstname lastname
Make a function to sort the array by the lastname or lastname1, depending on the case. */

let students = ["Jorge Perez", "Ana Martín Torres", "Luisa Gutierrez Rodriguez ", "Pedro Gómez"];

function sortStudents(students) {
    return students.sort((a, b) => {
        let nameA = a.toUpperCase();
        let nameB = b.toUpperCase();
        if (nameA < nameB) {
            return -1;
        }
        if (nameA > nameB) {
            return 1;
        }
        return 0;
    });
}
console.log(sortStudents(students));