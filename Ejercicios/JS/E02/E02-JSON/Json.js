const libros = [
    {
        "title": "The Hobbit",
        "genre": "Fantasy",
        "authors": [
            "JRR Tolkien"
        ],
        "pages": 310,
        "published": "March 21, 1937",
        "read": true,
        "website": ""
    },
    {
        "title": "1984",
        "genre": "Dystopian",
        "authors": [
            "George Orwell"
        ],
        "pages": 328,
        "published": "1949-06-08",
        "read": false,
        "website": "https://www.george-orwell.org/1984"
    },
    {
        "title": "Good Omens",
        "genre": "Fantasy",
        "authors": [
            "Neil Gaiman",
            "Terry Pratchett"
        ],
        "pages": 412,
        "published": "1990-05-01",
        "read": true,
        "website": "https://www.goodomens.com"
    },
    {
        "title": "The Great Gatsby",
        "genre": "Classics",
        "authors": [
            "F. Scott Fitzgerald"
        ],
        "pages": 180,
        "published": "1925-04-10",
        "read": false,
        "website": ""
    }
]

// 1. Name of each of the genres.
let genres = []
libros.forEach(libro => {
    genres.push(libro.genre)
})

console.log("Ejercicio 1:\n")
console.log(genres + "\n")

// 2. Title of books with more than 300 pages
console.log("Ejercicio 2:\n");
let titles = libros.filter(libro => libro.pages > 300).map(libro => libro.title);
titles.forEach(title => console.log(title));

//Title of books published more than 2 years ago
console.log("Ejercicio 3:\n")
libros.filter(e => e.published < "2022").forEach(e => console.log(e.title, e.published));
console.log("\n");

// 4. Name of the authors and number of books they have written.
console.log("Ejercicio 4:\n")
let authorsNum = {};
libros.forEach(libro => {
    libro.authors.forEach(author => {
        if (authorsNum[author]) {
            authorsNum[author] += 1;
        } else {
            authorsNum[author] = 1;
        }
    });
});

for (let author in authorsNum) {
    console.log(`${author}: ${authorsNum[author]} libro(s)`);
}
console.log("\n");

//  Title of the books read, ordered by date of publishing.
console.log("Ejercicio 5:");
libros.filter(libro => libro.read)
    .sort((a, b) => new Date(a.published) - new Date(b.published))
    .forEach(libro => console.log(libro.title + " - " + libro.published));
