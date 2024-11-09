<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register Shelf</title>
  <style>
    /* Reset default styling */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    /* Background with local image */
    body {
      font-family: Arial, sans-serif;
      background: url('debby-hudson-ERb-JXVwAfo-unsplash.jpg') no-repeat center center fixed; /* Adjust path as needed */
      background-size: cover;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      color: #ffffff;
    }

    /* Form container styling */
    .shelf-form {
        background-color:  #ffffff; /* Semi-transparent overlay for readability */
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
      width: 300px;
      text-align: center;
    }

    /* Form title styling */
    .shelf-form h2 {
      margin-bottom: 20px;
      font-size: 24px;
      color: #333333;
    }

    /* Input field styling */
    .shelf-form input[type="text"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
      background-color: #f4f4f9;
      color: #333333;
    }

    /* Button styling */
    .shelf-form button {
      width: 100%;
      padding: 10px;
      background-color: #555555; /* Dark gray */
      border: none;
      color: #ffffff;
      font-weight: bold;
      border-radius: 4px;
      cursor: pointer;
      margin-top: 10px;
    }

    /* Hover effect on button */
    .shelf-form button:hover {
      background-color: #333333; /* Darker on hover */
    }
  </style>
</head>
<body>
  <div class="shelf-form">
    <h2>Register Shelf</h2>
    <form action="addShelf" method="POST">
      <input type="text" name="id" placeholder="Enter Shelf ID" required>
      <button type="submit">Add Shelf</button>
    </form>
  </div>
</body>
</html>
