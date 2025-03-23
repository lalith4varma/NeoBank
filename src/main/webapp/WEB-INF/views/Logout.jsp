<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirm Logout</title>
    <link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/homepageStyle.css">
</head>

<body>
    <div class="confirmLogoutContainer">
        <h1>Confirm Logout?</h1>
        <div class="buttonContainer">
            <a href="../home/" class="cancelButton">Cancel</a>
            <form action = "../logout/" method="POST">
            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            	<button type="submit" class="logoutButton">Logout</button>
            <form>
        </div>
    </div>
</body>

</html>
