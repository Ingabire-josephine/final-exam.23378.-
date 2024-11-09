<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Librarian Page</title>
  <style>
    /* Reset default styling */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    /* Background styling with local image */
    body {
      font-family: Arial, sans-serif;
      background: url('debby-hudson-ERb-JXVwAfo-unsplash.jpg') no-repeat center center fixed;
      background-size: cover;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      color: #ffffff;
      text-align: center;
      flex-direction: column;
    }

    /* Navbar styling */
    .navbar {
      background-color: #333333;
      width: 100%;
      padding: 15px;
      display: flex;
      justify-content: space-around;
      position: absolute;
      top: 0;
      left: 0;
    }

    .navbar a {
      color: #ffffff;
      text-decoration: none;
      font-weight: bold;
      font-size: 16px;
    }

    /* Content styling to center text vertically */
    .content {
      margin-top: auto;
      margin-bottom: auto;
      padding: 20px;
      background-color: rgba(0, 0, 0, 0.6);
      border-radius: 8px;
    }

    .content h1 {
      font-size: 48px;
      margin-bottom: 10px;
    }

    .content p {
      font-size: 20px;
    }
  </style>
</head>
<body>
  <!-- Navigation Bar -->

<div class="navbar">
    <a href="viewBooks.jsp">available books</a>
    <a href="membership.jsp">Request Membership</a>
    <a href="#borrowed-books">borrow  Books</a>
    <a href="#returned-books">request membership</a>

    <a href="#profile">Profile</a>
  </div>

  <!-- Centered Content -->
  <div class="content">
    <h1>Welcome in sutudent page</h1>
    <p>Your digital solution for managing library books, members, and more!</p>
  </div>
</body>
</html>
