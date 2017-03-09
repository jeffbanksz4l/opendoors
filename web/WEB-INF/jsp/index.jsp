<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sec:authorize access="hasRole('ROLE_USER')">
    <c:url value="/j_spring_security_logout" var="logoutUrl" />


    <%@ include file="header.jsp" %>

    <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-dashboard"></i> Dashboard</b></h5>
    </header>

    <div class="w3-row-padding w3-margin-bottom">
        <div class="w3-quarter">
            <div class="w3-container w3-padding-16" style="background-color: #4c90b1">
                <div class="w3-left"><i class="fa fa-info w3-xxxlarge w3-text-white"></i></div>
                <div class="w3-right"></div>
                <div class="w3-clear"></div>
                <h3>${crowcount} - Clients</h3>
                <h3>${irowcount} - Interactions</h3>
            </div>
        </div>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <c:url value="/j_spring_security_logout" var="logoutUrl" />
            <div class="w3-quarter">
                <div class="w3-container w3-orange w3-text-white w3-padding-16">
                    <div class="w3-left"><i class="fa fa-user-plus w3-xxxlarge"></i></div>
                    <div class="w3-right"></div>
                    <div class="w3-clear"></div>
                    <h3>Total Users</h3>
                    <h3>${urowcount}</h3>
                </div>
            </div>
        </sec:authorize>

        <div class="w3-quarter">
            <div class="w3-container w3-blue w3-padding-16">
                <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
                <div class="w3-right"></div>
                <div class="w3-clear"></div>
                <h3>Last 5 Clients</h3>
                <c:forEach var="cdisplay" items="${climit}">
                    <ul>
                        <li>${cdisplay.customer}</li>
                    </ul>
                </c:forEach>
            </div>
        </div>

        <div class="w3-quarter">
            <div class="w3-container w3-teal w3-padding-16">
                <div class="w3-left"><i class="fa fa-comments w3-xxxlarge"></i></div>
                <div class="w3-right"></div>
                <div class="w3-clear"></div>
                <h3>Last 5 Interactions</h3>
                <c:forEach var="idisplay" items="${ilimit}">
                    <ul>
                        <li>
                            <div class="w3-container">

                                <button onclick="document.getElementById('id01').style.display = 'block'" class="w3-button" style="background-color: #dbd6af">${idisplay.clients_ID}<br>Click to Display</button>

                                <div id="id01" class="w3-modal">
                                    <div class="w3-modal-content w3-card-8">
                                        <header class="w3-container w3-text-black" style="background-color: #b9cb9a"> 
                                            <span onclick="document.getElementById('id01').style.display = 'none'" 
                                                  class="w3-closebtn">&times;</span>
                                            <p>${idisplay.conversations}</p>
                                        </header>
                                        <footer class="w3-container w3-text-black" style="background-color: #dbd6af">
                                            <p>Click on the "x" or click anywhere to close this pop-up!</p>
                                        </footer>
                                    </div>
                                </div>

                            </div>
                            <script>
                                // Get the modal
                                var modal = document.getElementById('id01');

                                // When the user clicks anywhere outside of the modal, close it
                                window.onclick = function (event) {
                                    if (event.target == modal) {
                                        modal.style.display = "none";
                                    }
                                }
                            </script>
                        </li>
                    </ul>
                </c:forEach>
            </div>
        </div>
    </div>

    <div class="w3-row-padding w3-margin-bottom">

    </div>

    <%@ include file="footer.jsp" %>
</sec:authorize>

<sec:authorize access="isAnonymous()">
    <c:redirect url="/login"/>
</sec:authorize>