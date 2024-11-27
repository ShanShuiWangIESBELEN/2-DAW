/* Create a list with people. Show the names of those whose age is greater or equal than 18.
{name: ‘Jon’, age: 30}  */

let people = [
    { name: "Jon", age: 30 },
    { name: "Samuel", age: 25 },
    { name: "Ana", age: 28 },
    { name: "John", age: 27 },
    { name: "Alice", age: 10 },
    { name: "Peter", age: 18 },
    { name: "Jack", age: 17 },
    { name: "Jill", age: 15 },
    { name: "Sara", age: 16 },

];

const adults = people.filter(people => people.age >= 18).forEach(people => console.log(people.name));






