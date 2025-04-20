<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Greeting</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .greeting-app {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        .greeting-details {
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .greeting-message {
            font-size: 1.5rem;
            color: #0d6efd;
            animation: fadeIn 1s ease-in;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(10px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>
    <div class="greeting-app">
        <h1 class="mb-4">Greeting Details</h1>
        
        <div class="mb-3">
            <a href="${pageContext.request.contextPath}/greeting" class="btn btn-secondary">Back to List</a>
        </div>
        
        <div class="greeting-details">
            <h2 class="greeting-message">${greeting.message}</h2>
            
            <div class="mt-4">
                <p><strong>Greeting ID:</strong> ${greeting.id}</p>
                <p><strong>Created:</strong> ${greeting.timestamp}</p>
            </div>
            
            <div class="mt-4">
                <a href="${pageContext.request.contextPath}/greeting?action=delete&id=${greeting.id}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this greeting?')">Delete</a>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>