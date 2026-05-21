package com.campus;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

// Intercepts requests going to the AuthServlet
@WebFilter("/AuthServlet")
public class ValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String user = request.getParameter("username");

        // Server-side validation
        if (user == null || user.trim().isEmpty()) {
            response.setContentType("text/html");
            response.getWriter().write("<h3>Error: Username cannot be blank (Caught by Filter)</h3>");
            response.getWriter().write("<a href='index.html'>Go Back</a>");
        } else {
            // Pass the request down the chain to the Servlettt..
            chain.doFilter(request, response);
        }
    }
}
