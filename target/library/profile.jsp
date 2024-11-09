<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Request Membership</title>
</head>
<body>
    <h2>Request Membership</h2>
    <form action="requestMembership" method="post">
        <label for="type">Select Membership Type:</label>
        <select id="type" name="type">
            <option value="Gold">Gold</option>
            <option value="Silver">Silver</option>
            <option value="Striver">Striver</option>
        </select>
        <button type="submit">Request Membership</button>
    </form>
</body>
</html>
