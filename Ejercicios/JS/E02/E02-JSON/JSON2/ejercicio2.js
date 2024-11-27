
const libros = [
    {
        "titulo": "Hijos de la mente",
        "genero": [
            "Ciencia ficción"
        ],
        "autor": [
            "Orson Scott Card"
        ],
        "pag": 370,
        "fecha": "1996-08-01",
        "leido": true,
        "web": ""
    },
    {
        "titulo": "El nombre del viento",
        "genero": [
            "Fantasía",
            "Aventura"
        ],
        "autor": [
            "Patrick Rothfuss"
        ],
        "pag": 662,
        "fecha": "2007-03-27",
        "leido": true,
        "web": "www.patrickrothfuss.com"
    },
    {
        "titulo": "Tokyo Blues",
        "genero": [
            "Ficción",
            "Romance"
        ],
        "autor": [
            "Haruki Murakami"
        ],
        "pag": 384,
        "fecha": "1987-09-04",
        "leido": true,
        "web": ""
    },
    {
        "titulo": "Alas de sangre",
        "genero": ["Fantasía", "Romance"],
        "autor": ["Rebecca Yarros"],
        "pag": 736,
        "fecha": "2023-11-15",
        "leido": true,
        "web": ""
    },
    {
        "titulo": "Evangelion tomo 1",
        "genero": [
            "Manga",
            "Ciencia ficción"
        ],
        "autor": [
            "Yoshiyuki Sadamoto"
        ],
        "pag": 192,
        "fecha": "1995-12-01",
        "leido": true,
        "web": ""
    },
    {
        "titulo": "Dungeons and Dragons 5e",
        "genero": [
            "Fantasía",
            "Juegos de rol"
        ],
        "autor": [
            "Patrick Rothfuss", "Wizards of the Coast"
        ],
        "pag": 320,
        "fecha": "2014-08-19",
        "leido": true,
        "web": ""
    }
];
//1
function p1(libros) {
    let generos = [];
    libros.map(e => e.genero).forEach(e => {
        for (let gen of e) {
            if (!generos.includes(gen))
                generos.push(gen);
        }
    });

    document.querySelector("#uno").innerHTML = `<p>Los generos son: ${generos}</p>`
};
//2
let p2 = (libros) => {
    document.querySelector("#dos").innerHTML = "<p>"
    libros.filter(e => e.pag > 300).forEach(e => document.querySelector("#dos").innerHTML += `${e.titulo}  ${e.pag} <br>`);
    document.querySelector("#dos").innerHTML += "</p>";
}

//3
let p3 = (libros) => {
    libros.filter(e => e.fecha < "2022").forEach(e => document.querySelector("#tres").innerHTML += "<p>" + e.titulo + " " + e.fecha + "</p>");
}

//4
let p4 = (libros) => {
    let autorNum = {};

    libros.forEach(e => {
        e.autor.forEach(a => {
            if (autorNum[a]) {
                autorNum[a]++;
            } else {
                autorNum[a] = 1;
            }
        });
    });
    for (autor in autorNum) {
        document.querySelector('#cuatro').innerHTML += '<p>' + autor + '</p>';
    }
}

//5
let p5 = (libros) => {
    libros.filter(e => e.leido)
        .sort((a, b) => new Date(a.fecha) - new Date(b.fecha))
        .forEach(e => document.querySelector('#cinco').innerHTML += '<p>' + e.titulo + ' ' + e.leido + ' ' + e.fecha + '</p>');
}

document.querySelector('#p1').onclick = () => p1(libros);
document.querySelector('#p2').onclick = () => p2(libros);
document.querySelector('#p3').onclick = () => p3(libros);
document.querySelector('#p4').onclick = () => p4(libros);
document.querySelector('#p5').onclick = () => p5(libros);
