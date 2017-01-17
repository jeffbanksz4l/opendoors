<%-- 
    Document   : 403
    Created on : Jan 16, 2017, 12:50:42 PM
    Author     : jeffb
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>403 Page</title>
    </head>
    <body>
        <h1>HTTP Status 403 - Access is denied</h1>

        <c:choose>
            <c:when test="${empty username}">
                <h2>You do not have permission to access this page!</h2>
            </c:when>
            <c:otherwise>
                <h2>Username: ${username} <br/>You do not have permission to access this page!</h2>
                </c:otherwise>
            </c:choose>
    </body>
</html>
