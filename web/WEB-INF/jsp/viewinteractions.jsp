<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Interactions </b></h5>
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
            <th>Interactions ID</th>
            <th>Customer</th>
            <th>Date Of Contact</th>
            <th>Contact Name</th>
            <th>Contact Type</th>
            <th>Conversations</th>
        </tr>  

        <c:forEach var="interactions" items="${list}">   
            <tr>  
                <td>${interactions.interactionsID}</td>
                <td>${interactions.clients.customer}</td>
                <td>${interactions.date_Of_Contact}</td>
                <td>${interactions.contact_First_Name} ${interactions.contact_Last_Name}</td>
                <td>${interactions.contact_Type}</td>
                <td>${interactions.conversations}</td>
                <td>
                    <a href="<c:url value="/interactions/editinteractions/${interactions.interactionsID}" />"><button class="w3-btn w3-round" style="background-color: #60755b">Edit</button></a>
                    <a href="<c:url value="/interactions/deleteinteractions/${interactions.interactionsID}" />"><button class="w3-btn w3-round w3-text-black" style="background-color: #dbd6af" onclick="return confirm('Are you sure you want to delete this Interaction?');">Delete</button></a>
                </td>  
            </tr>  
        </c:forEach>  
    </table> 

    <div class="w3-padding-8">
        <ul class="w3-pagination">
            <c:forEach begin="1" end="${pages}" varStatus="p">  
                <li><a class="<c:if test="${p.index eq page}">w3-gray</c:if>" href="<c:url value="/interactions/viewinteractions/${p.index}" />">${p.index}</a></li>
                </c:forEach>
        </ul>
    </div>

</div>

<%@ include file="footer.jsp" %>