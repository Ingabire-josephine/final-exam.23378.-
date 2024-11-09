<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Signup Page</title>
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
    .signup-form {
        background-color:  #ffffff; /* Semi-transparent dark background */
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
      width: 300px;
      text-align: center;
    }

    /* Form title */
    .signup-form h2 {
      margin-bottom: 20px;
      font-size: 24px;
      color: #ffffff;
    }

    /* Input field styling */
    .signup-form input[type="text"],
    .signup-form input[type="tel"],
    .signup-form input[type="password"],
    .signup-form select {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
      background-color: #f4f4f9;
      color: #333333;
    }

    /* Button styling */
    .signup-form button {
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
    .signup-form button:hover {
      background-color: #333333; /* Darker on hover */
    }
  </style>
</head>
<body>
  <!-- Signup Form -->
  <div class="signup-form">
    <h2>Signup</h2>
    <form action="register" method="POST">
      <input type="text" name="username" placeholder="Username" required>
      <input type="text" name="address" placeholder="Address" required>
      <input type="tel" name="phone" placeholder="Phone" required>
      <select name="role" required>
        <option value="">Select Role</option>
        <option value="HOD">HOD</option>
        <option value="Student">Student</option>
        <option value="Dean">Dean</option>
        <option value="manager">Librarian</option>
        <option value="Lecturer">Lecturer</option>
      </select>
      <input type="password" name="password" placeholder="Password" required>
      <input type="password" name="confirmPassword" placeholder="Confirm Password" required>
      <button type="submit">Sign Up</button>
    </form>
  </div>
</body>
</html>
