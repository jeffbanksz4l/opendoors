<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Users </b></h5>
</header>

<div class="w3-row-padding w3-margin-bottom">

    <c:if test="${not empty message}">
        <c:choose>
            <c:when test="${message.type eq 'INFO'}">
                <div class="w3-panel w3-border w3-pale-yellow w3-border-yellow"><p>${message.message}</p></div>
                    </c:when>
                    <c:when test="${message.type eq 'ERROR'}">
                <div class="w3-panel w3-border w3-pale-red w3-border-red"><p>${message.message}</p></div>
                    </c:when>
                </c:choose>

    </c:if>

    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">  
        <tr>
            <th>Username<!--<i class="fa fa-sort"></i>--></th>
            <th>Enabled</th>
        </tr>  

        <c:forEach var="users" items="${list}">   
            <tr>  
                <td>${fn:toUpperCase(fn:substring(users.username, 0, 1))}${fn:toLowerCase(fn:substring(users.username, 1, -1))}</td>

                <td>
                    <c:choose>
                        <c:when test="${users.enabled}">
                            Yes
                        </c:when>
                        <c:otherwise>
                            No
                        </c:otherwise>
                    </c:choose>

                </td>
                <td>
                    <a href="<c:url value="/users/editusers/${users.username}" />"><button class="w3-btn w3-round" style="background-color: #60755b">Edit</button></a>
                </td>  
            </tr>  
        </c:forEach>  
    </table> 

    <div class="w3-padding-8">
        <ul class="w3-pagination">
            <c:forEach begin="1" end="${pages}" varStatus="p">  
                <li><a class="<c:if test="${p.index eq page}">w3-gray</c:if>" href="<c:url value="/users/viewusers/${p.index}" />">${p.index}</a></li>
                </c:forEach>
        </ul>
    </div>
</div>

<%@ include file="footer.jsp" %>