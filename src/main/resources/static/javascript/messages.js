document.addEventListener("DOMContentLoaded", function() {
    var successMessageElement = document.getElementById("failedMessage");
    if (successMessageElement) {
        var successMessage = successMessageElement.value;
        if (successMessage) {
            alert(successMessage);
        }
    }
});

document.addEventListener("DOMContentLoaded", function() {
    var successMessageElement = document.getElementById("registrationSuccess");
    if (successMessageElement) {
        var successMessage = successMessageElement.value;
        if (successMessage) {
            alert(successMessage);
        }
    }
});