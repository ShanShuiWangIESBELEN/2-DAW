/* 5. Write a JavaScript program to convert a comma-separated value (CSV) string to a 2D
array. */

function csv() {
    const csvString = `1,2,3
                        me,entiendes,o no?
                        lo,siento,perdón`;

    const arrayLineas = csvString.split('\n');

    const array = arrayLineas.map(row => row.split(','));

    console.log(array);
}

csv()