<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OpenDoors Manager</title>
        <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
    </head>
    <body>
    <sec:authorize access="hasRole('ROLE_USER')">
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <form action="$(logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
            </script>
        
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <b>Welcome ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()">Logout</a></b>
            </c:if>
                
                <h2>Tools:</h2>
                <ul><li><a href="/opendoors/clients/viewclients">Manage Clients/Prospects</a> </li></ul>
    </sec:authorize>
        
        <sec:authorize access="isAnonymous()">
            <a href="<c:url value="/login" />">Login</a>
        </sec:authorize>
    </body>
</html>
