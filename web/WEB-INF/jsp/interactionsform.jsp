<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Interactions > Add Interaction</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Interaction Information</h2>
        </div>

        <form:form method="post" action="/OpenDoors/interactions/save" cssClass="w3-container" commandName="interactions">
            <div class="w3-padding-8">

                <c:choose>
                    <c:when test="${not empty interactions.clients}">
                        <form:hidden path="Clients_ID" />
                        <div class="w3-padding-8">
                            <div class="w3-panel w3-border w3-white">
                                <p>${interactions.clients}</p>
                                <p>${clients.First_Name}</p>
                            </div>
                        </div>
                    </c:when>

                    <c:otherwise>
                        <div class="w3-padding-8">
                            <label><b>Interaction</b></label>
                            <form:select path="Clients_ID" cssClass="w3-select w3-border">
                                <form:option value="-1">Select Client</form:option>
                                <form:options items="${interactions.clientInteractMap}"  />
                            </form:select>
                        </div>
                    </c:otherwise>
                </c:choose>

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

                <!-- 
                                <div class="w3-container">
                                    <h2>Conversations</h2>
                                    <button onclick="document.getElementById('id01').style.display = 'block'" class="w3-btn">Conversation</button>
                
                                    <div id="id01" class="w3-modal">
                                        <div class="w3-modal-content">
                                            <div class="w3-container">
                                                <span onclick="document.getElementById('id01').style.display = 'none'" class="w3-closebtn">&times;</span>
                                                <p>Some text. Some text. Some text.</p>
                                                <p>Some text. Some text. Some text.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                -->
                <form:errors path="Conversations" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;"></form:errors>
                </div>

                <!-- 
            <c:choose>
                <c:when test="${not empty command.interactions}">
                    <form:hidden path="InteractionsID" />
                    <div class="w3-padding-8">
                        <label><b>Interactions456</b></label>
                        <div class="w3-panel w3-border">
                            <p><b>${command.interactions.first_name}</b></p>
                        </div>
                    </div>
                </c:when>

                <c:otherwise>
                    <div class="w3-padding-8">
                    <form:select path="Contact_Type" cssClass="w3-select w3-border">
                        <form:option value="-1">Select Contact Type</form:option>
                        <form:options items="${command.contact_Type}" />
                    </form:select>
                </div>
                </c:otherwise>
            </c:choose>
            -->

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>
    </div>
</div>

<%@include file="footer.jsp" %>