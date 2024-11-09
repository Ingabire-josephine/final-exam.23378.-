<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>View Books</title>
</head>
<body>
<h2>View Books</h2>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Author</th>
    <th>Shelf</th>
  </tr>
  <c:forEach var="book" items="${books}">
    <tr>
      <td>${book.id}</td>
      <td>${book.name}</td>
      <td>${book.author}</td>
      <td>${book.shelfid}</td>
    </tr>
  </c:forEach>
</table>
<p>Total number of books: ${books.size()}</p>
<a href="index.jsp">Return</a>
</body>
</html>
