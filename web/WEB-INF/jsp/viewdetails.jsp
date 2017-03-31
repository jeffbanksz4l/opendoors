<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-binoculars"></i> View Client/Prospect Details </b></h5>
</header>

<div class="w3-row-padding w3-margin-bottom">


    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">  
        <tr>
            <th>Customer</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="clients" items="${list}">
            <tr>
                <td>${clients.customer}</td>
                <td>${clients.status}</td>
                <td>
                    <a href="<c:url value="/clients/editclients/${clients.clientsID}" />"><button class="w3-btn w3-round" style="background-color: #60755b">Edit</button></a>
                    <a href="<c:url value="/clients/clientdisplay/${clients.clientsID}" />"><button class="w3-btn w3-round" style="background-color: #60755b">Display</button></a>
                    <a href="<c:url value="/clients/convert/${clients.clientsID}" />"><button class="w3-btn w3-round w3-text-black" style="background-color: #dbd6af">Change to Inactive</button></a>
                    <a href="<c:url value="/interactions/interactionsform/${clients.clientsID}" />"><button class="w3-btn w3-round" style="background-color: #5b7885">Add Interaction</button></a>
                </td>  
            </tr>  
        </c:forEach>
    </table>

    <!-- Future
    <div class="w3-container w3-text-white" style="background-color: #60755b">
        <h2>Client/Prospect Information</h2>
    </div>

    <input type="hidden" id="clientsID" name="clientsID">

    <form:form method="POST" action="/OpenDoors/clients/clientview" cssClass="w3-container" commandName="clients">
        <form:hidden path="clientsID"  />

        <div class="w3-row-padding w3-margin-bottom">
            <div class="w3-third w3-center w3-cyan">
                <p>Customer</p>    
            </div>
            <div class="w3-twothird w3-center w3-sand">
                <p>${clients.customer}</p>
            </div>
        </div>
        <div class="w3-row-padding w3-margin-bottom">
            <div class="w3-third w3-center w3-teal">
                <p>Address Line 1</p>    
            </div>
            <div class="w3-twothird w3-center w3-khaki">
                <p>${clients.address_Line_1}</p>
            </div>
        </div>

    </form:form>

    <div class="w3-padding-8" style="background-color: #dbd6af">
        <ul>
            <li>Customer: ${clients.customer}</li>

        </ul>
    </div>

    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
    <c:set target="clientID">
        <tr>
            <th>Customer</th>
            <th>Address Line 1</th>
            <th>Address Line 2</th>
            <th>City</th>
            <th>State</th>
            <th>Postal Code</th>
            <th>Email</th>
            <th>Phone 1</th>
            <th>Phone 2</th>
            <th>Status</th>
            <th>Action</th>
        </tr>  
    </c:set>

    <c:forEach var="clients" items="${list}">
        <tr>
            <td>${clients.customer}</td>
            <td>${clients.status}</td>
            <td>
                <a href="<c:url value="/clients/editclients/${clients.clientsID}" />"><button class="w3-btn w3-round" style="background-color: #60755b">Edit</button></a>
                <a href="<c:url value="/clients/deleteclients/${clients.clientsID}" />"><button class="w3-btn w3-round w3-text-black" style="background-color: #dbd6af" onclick="return confirm('Are you sure you want to delete this Client/Prospect?');" >Change to Inactive</button></a>
                <a href="<c:url value="/interactions/interactionsform/${clients.clientsID}" />"><button class="w3-btn w3-round" style="background-color: #5b7885">Add Interaction</button></a>
            </td>  
        </tr>
    </c:forEach>
</table>
    -->

</div>

<%@ include file="footer.jsp" %>