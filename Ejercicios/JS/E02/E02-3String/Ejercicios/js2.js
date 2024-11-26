/* . In this exercise, you will create a function that accepts the components of an email
sending service and combines them into an email body template. To make things more
interesting, only adults are eligible to post comments on the website. Accordingly, the
message text will change.
function sendEmail(name, age, comments, email)
- check the passed parameters. If any are invalid or missing, the function will simply
return null
- use the ternary operator to check whether this person is of legal age or not.
sendEmail("Jane", 27, "Your website is fantastic!",”jane@gmail.com”);
// => "A user has posted a comment from the website:
// => name: Jane
// => age: 27
// => status: Jane is a valid user (jane@gmail.com)
// => comments: Your website is fantastic! */

function sendEmail(name, age, comments, email) {
    if (name === undefined || name === null || name === "" ||
        age === undefined || age === null || age === "" ||
        comments === undefined || comments === null || comments === "" ||
        email === undefined || email === null || email === "") {
        return null;
    }
    if (age < 18) {
        comments = "Sorry, only adults are eligible to post comments on the website.";
    }

    let estado = age < 18 ? "Sorry, only adults are eligible to post comments on the website." : "valid user";

    if (email.indexOf("@") < 3) {
        return null;
    }
    return `A user has posted a comment from the website:
        "name:  + ${name}
        "age:  + ${age}
        "status: + ${estado}
        "comments: " + ${comments}
        "email: " + ${email}`;
}

console.log(sendEmail("Shanshui", 18, "Me gusta los helados", "shanshui@gmail.com"));


