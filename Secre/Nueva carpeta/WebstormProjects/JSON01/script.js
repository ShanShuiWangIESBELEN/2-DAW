/*Based on the JSON data displayed create a web page representing each of the students featured, taking into
account the following:
    ● registrationNum: is a custom data attribute, not visible.
    ● emancipated: the most appropriate control to represent its possible values should be used
    ● photo: if an image exists, the one indicated will be loaded, if not specified,
      a default image will be displayed.*/

let students = {
    "students": [
        {
            registrationNum: "S01",
            name: "Jon Doe",
            age: 21,
            emancipated: true,
            photo: "jon.jpg",
            previousGrades: [7, 8, 10],
        },
        {
            registrationNum: "S02",
            name: "Joe Foo",
            age: 18,
            emancipated: false,
            photo: "",
            previousGrades: [7, 6, 6],
        },
        {
            registrationNum: "S03",
            name: "Jane Bar",
            age: 20,
            emancipated: false,
            previousGrades: [],
        }]
};

const studentsData = students.students;
const studentTable = document.querySelector(".tableData");

studentsData.forEach(student => {
    const row = document.createElement("tr");

    row.innerHTML = `
                <td>${student.registrationNum}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.emancipated ? "✅" : "❌"}</td>
                <td>${student.photo ? `<img src="photos/${student.photo}">` : `<img src="photos/default.jpg">`}</td>
                <td>${student.previousGrades.length > 0 ? student.previousGrades.join(", ") : "/"}</td>
            `;

    studentTable.append(row);
});

