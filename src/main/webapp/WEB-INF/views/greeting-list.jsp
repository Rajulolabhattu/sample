<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Greeting List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .greeting-app {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        .greeting-card {
            transition: transform 0.2s ease;
            margin-bottom: 1rem;
        }
        .greeting-card:hover {
            transform: scale(1.02);
        }
        .btn-action {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <div class="greeting-app">
        <h1 class="mb-4">Greeting List</h1>
        
        <div class="mb-3">
            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Home</a>
            <a href="${pageContext.request.contextPath}/greeting?action=create" class="btn btn-primary">Create New Greeting</a>
        </div>
        
        <c:choose>
            <c:when test="${empty greetings}">
                <div class="alert alert-info">
                    <p>No greetings found. Create one?</p>
                </div>
            </c:when>
            <c:otherwise>
                <div class="row">
                    <c:forEach var="greeting" items="${greetings}">
                        <div class="col-md-6">
                            <div class="card greeting-card">
                                <div class="card-body">
                                    <h5 class="card-title">Greeting #${greeting.id}</h5>
                                    <p class="card-text">${greeting.message}</p>
                                    <p class="card-text text-muted">Created: ${greeting.timestamp}</p>
                                    <div class="mt-2">
                                        <a href="${pageContext.request.contextPath}/greeting?action=view&id=${greeting.id}" class="btn btn-sm btn-info btn-action">View</a>
                                        <a href="${pageContext.request.contextPath}/greeting?action=delete&id=${greeting.id}" class="btn btn-sm btn-danger btn-action" onclick="return confirm('Are you sure you want to delete this greeting?')">Delete</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>