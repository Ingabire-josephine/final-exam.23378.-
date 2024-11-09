<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Approve Membership Requests</title>

    <style>
        /* Reset default styling */
          /**<label for="shelf">Shelf:</label>
                <select id="shelf" name="shelf">
                    <c:forEach var="shelf" items="${shelves}">
                        <option value="${shelf.id}"></option>
                    </c:forEach>
                </select><br><br>*/

        * {
          margin: 0;
          padding: 0;
          box-sizing: border-box;
        }

        /* Page background with library image */
        body {
          font-family: Arial, sans-serif;
          background: url('debby-hudson-ERb-JXVwAfo-unsplash.jpg')  no-repeat center center fixed; /* Path to the bookshelf image */
          background-size: cover;
          display: flex;
          justify-content: center;
          align-items: center;
          height: 100vh;
          color: #ffffff;
        }

        /* Form container styling */
        .register-book-form {
          background-color:  #ffffff; /* Semi-transparent overlay for readability */
          padding: 20px;
          border-radius: 8px;
          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
          width: 300px;
          text-align: center;
        }

        /* Form title styling */
        .register-book-form h2 {
          margin-bottom: 20px;
          font-size: 24px;
          color: #ffffff;
        }

        /* Input field styling */
        .register-book-form input[type="text"] {
          width: 100%;
          padding: 10px;
          margin-bottom: 15px;
          border: 1px solid #ccc;
          border-radius: 4px;
          background-color: #f4f4f9;
          color: #333333;
        }

        /* Button styling */
        .register-book-form button {
          width: 100%;
          padding: 10px;
          background-color: #555555; /* Dark gray for button color */
          border: none;
          color: #ffffff;
          font-weight: bold;
          border-radius: 4px;
          cursor: pointer;
          margin-top: 10px;
        }

        /* Hover effect on buttons */
        .register-book-form button:hover {
          background-color: #333333; /* Darker shade on hover */
        }
      </style>

</head>
<body>
<h2>Membership Requests</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Student Name</th>
        <th>Membership Type</th>
        <th>Approved</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="request" items="${requests}">
        <tr>
            <td>${request.id}</td>
            <td>${request.studentId}</td>
            <td>${request.membershipType}</td>
            <td>${request.isApproved}</td>
            <td><a href="approveMembership?id=${request.id}">Approve</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
