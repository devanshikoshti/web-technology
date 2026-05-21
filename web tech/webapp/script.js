// Client-side validation before sending to the Servlet
function validateForm() {
    const user = document.getElementById("username").value;
    const pass = document.getElementById("password").value;
    const errorMsg = document.getElementById("error-msg");

    if (user.trim() === "" || pass.trim() === "") {
        errorMsg.textContent = "Fields cannot be empty!";
        return false; // Prevents form submission
    }

    errorMsg.textContent = "";
    return true; // Allows form submission
}