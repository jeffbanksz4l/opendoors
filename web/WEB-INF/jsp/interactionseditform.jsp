<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Interactions > Edit Interaction</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-text-white" style="background-color: #60755b">
            <h2>Interactions</h2>
        </div>

        <form:form method="POST" action="/OpenDoors/interactions/editsave" cssClass="w3-container" commandName="interactions">
            <form:hidden path="Clients_ID" />

           
<!--
        <div class="w3-padding-8">
            <label><b>Interactions</b></label>
            <form:select path="interactionsID" cssClass="w3-select w3-border" items="${command.interactions}" />
        </div>

        <div class="w3-padding-8">
            <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
        </div>
            -->

            <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
            <link rel="stylesheet" href="/resources/demos/style.css">
            <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
            <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            <script>
                $(function () {
                    $("#Date_Of_Contact").datepicker();
                });
            </script>

            <form:input path="Date_Of_Contact" cssClass="w3-input w3-border" placeholder="Date Of Contact"  />
            <form:errors path="Date_Of_Contact" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>

            <form:input path="Contact_First_Name" cssClass="w3-input w3-border" placeholder="Contact First Name"  />
            <form:errors path="Contact_First_Name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>

            <form:input path="Contact_Last_Name" cssClass="w3-input w3-border" placeholder="Contact Last Name"  />
            <form:errors path="Contact_Last_Name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>

            <form:select path="Contact_Type" cssClass="w3-input w3-border" >
                <form:options items="${interactions.contact_TypeMap}" />
            </form:select>

            <form:textarea rows="10" path="Conversations" cssClass="w3-input w3-border" placeholder="Conversations"  />
            <form:errors path="Conversations" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>

                <div class="w3-padding-8">
                    <button type="submit" class="w3-btn w3-padding w3-text-white" style="width:120px; background-color: #60755b">Save</button>
                </div>

        </form:form>
    </div>
</div>

<%@include file="footer.jsp" %>