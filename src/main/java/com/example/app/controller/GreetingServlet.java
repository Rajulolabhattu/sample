package com.example.app.controller;

import com.example.app.model.Greeting;
import com.example.app.service.GreetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet that handles greeting requests.
 */
@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GreetingService greetingService;
    
    @Override
    public void init() throws ServletException {
        super.init();
        greetingService = new GreetingService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list";
        }
        
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "view":
                viewGreeting(request, response);
                break;
            case "delete":
                deleteGreeting(request, response);
                break;
            default:
                listGreetings(request, response);
                break;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("create".equals(action)) {
            createGreeting(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/greeting");
        }
    }
    
    private void listGreetings(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setAttribute("greetings", greetingService.getAllGreetings());
        request.getRequestDispatcher("/WEB-INF/views/greeting-list.jsp").forward(request, response);
    }
    
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/greeting-form.jsp").forward(request, response);
    }
    
    private void createGreeting(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String name = request.getParameter("name");
        greetingService.createGreeting(name);
        response.sendRedirect(request.getContextPath() + "/greeting");
    }
    
    private void viewGreeting(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        
        try {
            long id = Long.parseLong(idParam);
            Greeting greeting = greetingService.findGreetingById(id);
            
            if (greeting != null) {
                request.setAttribute("greeting", greeting);
                request.getRequestDispatcher("/WEB-INF/views/greeting-view.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/greeting");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/greeting");
        }
    }
    
    private void deleteGreeting(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        
        try {
            long id = Long.parseLong(idParam);
            greetingService.deleteGreeting(id);
        } catch (NumberFormatException e) {
            // Ignore, just redirect
        }
        
        response.sendRedirect(request.getContextPath() + "/greeting");
    }
}