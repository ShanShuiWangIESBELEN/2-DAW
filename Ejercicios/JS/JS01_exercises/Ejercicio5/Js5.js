/* 5.b. Create a list of the months of the year, for each month its name, number and number of days are
recorded.
Display the names of the months that have 30 days.
Display the names of even-numbered months.
Display the total number of days of all months. */

let months = [
    { name: "January", number: 1, days: 31 },
    { name: "February", number: 2, days: 28 },
    { name: "March", number: 3, days: 31 },
    { name: "April", number: 4, days: 30 },
    { name: "May", number: 5, days: 31 },
    { name: "June", number: 6, days: 30 },
    { name: "July", number: 7, days: 31 },
    { name: "August", number: 8, days: 31 },
    { name: "September", number: 9, days: 30 },
    { name: "October", number: 10, days: 31 },
    { name: "November", number: 11, days: 30 },
    { name: "December", number: 12, days: 31 },
];

const months30 = months.filter(months => months.days === 30).map(months => months.name);
console.log(months30);
console.log("\n--------------------------");

const evenMonths = months.filter(months => months.number % 2 === 0).forEach(months => console.log(months.name));

console.log("\n--------------------------");

const total = months.reduce((total, months) => total + months.days, 0);
console.log(total);

console.log("\n--------------------------");