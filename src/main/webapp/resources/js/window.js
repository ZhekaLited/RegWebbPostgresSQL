let selectRoles = () => {
    let divSelect = document.body.querySelector(".list__role");

    if (divSelect.style.display === "none") {
        divSelect.style.display = "block";
    }
    else {
        divSelect.style.display = "none";
    }
}
