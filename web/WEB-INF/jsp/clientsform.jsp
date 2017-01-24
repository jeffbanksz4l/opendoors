<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Clients/Prospects > Add Clients/Prospects</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Header</h2>
        </div>

        <form:form method="post" action="save" cssClass="w3-container">
            <div class="w3-padding-8">
                <label><b>Name</b></label>
                <form:input path="First_Name" cssClass="w3-input w3-border"  />
                <form:input path="Last_Name" cssClass="w3-input w3-border"  />
                <form:input path="Address_Line_1" cssClass="w3-input w3-border"  />
                <form:input path="Address_Line_2" cssClass="w3-input w3-border"  />
                <form:input path="Address_Line_3" cssClass="w3-input w3-border"  />
                <form:input path="City" cssClass="w3-input w3-border"  />
                <form:input path="State" cssClass="w3-input w3-border"  />
                <form:input path="Postal_Code" cssClass="w3-input w3-border"  />
                <form:input path="Email" cssClass="w3-input w3-border"  />
                <form:input path="Phone_1" cssClass="w3-input w3-border"  />
                <form:input path="Phone_2" cssClass="w3-input w3-border"  />
                <form:input path="Status" cssClass="w3-input w3-border"  />
            </div>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>
    </div>

</div>

<%@ include file="footer.jsp" %>