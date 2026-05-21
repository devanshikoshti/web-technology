<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Destroy the session
    session.invalidate();
    response.sendRedirect("index.html");
%>