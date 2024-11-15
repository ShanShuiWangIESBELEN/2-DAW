package com.example.formu2;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "nombreServlet", value = "/nombre-servlet")
public class NombreServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello ";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + " " + request.getParameter("nombre") + "</h1>");
        out.println("</body></html>");
    }
    public void destroy() {
    }
}