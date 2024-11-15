"use strict";
var result;
function whatIs(result) {
    if (typeof result === "string") {
        return console.log("String");
    }
    else if (typeof result === "boolean") {
        return console.log("Boolean");
    }
    else {
        return console.log("Number");
    }
}
result = 1;
whatIs(result);
result = "true";
whatIs(result);
result = "hola";
whatIs(result);
