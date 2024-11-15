/*1. Create a function which prompts for a number until the visitor enters a valid numeric value.
- The resulting value must be returned as a number.
- The visitor can also stop the process by entering an empty line, some whitespaces or
pressing “CANCEL”. In that case, the function should return null.
*/

/*function numberValid() {

    let number, numberValid = Math.random() * 10;
    let next = true;

    do {
        number = prompt("Escribe un número: ");
        if (number === ' ' || number === "CANCEL" || number === '') {
            return false;
        } else next = !number.equals(numberValid);

    } while (next);

    return numberValid;
}

console.log("\nExercise1: " + numberValid());*/
/*2. Create a function that displays:
    a) A random number between 0 and 1.
b) When passed two values it generates a random number between those two values.
*/

function random(){
    
}
/*3. Write a function that predicts your fortune with a message like this: "You will be an X in Y,
and married to Z with N children".
Each value predicted is taken randomly from an array specifically dedicated to it, where
several values will be available:
    - N: number of children
- Z: name of the couple
- Y: geographic location
- X: job position.
*/

function fortune() {

    let numberChildren = [0, 1, 2, 3, 4, 5];
    let nameCouple = ["Susana", "Paca", "Pepi", "Maria", "Lucia"];
    let location = ["Malaga", "Barcelona", "Galicia", "Pais Vasco", "Canarias"];
    let job = ["Waiter", "Programmer", "Sweeper", "Taxi driver", "Teacher"];

    return `You will be an ${job[random(6)]} in ${location[random(5)]}, and married to ${nameCouple[random(5)]} with ${numberChildren[random(5)]} children.`
}

function random(max) {
    return Math.floor(Math.random() * max)
}

console.log("\nExercise3: " + fortune());

/*4. Credit Card Validation follows these rules:
    - Number must be 16 digits, all of them must be numbers
- You must have at least two different digits represented (all of the digits cannot be the
same)
- The final digit must be even
- The sum of all the digits must be greater than 16
Create a function that takes a credit card number as argument and returns true or false after
validation.
    The following credit card numbers are valid:
    ● 9999777788880000
● 6666666666661666
The following credit card numbers are invalid:
    ● a92332119c011112 invalid characters
● 4444444444444444 only one type of number
● 1111111111111110 sum less than 16
● 6666666666666661 odd final number
*/

function creditCardValidation(creditCard) {
    let digits = creditCard.split('');

    if (digits.length === 16) {
        if (twoDifferentDigits(digits)) {
            if (finalDigitEven(digits)) {
                if (sumAllDigits16(digits)) {
                    return "Card number is valid."
                }
                return "Card number is invalid: sum less than 16.";
            }
            return "Card number is invalid: odd final number.";
        }
        return "Card number is invalid: only one type of number.";
    }
    return "Card number is invalid: length less than 16.";
}

function twoDifferentDigits(digits) {

    for (let index = 1; index < digits.length; index++) {
        if (digits[0] !== digits[index]) {
            return true;
        }
    }
    return false;
}

function finalDigitEven(digits) {
    return digits[digits.length - 1] % 2 === 0;
}

function sumAllDigits16(digits) {
    let total = 0;
    for (let index = 0; index < digits.length; index++) {
        total += digits[index];
    }
    return total > 16;
}

console.log("\nExercise4: " + creditCardValidation("1234567812345678"));
console.log("Exercise4: " + creditCardValidation("4444444444444444"));
console.log("Exercise4: " + creditCardValidation("111111111111110"));
console.log("Exercise4: " + creditCardValidation("6666666666666661"));

/*5. A valid credit card number may also contain dashes, to make a card number easier to
read. For example, the following credit card numbers are now also valid:
    ● 9999-7777-8888-0000
● 6666-6666-6666-1666
Update your function to allow such numbers.
*/
function creditCardValidationDashes(creditCard) {
    return creditCardValidation(creditCard.split('-').join(''));
}

console.log("\nExercise5: " + creditCardValidationDashes("1234-5678-1234-5678"));
console.log("Exercise5: " + creditCardValidationDashes("4444-4444-4444-4444"));
console.log("Exercise5: " + creditCardValidationDashes("1111-1111-1111-111"));
console.log("Exercise5: " + creditCardValidationDashes("6666-6666-6666-6661"));
console.log("Exercise5: " + creditCardValidationDashes("9999-7777-8888-0000"));
console.log("Exercise5: " + creditCardValidationDashes("6666-6666-6666-1666"));

//6. Check expiration date

/*7. Return an object indicating whether the credit card is valid, and if not, what the error is
● {valid: true, number: 'a923-3211-9c01-1112'}
● {valid: false, number: 'a923-3211-9c01-1112', error: ‘wrong_length’}
 */

function creditCardValidationObject(creditCard) {

    let result = {
        valid: true,
        number: creditCard,
    };

    let digits = result.number.split('');

    if (digits.length === 16) {
        result.valid = false;
        result.error = "wrong_length";
    } else if (twoDifferentDigits(digits)) {
        result.valid = false;
        result.error = "single_digit";
    } else if (finalDigitEven(digits)) {
        result.valid = false;
        result.error = "odd_final_digit";
    } else if (sumAllDigits16(digits)) {
        result.valid = false;
        result.error = "low_sum";
    }
    return result;
}

console.log("\nExercise5: " + creditCardValidationObject("1234-5678-1234-5678"));
console.log("Exercise5: " + creditCardValidationObject("4444-4444-4444-4444"));
console.log("Exercise5: " + creditCardValidationObject("1111-1111-1111-111"));
console.log("Exercise5: " + creditCardValidationObject("6666-6666-6666-6661"));