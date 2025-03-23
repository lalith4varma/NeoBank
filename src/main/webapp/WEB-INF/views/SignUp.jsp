<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/NeoBank-artstyle.css">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/NeoBank_favicon.png">
    <script>
        function togglePasswordVisibility() {
            var passwordField = document.getElementById("pass");
            var confirmPasswordField = document.getElementById("confirmPass");
            var toggleButton = document.getElementById("togglePassword");

            if (passwordField.type === "password") {
                passwordField.type = "text";
                confirmPasswordField.type = "text";
                toggleButton.textContent = "Hide";
            } else {
                passwordField.type = "password";
                confirmPasswordField.type = "password";
                toggleButton.textContent = "Show";
            }
        }

        function validatePasswords() {
            var password = document.getElementById("pass").value;
            var confirmPassword = document.getElementById("confirmPass").value;
            if (password !== confirmPassword) {
                alert("Passwords do not match!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <div class="introContainer">
        <img class="NeoBankImg" src="${pageContext.request.contextPath}/images/NeoBank.png">
        <h1>Create Your NeoBank Account</h1>
        <label>Welcome to NeoBank, the heart of Filipino banking. Proudly created by the Filipino people, for the Filipino people. Your trusted partner in financial growth, where every transaction is handled with care and integrity. Secure your future with us - because at NeoBank, your success is our mission.</label>
    </div>

    <div class="loginContainer">
        <form:form action="processSignUp" modelAttribute="s_creds" onsubmit="return validatePasswords()">
            <label for="acctNum">Account</label>
            <form:input name="acctNum" type="number" placeholder="Account Number" path="acctNum" required="true"/>
            <form:errors path="acctNum" cssClass="form-error"></form:errors>

            <label for="pass">Password</label>
            <form:input id="pass" name="pass" type="password" placeholder="Password" path="password" required="true"/>
            <button type="button" id="togglePassword" onclick="togglePasswordVisibility()">Show</button>
            <form:errors path="password" cssClass="form-error"></form:errors>

            <label for="confirmPass">Confirm Password</label>
            <form:input id="confirmPass" name="confirmPass" type="password" placeholder="Confirm Password" path="confirmPassword" required="true"/>
            <form:errors path="confirmPassword" cssClass="form-error"></form:errors>

            <input type="submit" value="Sign Up">
            <label>Already have an account? Login <a href="../login/">here</a></label>
        </form:form>
    </div>
</body>
</html>
