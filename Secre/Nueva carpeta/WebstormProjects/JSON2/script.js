
let books = {
    "books": [
        {
            title: "Vuelta al mundo",
            genre: "ficcion",
            author: ["Julio Verne"],
            pages: 320,
            published: 2000,
            read: false,
            website: "",
        },
        {
            title: "El infierno",
            genre: "ficcion",
            author: ["Carmen Mola"],
            pages: 280,
            published: 2018,
            read: true,
            website: "",
        },
        {
            title: "Hija de las cenizas",
            genre: "dramatico",
            author: ["Ilaria Tuti"],
            pages: 340,
            published: 1980,
            read: true,
            website: "",
        }]
};

const booksData = books.books;
const booksTable = document.querySelector(".tableData");

booksData.forEach(books => {
    const row = document.createElement("tr");

    row.innerHTML = `
                <td>${books.title}</td>
                <td>${books.genre}</td>
                <td>${books.author}</td>
                <td>${books.pages}</td>
                <td>${books.published}</td>
                <td>${books.read ? "✅" : "❌"}</td>
                <td>${books.website}</td>
            `;

    booksTable.append(row);
});

