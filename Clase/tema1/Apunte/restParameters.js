
function demoParameters() {
    console.log("in");
    console.log(arguments);
    console.log(arguments.length);
}


demoParameters("1,2,3,4");

function createPerson(name, surname, ...cities) {

    const person = {};
    person.name = nameA;
    person.surname = surnameA;
    person.locations = cities;

    cities.array.forEach(element => console.log(element));

    console.log(person);
    console.log(person.locations);


    createPerson("John", "Doe", "London", "Berlin", "Paris");
}
