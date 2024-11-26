/* Write a JavaScript function that hides email addresses to prevent unauthorized access.
Test Data :
console.log(protect_email("robin_singh@example.com"));
robin...@example.com */

function protect_email(email) {
    let parte = email.split("@");
    let parteNombre = parte[0];
    let parteDominio = parte[1];
    let resultado = parteNombre.substring(0, 3) + "...@" + parteDominio;
    return resultado;

    
}

console.log(protect_email("w@example.com"));
