<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/css/login-menu.css" rel="stylesheet">

<li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <span class="glyphicon glyphicon-user"></span>
        <strong><c:out value="${sessionScope.user.userName}" /></strong>
        <span class="glyphicon glyphicon-chevron-down"></span>
    </a>
    <ul class="dropdown-menu">
        <li>
            <div class="navbar-login">
                <div class="row">
                    <div class="col-lg-4">
                        <p class="text-center">
                            <span class="glyphicon glyphicon-user icon-size"></span>
                        </p>
                    </div>
                    <div class="col-lg-8">
                        <p class="text-left"><strong><c:out value="${sessionScope.user.firstName}" /> <c:out value="${sessionScope.user.lastName}" /></strong></p>
                        <c:if test="${sessionScope.user['class'].simpleName eq 'FacebookUser'}">
                            <p class="text-left small"><c:out value="${sessionScope.user.email}" /></p>
                        </c:if>
                        <p class="text-left">
                            <a href="${sessionScope.user['class'].simpleName eq 'FacebookUser' ? 'sessionScope.user.link': '#'}" class="btn btn-primary btn-block btn-sm">Profile</a>
                        </p>
                    </div>
                </div>
            </div>
        </li>
        <li class="divider navbar-login-session-bg"></li>
        <li><a href="#">Account Settings <span class="glyphicon glyphicon-cog pull-right"></span></a></li>
        <li class="divider"></li>
        <li><a href="#">User stats <span class="glyphicon glyphicon-stats pull-right"></span></a></li>
        <li class="divider"></li>
        <c:if test="${sessionScope.user['class'].simpleName eq 'ApplicationUser'}">
            <li><a href="/logout">Sign Out <span class="glyphicon glyphicon-log-out pull-right"></span></a></li>
        </c:if>
        <c:if test="${sessionScope.user['class'].simpleName eq 'FacebookUser'}">
            <li>
                <a href="#" onclick="document.forms['formFacebook'].submit(); return false;">
                    Disconnect<span class="glyphicon glyphicon-log-out pull-right"></span>
                </a>
            </li>
        </c:if>
    </ul>
</li>

<form id="formFacebook" action="/connect/facebook" method="post">
    <input type="hidden" name="_method" value="delete" />
</form>