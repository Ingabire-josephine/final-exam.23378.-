<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
<h2>List of Users</h2>
<table border="1">
    <tr>
        <th>Username</th>
        <th>Address</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.username}</td>
            <td>${user.address}</td> <!-- Replace 'address' if needed -->
        </tr>
    </c:forEach>
</table>
<br>
<a href="index.jsp">Return to Home</a>
</body>
</html>
