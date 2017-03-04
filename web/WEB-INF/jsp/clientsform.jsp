<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Clients/Prospects > Add Client/Prospect</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-text-white" style="background-color: #60755b">
            <h2>Clients/Prospects Information</h2>
        </div>

        <form:form method="post" action="save" cssClass="w3-container" commandName="clients">
            <div class="w3-padding-8">
                <form:input path="Customer" cssClass="w3-input w3-border" placeholder="Customer"  />
                <form:errors path="Customer" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                <form:input path="Address_Line_1" cssClass="w3-input w3-border" placeholder="Address Line 1"  />
                <form:errors path="Address_Line_1" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                <form:input path="Address_Line_2" cssClass="w3-input w3-border" placeholder="Address Line 2"  />
                <form:errors path="Address_Line_2" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                <form:input path="City" cssClass="w3-input w3-border" placeholder="City"  />
                <form:errors path="City" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                <form:select path="State" cssClass="w3-input w3-border" cssStyle="w3-select w3-border" placeholder="State" >                    
                    <form:options items="${clients.statesMap}" />
                </form:select>
                <form:errors path="State" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                <form:input path="Postal_Code" cssClass="w3-input w3-border" placeholder="Postal Code"  />
                <form:errors path="Postal_Code" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                <form:input path="Email" cssClass="w3-input w3-border" placeholder="Email"  />
                <form:errors path="Email" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                <form:input path="Phone_1" cssClass="w3-input w3-border" placeholder="Phone 1"  />
                <form:errors path="Phone_1" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                <form:input path="Phone_2" cssClass="w3-input w3-border" placeholder="Phone 2"  />
                <form:errors path="Phone_2" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                <form:select path="Status" cssClass="w3-input w3-border" cssStyle="w3-select w3-border" placeholder="Status" >                    
                    <form:options items="${clients.statusMap}" />
                </form:select>
                <form:errors path="Status" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                </div>
                <div class="w3-padding-8">
                    <button type="submit" class="w3-btn w3-padding" style="width:120px; background-color: #60755b">Save</button>
                </div>
        </form:form>
    </div>

</div>

<%@ include file="footer.jsp" %>