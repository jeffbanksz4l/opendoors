<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Users > Edit Users</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Users Information</h2>
        </div>

        <form:form method="POST" action="/OpenDoors/users/editsave" cssClass="w3-container" commandName="users">
            <form:hidden path="userName"  />
            <div class="w3-padding-8">
                <form:input path="Username" cssClass="w3-input w3-border" placeholder="Username"  />
                <form:errors path="Username" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                <form:password path="Password" cssClass="w3-input w3-border" placeholder="Password"  />
                <form:errors path="Password" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                <form:checkbox path="Enabled" cssClass="w3-check"  />
                <label>Enabled</label>
                <form:select path="Roles" cssClass="w3-input w3-border" cssStyle="height:55px;" >                    
                    <form:options items="${users.rolesMap}" />
                </form:select>
                Ctrl + click to select multiple items.
            </div>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>
    </div>
</div>

<%@ include file="footer.jsp" %>