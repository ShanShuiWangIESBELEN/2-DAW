async function fetchData(url) {
    const response = await fetch(url);
    return response.json();
}

async function displayUser(user) {
    const userDiv = document.querySelector("#user");
    userDiv.innerHTML = `<img src="${user.avatar_url}" class="imgUser">
                         <span>${user.login}</span>
                         Creation date: ${user.created_at}`;
}

async function displayUsers(containerId, title, users) {
    const containerDiv = document.querySelector(`#${containerId}`);
    containerDiv.innerHTML = `<span>${title} (${users.length})</span>`;

    for (const user of users) {

        containerDiv.innerHTML += `<img src="${user.avatar_url}" class="imgFoll">
                                    <span>${user.login}</span>
                                    Creation date: ${user.created_at}`;
    }
}

async function checkAccount() {
    const username = document.querySelector(".nameGit").value;
    const errorDiv = document.querySelector("#error");

    try {

        const userData = await fetchData(`https://api.github.com/users/${username}`);
        await displayUser(userData);

        const followersData = await fetchData(`https://api.github.com/users/${username}/followers`);
        await displayUsers("followers", "Followers", followersData);

        const followingData = await fetchData(`https://api.github.com/users/${username}/following`);
        await displayUsers("following", "Following", followingData);

        errorDiv.innerHTML = "";

    } catch (error) {
        const userDiv = document.querySelector("#user");
        userDiv.innerHTML = "";
        errorDiv.innerHTML = `<p>Error: ${error.message}</p>`;
    }
}

const button = document.querySelector(".button");
button.addEventListener("click", checkAccount);