/* Create a script with 2 string variables. Display both variables between:
- single quotation marks
- double quotation marks
- inverted quotes
a) Using traditional string concatenation
b) Using string literals */


let str1 = "wang";
let str2 = "Shanshui";

/* a */
console.log("'" + str1 + str2 + "'");
console.log('"' + str1 + str2 + '"');
console.log("\"" + str1 + "\"" + str2 + "\"");


console.log("---------------------------------------");


/* b */
console.log(`'${str1} ${str2}'`);
console.log(`"${str1} ${str2}"`);
console.log(`\"${str2} ${str1}\"`);








