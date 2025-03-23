<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NeoBank - Contact Us</title>
    <link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/homepageStyle.css">
</head>

<body>
    <div id="header-placeholder"></div>

    <main class="contactContainer">
        <h1>Contact Us</h1>
        <p>If you have any questions, comments, or concerns, feel free to reach out to us. Our customer service team is here to assist you.</p>

        <div class="contactDetails">
            <div class="contactInfo">
                <h2>Visit Us</h2>
                <p>NeoBank Main Branch</p>
                <p>1234 Rizal Avenue, Manila, Australia</p>
            </div>

            <div class="contactInfo">
                <h2>Call Us</h2>
                <p>+63 2 8765 4321</p>
                <p>+63 2 1234 5678</p>
            </div>

            <div class="contactInfo">
                <h2>Email Us</h2>
                <p>support@NeoBank.com</p>
            </div>
        </div>

        <form class="contactForm">
            <h2>Send Us a Message</h2>
            <label for="name">Name</label>
            <input type="text" id="name" name="name" placeholder="Your Name" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" placeholder="Your Email" required>

            <label for="message">Message</label>
            <textarea id="message" name="message" placeholder="Your Message" rows="6" required></textarea>

            <input type="submit" value="Send Message">
        </form>
    </main>

    <div id="footer-placeholder"></div>

    <script src="${pageContext.request.contextPath}/javascript/insertHeaderFooter.js"></script>
</body>

</html>
