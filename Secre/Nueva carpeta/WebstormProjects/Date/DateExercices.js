/*1. Write a function that receives a date and displays the corresponding day of the week.
 */

function date (date) {
    const days = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
    let newDay = new Date(date);
    return days[newDay.getDay()];
}

console.log(date("2023-10-18"));


/*2. Write a function that displays the date in the following formats.
- The date will be passed as a parameter, otherwise the current date will be taken.
- The separator (- /) shall be passed as a parameter, otherwise one of them will be set by
default.
● mm-dd-yyyy
● dd-mm-yyyy
 */


/*3. Call the previous function with tomorrow's date
 */
function tomorrowDate (date) {
    let newDate = new Date(date);
    return newDate.setDate(newDate.getDate() + 1)
}

console.log(tomorrowDate("2023-10-18"));


/*4. Write a function that returns a string such as HH:MM:SS from any date.
*/

function stringDate (date){

    return `${date.getHours()} : ${date.getMinutes()} : ${date.getSeconds()}`;
}

console.log(stringDate(new Date));


/*5. Write a function to display the current day and time in the following format.
    Tuesday. Now: 10PM 30:38
 */

function printDate(date) {
    const day = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    days = day[date.getDay()];
    let moment;
    if (date.getHours() < 12){
        moment = "AM";
    }else{
        moment = "PM";
    }
    return `${days}. ${date.getMonth()} ${date.getHours()} ${moment} ${date.getMinutes()}:${date.getSeconds()}`;

}

console.log(printDate(new Date));



/*6. How many days have passed since September 15?
 */

function daysSince(date) {
    const currentDate = new Date();
    const dayNew = new Date(date);
    const difference = currentDate - dayNew;
    return difference / (1000 * 60 * 60 * 24);
}

console.log(daysSince("2023-9-15"));

/*    7. Write a function that calculates the number of school days remaining until the end of the term,
    without taking into account holidays.
*/

/*8. Write a function that indicates in which years from the current year through 2070 September
15 will be Monday.
 */

/*9. Write a function that indicates what day was X days ago and how long it has been since then,
    showing years, months, days, as appropriate.
 */
/*10. Now develop a similar function but for X days from now.
 */
/*11. Write a function that displays a digital clock which is updated every second.
 */
/*12. Create a timer to be updated every second, the initial value can be set in hours, minutes and
seconds.
 */
/*13. Using the previous script, make the high school page load when it reaches 0, you can use the
location object for this purpose.
*/
/*
14. Create a chronometer, to start and stop it, use the corresponding buttons.
 */

