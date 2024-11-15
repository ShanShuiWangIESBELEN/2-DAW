console.log(parseInt(10.3));
console.log(parseInt(10, 16)); // hex -> dec
console.log(parseInt(11, 16)); // hex -> dec
console.log(parseInt(10, 2)); // bin -> dec
console.log(parseInt(11, 8)); // bin -> dec

//////////////////////////////////

const a = true;
const b = 'true';

console.log(a == b); // false

let today = new Date();
console.log(today);
console.log(today.getTime());
console.log(today.toString());


/////////////////////////////////////

let str1 = "hola\nnuria"
let str2 = `hi 
                jon`;
console.log(str1);
console.log(str2)


////////////////////////////////////////////

let grades = [1, 5, 6, 3, 10];

let gr = grades.map(g => g*2);
console.log(grades);
console.log(gr);
console.log(grades.filter(g => g >= 5));
console.log(grades.find(g => g == 5));
console.log(grades.findIndex(g => g == 8));
console.log(grades.indexOf(5));
console.log(grades.reduce(g=> g + g));


/////////////////////////////////////////////

function logArrayElements(element, index, array) {
    console.log("This is the " + index + "the content" +  element)
}

function logArrayElements1(element) {
    console.log(element);
}
[2, 5, 9].forEach(logArrayElements1);
[2, 5, 9].forEach(e=> logArrayElements1(e)); //Se puede hacer asi tmb

///////////////////////////////////////////////////


let nums = [1, 5, 6, 3, 10];
console.log(nums.shift());
console.log(nums);
console.log(nums.unshift(55, 66, 77));
console.log(nums);
console.log(nums.push(2, 8, 9));
console.log(nums);
console.log(nums.pop());
console.log(nums);

///////////////////////////////////////////////////
let str10 = "hola nuria";

console.log(str10.split("", 3));
console.log(str10.slice(3));

let listChar = str10.split("");
let listUpper = listChar.map(c => c.toUpperCase());
console.log(listUpper);
let str11 = listUpper.join("");
console.log(str11);

let str12 = str10.split("").map(c=> c.toUpperCase()).join("");
console.log(str12);

