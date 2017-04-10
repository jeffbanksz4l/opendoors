<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <title>OpenDoors Manager</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/media/w3.css" />">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="<c:url value="/media/font-awesome-4.7.0/css/font-awesome.min.css" />">
    <link rel="stylesheet" href="<c:url value="/media/jquery.datetimepicker.min.css" />" />

    <style>
        html,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
        body, nav, footer {background-color: #b9cb9a}
    </style>
    <body class="" >

        <!-- Top container -->
        <div class="w3-container w3-top w3-large w3-padding w3-text-white" style="z-index:4; background-color: #60755b">
            <button class="w3-btn w3-hide-large w3-padding-0 w3-hover-text-grey" onclick="w3_open();"><i class="fa fa-bars"></i> Menu </button>
            <span class="w3-right">OpenDoors</span>
        </div>

        <!-- Sidenav/menu -->
        <nav class="w3-sidenav w3-collapse w3-animate-left" style="z-index:3;width:300px;background-color: #60755b" id="mySidenav"><br>
            <div class="w3-container w3-row">
                <div class="w3-col s4">
                    <img src="<c:url value="/media/img/OpenDoors_Logo_newest.jpg" />" class="w3-square w3-margin-right" style="width:100px">
                </div>
                <div class="w3-col s8">
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <span><a style="margin: 15px"><strong>Welcome, ${pageContext.request.userPrincipal.name}</strong></a></span><br>
                        </c:if>
                        <!--
                        <a href="#" class="w3-hover-none w3-hover-text-red w3-show-inline-block"><i class="fa fa-envelope"></i></a>
                        <a href="#" class="w3-hover-none w3-hover-text-green w3-show-inline-block"><i class="fa fa-user"></i></a>
                        <a href="#" class="w3-hover-none w3-hover-text-blue w3-show-inline-block"><i class="fa fa-cog"></i></a>
                        -->
                    </sec:authorize>
                </div>
            </div>
            <hr>

            <a href="#" class="w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i> Close Menu </a>
            <a href="<c:url value="/" />" class="w3-padding" style="background-color: #dbd6af"><i class="fa fa-dashboard fa-fw"></i>  Dashboard</a>

            <sec:authorize access="hasRole('ROLE_USER')">
                <a style="background-color: #5b7885" class="w3-text-white" onclick="myAccFunc(this)" href="#" ><i class="fa fa-users fa-fw"></i> Clients <i class="fa fa-caret-down"></i></a>
                <div class="w3-hide w3-white w3-card-4">
                    <a href="<c:url value="/clients/viewclients" />" class="w3-padding" style="background-color: #79a0b1"><i class="fa fa-binoculars fa-fw"></i> View Clients </a>
                    <a class="w3-padding" style="background-color: #98c8de" href="<c:url value="/clients/clientsform" />"><i class="fa fa-plus fa-fw"></i>  Add Client </a>
                </div>

                <a style="background-color: #5b7885" class="w3-text-white" onclick="myAccFunc(this)" href="#" ><i class="fa fa-users fa-fw"></i> Prospects <i class="fa fa-caret-down"></i></a>
                <div class="w3-hide w3-white w3-card-4">
                    <a href="<c:url value="/clients/viewprospects" />" class="w3-padding" style="background-color: #79a0b1"><i class="fa fa-binoculars fa-fw"></i> View Prospects </a>
                    <a class="w3-padding" style="background-color: #98c8de" href="<c:url value="/clients/clientsform" />"><i class="fa fa-plus fa-fw"></i>  Add Prospect </a>
                </div>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a style="background-color: #5b7885" class="w3-text-white" onclick="myAccFunc(this)" href="#" ><i class="fa fa-users fa-fw"></i> Inactives <i class="fa fa-caret-down"></i></a>
                    <div class="w3-hide w3-white w3-card-4">
                        <a href="<c:url value="/clients/viewinactives" />" class="w3-padding" style="background-color: #79a0b1"><i class="fa fa-binoculars fa-fw"></i> View Inactives </a>
                    </div>
                </sec:authorize>

                <a style="background-color: #5b7885" class="w3-text-white" onclick="myAccFunc(this)" href="#" ><i class="fa fa-comments fa-fw"></i> Interactions <i class="fa fa-caret-down"></i></a>
                <div class="w3-hide w3-white w3-card-4">
                    <a href="<c:url value="/interactions/viewinteractions" />" class="w3-padding" style="background-color: #79a0b1"><i class="fa fa-comments fa-fw"></i> View Interactions </a>
                    <a class="w3-padding" style="background-color: #98c8de" href="<c:url value="/interactions/interactionsform" />"><i class="fa fa-plus fa-fw"></i> Add Interaction </a>
                </div>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a style="background-color: #5b7885" class="w3-text-white" onclick="myAccFunc(this)" href="#" ><i class="fa fa-user-plus fa-fw"></i> Users <i class="fa fa-caret-down"></i></a>
                <div class="w3-hide w3-white w3-card-4">
                    <a href="<c:url value="/users/viewusers" />" class="w3-padding" style="background-color: #79a0b1"><i class="fa fa-user-plus fa-fw"></i> View Users </a>
                    <a class="w3-padding" style="background-color: #98c8de" href="<c:url value="/users/usersform" />"><i class="fa fa-plus fa-fw"></i> Add User </a>
                </div>


                <!--
                <a style="background-color: #5b7885" class="w3-text-white" onclick="myAccFunc(this)" href="#" ><i class="fa fa-user-plus fa-fw"></i> Client View <i class="fa fa-caret-down"></i></a>
                <div class="w3-hide w3-white w3-card-4">
                    <a href="<c:url value="/clients/viewdetails" />" class="w3-padding" style="background-color: #79a0b1"><i class="fa fa-user-plus fa-fw"></i> Client View </a>
                </div>
                -->


            </sec:authorize>

            <script>
                function myAccFunc(elem) {
                    var x = elem.nextElementSibling;
                    if (x.className.indexOf("w3-show") == -1) {
                        x.className += " w3-show";
                        x.previousElementSibling.className += " #98c8de";
                    } else {
                        x.className = x.className.replace(" w3-show", "");
                        x.previousElementSibling.className =
                                x.previousElementSibling.className.replace(" w3-green", "");
                    }
                }
            </script>

            <!--
            <a href="#" class="w3-padding"><i class="fa fa-eye fa-fw"></i>  Views</a>
            <a href="#" class="w3-padding"><i class="fa fa-users fa-fw"></i>  Traffic</a>
            <a href="#" class="w3-padding"><i class="fa fa-bullseye fa-fw"></i>  Geo</a>
            <a href="#" class="w3-padding"><i class="fa fa-diamond fa-fw"></i>  Orders</a>
            <a href="#" class="w3-padding"><i class="fa fa-bell fa-fw"></i>  News</a>
            <a href="#" class="w3-padding"><i class="fa fa-bank fa-fw"></i>  General</a>
            <a href="#" class="w3-padding"><i class="fa fa-history fa-fw"></i>  History</a>
            -->

            <a href="#" onclick="logoutFormSubmit();" class="w3-padding w3-text-white" style="background-color: #303a2d"><i class="fa fa-sign-out fa-fw"></i>  Logout</a><br><br>

            <form action="<c:url value="/j_spring_security_logout" />" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </nav>

        <!-- Overlay effect when opening sidenav on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">