<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sample Web Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .jumbotron {
            padding: 2rem 1rem;
            margin-bottom: 2rem;
            background-color: #e9ecef;
            border-radius: 0.3rem;
        }
        .greeting-app {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        .app-title {
            color: #0d6efd;
            margin-bottom: 1.5rem;
            transition: color 0.3s ease;
        }
        .app-title:hover {
            color: #0a58ca;
        }
        .feature-card {
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            margin-bottom: 1rem;
        }
        .feature-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <div class="greeting-app">
        <div class="jumbotron text-center">
            <h1 class="app-title">Welcome to Greeting Application</h1>
            <p class="lead">A sample Java web application deployed on Tomcat</p>
            <a href="${pageContext.request.contextPath}/greeting" class="btn btn-primary btn-lg">View Greetings</a>
        </div>
        
        <div class="row mt-4">
            <div class="col-md-4">
                <div class="card feature-card">
                    <div class="card-body">
                        <h5 class="card-title">Create Greetings</h5>
                        <p class="card-text">Create personalized greeting messages with your name.</p>
                        <a href="${pageContext.request.contextPath}/greeting?action=create" class="btn btn-outline-primary">Create</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card feature-card">
                    <div class="card-body">
                        <h5 class="card-title">View Greetings</h5>
                        <p class="card-text">See all the greetings that have been created.</p>
                        <a href="${pageContext.request.contextPath}/greeting" class="btn btn-outline-primary">View All</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card feature-card">
                    <div class="card-body">
                        <h5 class="card-title">Manage Greetings</h5>
                        <p class="card-text">Delete unwanted greetings from the system.</p>
                        <a href="${pageContext.request.contextPath}/greeting" class="btn btn-outline-primary">Manage</a>
                    </div>
                </div>
            </div>
        </div>
        
        <footer class="mt-5 text-center text-muted">
            <p>Sample Web Application &copy; 2025</p>
        </footer>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>