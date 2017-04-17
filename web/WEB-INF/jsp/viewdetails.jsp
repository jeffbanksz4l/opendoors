<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-binoculars"></i> View Client/Prospect Details </b></h5>
</header>

<div class="w3-row-padding w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-text-white" style="background-color: #60755b">
            <h2>Client/Prospect Details</h2>
        </div>
        
        <form:form method="POST" action="/OpenDoors/clients/clientview" cssClass="w3-container" commandName="id">
            <form:hidden path="clientsID"  />

            <div class="w3-row-padding w3-margin-bottom">
                <div class="w3-third w3-center w3-cyan">
                    <p>Customer</p>    
                </div>
                <div class="w3-twothird w3-center w3-sand">
                    <p>${clients.customer} - Data 1</p>
                </div>
            </div>
            <div class="w3-row-padding w3-margin-bottom">
                <div class="w3-third w3-center w3-teal">
                    <p>Address Line 1</p>    
                </div>
                <div class="w3-twothird w3-center w3-khaki">
                    <p>${clients.address_Line_1} - Data 2</p>
                </div>
            </div>
        </form:form>
        
        <div class="w3-padding-8" style="background-color: #dbd6af">
            <ul>
                <li>Customer: ${clients.customer}</li>

            </ul>
        </div>

    </div>
</div>

<%@ include file="footer.jsp" %>