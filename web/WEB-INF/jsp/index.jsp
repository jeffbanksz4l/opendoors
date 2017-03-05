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
                <div class="w3-right">
                    <h3>52 - Clients</h3>
                    <h3>52 - Interactions</h3>
                </div>

            </div>
        </div>
        
        <div class="w3-quarter">
            <div class="w3-container w3-orange w3-text-white w3-padding-16">
                <div class="w3-left"><i class="fa fa-user-plus w3-xxxlarge"></i></div>
                <div class="w3-right">
                    <h3>50</h3>
                </div>
                <div class="w3-clear"></div>
                <h4>Total Number Of Users</h4>
            </div>
        </div>
        
        <div class="w3-quarter">
            <div class="w3-container w3-blue w3-padding-16">
                <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
                <div class="w3-right">
                    <h3>99</h3>
                </div>
                <div class="w3-clear"></div>
                <h4>Last 5 Clients</h4>
            </div>
        </div>

        <div class="w3-quarter">
            <div class="w3-container w3-teal w3-padding-16">
                <div class="w3-left"><i class="fa fa-comments w3-xxxlarge"></i></div>
                <div class="w3-right">
                    <h3>23</h3>
                </div>
                <div class="w3-clear"></div>
                <h4>Last 5 Interactions</h4>
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