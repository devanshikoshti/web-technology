<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Session Management: Check if user is actually logged in
    if(session.getAttribute("activeUser") == null) {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { border-collapse: collapse; width: 50%; margin-top: 20px; }
        th, td { border: 1px solid black; padding: 10px; text-align: left; }
        th { background-color: #007bff; color: white; }
    </style>
</head>
<body>

    <h2>Welcome to the Portal, <%= session.getAttribute("activeUser") %>!</h2>
    <p>Your session ID is: <%= session.getId() %></p>

    <h3>Registered Courses</h3>
    <table>
        <tr>
            <th>Course ID</th>
            <th>Course Name</th>
        </tr>
        <tr>
            <td>CS101</td>
            <td>Core Java</td>
        </tr>
        <tr>
            <td>WT202</td>
            <td>Web Technologies</td>
        </tr>
    </table>

    <br>
    <form action="logout.jsp" method="post">
        <button type="submit" style="padding: 10px; background-color: red; color: white; border: none;">Logout</button>
    </form>

</body>
</html>