<%-- 
    Document   : viewclients
    Created on : Jan 11, 2017, 7:29:59 PM
    Author     : jeffb
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Clients/Prospects</title>
        <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
    </head>
    <body>

        <h1>Manage Clients/Prospects</h1>
        <a href="clientsform">Add New Client/Prospect</a><br/><br/>
        <table border="1" width="70%" cellpadding="2">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Action</th>
            </tr>

            <c:forEach var="clients" items="${list}">
                <tr>
                    <td>${clients.id}</td>
                    <td>${clients.name}</td>
                    <td><a href="editclients/${clients.id}">Edit</a> <a href="deleteclients/${clients.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
    </body>
</html>
