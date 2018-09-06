<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
    <div>
        <div>
            <h1>Spring Boot JSP Example</h1>
            <h2>Hello ${message}</h2>
             
            Click on this <strong><a href="next">link</a></strong> to visit another page.
        </div>
    </div>
    
    <div>
        <div>
            <h1>Another page</h1>
            <h2>Hello ${message}</h2>
             
            Click on this <strong><a href="/">link</a></strong> to visit previous page.
        </div>
    </div>
</body>
</html>