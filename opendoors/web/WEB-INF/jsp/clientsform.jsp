<%-- 
    Document   : clientsform
    Created on : Jan 11, 2017, 7:13:07 PM
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
        <h1>Add New Clients/Prospects</h1>
        <form:form method="post" action="save">
            <table>
                <tr>
                    <td>Name: </td>
                    <td><form:input path="name"  /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>