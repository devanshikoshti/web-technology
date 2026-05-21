package com.campus;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // Hardcoded authentication check
        if ("student".equals(user) && "pass123".equals(pass)) {

            // Create a session and store user data
            HttpSession session = request.getSession();
            session.setAttribute("activeUser", user);

            // Redirect to JSP dashboard
            response.sendRedirect("dashboard.jsp");

        } else {
            // Forward back to login with an error message using RequestDispatcher
            response.setContentType("text/html");
            response.getWriter().println("<h4 style='color:red; text-align:center;'>Invalid Credentials!</h4>");

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.include(request, response);
        }
    }
}