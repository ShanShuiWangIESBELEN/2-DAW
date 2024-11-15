/* Create a script that removes all duplicate elements in an array. */

let array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
function removeScript(array) {
    /* return array.filter((item,index) => array.indexOf(item)===index); */
    return [...new Set(array)];

}

console.log(removeScript(array));