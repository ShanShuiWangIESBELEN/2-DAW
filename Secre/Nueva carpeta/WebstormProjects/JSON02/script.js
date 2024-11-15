let books = {
    "books": [{
        ISBN: crypto.randomUUID(),
        title: "Colmillo Blanco",
        genre: "novel",
        author: ["Jack London"],
        pages: "305",
        published: "1906",
        read: true,
        website: "",
    }, {
        ISBN: crypto.randomUUID(),
        title: "Robinson Crusoe",
        genre: "novel",
        author: ["Daniel Defoe"],
        pages: "230",
        published: "1719",
        read: false,
        website: "",
    }, {
        ISBN: crypto.randomUUID(),
        title: "La isla del tesoro",
        genre: "adventure",
        author: ["Robert Louis Stevenson"],
        pages: "205",
        published: "1883",
        read: true,
        website: "",
    },]
};

let booksData = books.books;
let table = document.querySelector("#tableData");

let showGenres = document.querySelector(".containerButton button:nth-child(1)");
let showTitleMore300 = document.querySelector(".containerButton button:nth-child(2)");
let showTitleMore2Years = document.querySelector(".containerButton button:nth-child(3)");
let showAuthorsNumBooksWritten = document.querySelector(".containerButton button:nth-child(4)");
let showTitleRead = document.querySelector(".containerButton button:nth-child(5)");

function show (booksData){
    table.innerHTML = "";

    booksData.forEach(books => {

        let row = document.createElement("tr");
        row.setAttribute("data-isbn", `${books.ISBN}`);

        row.innerHTML = `
        <td>${books.title}</td>
        <td>${books.genre}</td>
        <td>${books.author}</td>
        <td>${books.pages}</td>
        <td>${books.published}</td>
        <td>${books.read ? "✅" : "❌"}</td>
        <td>${books.website}</td>
    `;
        table.append(row);

    });
}

showGenres.addEventListener("click", () => {
    let genres = Array.from(new Set(booksData.map(book => book.genre)));
    alert(genres);
});

showTitleMore300.addEventListener("click", () => {
    
    let booksId = Array.from(booksData.filter(book => parseInt(book.pages) > 300)
        .map(book => book.ISBN));

    booksId.forEach(b => document.querySelector(`tr[data-isbn="${b}"]`).style.backgroundColor = "lightyellow");
});

showTitleMore2Years.addEventListener("click", () => {
    booksData.forEach(book => document.querySelector(`tr[data-isbn="${b}"]`).style.backgroundColor = "white");
    let books = Array.from(booksData.filter(book => 2023 - book.published > 2))
        .map(book => book.ISBN);

    books.forEach(b => document.querySelector(`tr[data-isbn="${b}"]`).style.backgroundColor = "lightyellow");

});

showAuthorsNumBooksWritten.addEventListener("click", () => {
    let authors = Array.from(booksData.map(book => book.author));
    authors.forEach(b => document.querySelector(`tr[data-isbn="${b}"]`).style.backgroundColor = "lightyellow");
});

showTitleRead.addEventListener("click", () => {
    let books = Array.from(booksData.filter(book => book.read === true)
        .sort(book => book.published)
        .map(book => book.ISBN));

    books.forEach(b => document.querySelector(`tr[data-isbn="${b}"]`).style.backgroundColor = "lightyellow");
});