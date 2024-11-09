<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome to Our Library</title>
  <style>
    /* Basic reset for margin, padding, and box sizing */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    /* Body background styling */
    body {
      font-family: Arial, sans-serif;
      background: url('debby-hudson-ERb-JXVwAfo-unsplash.jpg') no-repeat center center fixed;
      background-size: cover;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      color: #ffffff;
      margin: 0;
    }

    /* Navbar styling */
    .navbar {
      width: 100%;
      padding: 15px;
      background-color: rgba(0, 0, 0, 0.7);
      position: fixed;
      top: 0;
      display: flex;
      justify-content: flex-end;
    }

    /* Navbar link styling */
    .navbar a {
      color: #ffffff;
      text-decoration: none;
      padding: 10px 20px;
      font-size: 16px;
      border-radius: 4px;
    }

    .navbar a:hover {
      background-color: #333333;
    }

    /* Main container styling */
    .container {
      text-align: center;
      background-color: rgba(255, 255, 255, 0.9);
      padding: 40px;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
      max-width: 400px;
      width: 100%;
      margin-top: 60px;
    }

    /* Welcome message styling */
    h1 {
      font-size: 28px;
      color: #333333;
      margin-bottom: 20px;
    }

    /* Error message styling */
    .error-message {
      color: red;
      font-size: 16px;
      margin-bottom: 15px;
    }

    /* Button styling */
    .button {
      display: inline-block;
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      font-size: 16px;
      color: #ffffff;
      background-color: #555555;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      text-decoration: none;
      text-align: center;
    }

    /* Hover effect for buttons */
    .button:hover {
      background-color: #333333;
    }
  </style>
</head>
<body>

<!-- Navbar with Sign Up and Login links -->
<div class="navbar">
  <a href="register.jsp">Sign Up</a>
  <a href="login.jsp">Login</a>
</div>

<!-- Main content container -->
<div class="container">
  <!-- Welcome Message -->
  <h1>Welcome to Our Library</h1>

  <!-- Error Message (displayed if error=true in URL) -->
  <%
    // Check if the error parameter is present in the URL
    if ("true".equals(request.getParameter("error"))) {
  %>
  <p class="error-message">Invalid username or password. Please try again.</p>
  <%
    }
  %>

  <!-- Sign Up Button -->
  <a href="register.jsp" class="button">Sign Up</a>

  <!-- Login Button -->
  <a href="login.jsp" class="button">Login</a>
</div>

</body>
</html>
