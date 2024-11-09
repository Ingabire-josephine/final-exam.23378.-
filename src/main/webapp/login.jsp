<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        /* Reset default styling */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body background styling with image */
        body {
            font-family: Arial, sans-serif;
            background: url('debby-hudson-ERb-JXVwAfo-unsplash.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #ffffff;
        }

        /* Form container styling */
        .login-form {
            background-color: #ffffff; /* Semi-transparent dark background */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
            width: 300px;
            text-align: center;
        }

        /* Form title */
        .login-form h2 {
            margin-bottom: 20px;
            font-size: 24px;
            color: #ffffff;
        }

        /* Input field styling */
        .login-form input[type="text"],
        .login-form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            background-color: #f4f4f9;
            color: #333333;
        }

        /* Button styling */
        .login-form button {
            width: 100%;
            padding: 10px;
            background-color: #555555; /* Dark gray button color */
            border: none;
            color: #ffffff;
            font-weight: bold;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
        }

        /* Hover effect on button */
        .login-form button:hover {
            background-color: #333333; /* Darker on hover */
        }

        /* Signup link styling */
        .signup-link {
            margin-top: 15px;
            font-size: 14px;
            color:#555555;
        }

        .signup-link a {
            color: #555555;  /* Gold color for link */
            text-decoration: none;
        }

        .signup-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<!-- Login Form -->
<div class="login-form">
    <h2>Login</h2>
    <form action="login" method="POST">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
    <p class="signup-link">
        Don't have an account? <a href="register.jsp">Sign up</a>
    </p>
</div>
</body>
</html>
