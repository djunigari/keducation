<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link href="/css/login-menu.css" rel="stylesheet">

<sec:authentication var="customUser" property="principal" />
<li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <span class="glyphicon glyphicon-user"></span>
        <strong><c:out value="${customUser.user.userName}" /></strong>
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
                        <p class="text-left"><strong><c:out value="${customUser.user.firstName}" /> <c:out value="${customUser.user.lastName}" /></strong></p>
                        <c:if test="${customUser.user['class'].simpleName ne 'FacebookUser'}">
                            <p class="text-left small"><c:out value="${customUser.user.email}" /></p>
                        </c:if>
                        <p class="text-left">
                            <a href="${customUser.user['class'].simpleName eq 'FacebookUser' ? customUser.user.link: '#'}" class="btn btn-primary btn-block btn-sm">Profile</a>
                        </p>
                    </div>
                </div>
            </div>
        </li>
        <li class="divider navbar-login-session-bg"></li>
        <c:set var="accountSettingsUrl" value="'#'" />
        <c:if test="${customUser.user['class'].simpleName eq 'ApplicationUser'}">
            <c:set var="accountSettingsUrl" value="/private/user/${customUser.user.userId}" />
        </c:if>

        <li><a href="${accountSettingsUrl}">Account Settings <span class="glyphicon glyphicon-cog pull-right"></span></a></li>
        <li class="divider"></li>
        <li><a href="#">User stats <span class="glyphicon glyphicon-stats pull-right"></span></a></li>
        <li class="divider"></li>
        <c:if test="${customUser.user['class'].simpleName eq 'ApplicationUser'}">
            <li><a href="#" onclick="document.forms['formAppUserLogout'].submit(); return false;">Sign Out <span class="glyphicon glyphicon-log-out pull-right"></span></a></li>
        </c:if>
        <c:if test="${customUser.user['class'].simpleName eq 'FacebookUser'}">
            <li>
                <a href="#" onclick="document.forms['formFacebook'].submit(); return false;">
                    Disconnect<span class="glyphicon glyphicon-log-out pull-right"></span>
                </a>
            </li>
        </c:if>
    </ul>
</li>

<form id="formAppUserLogout" action="/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<form id="formFacebook" action="/connect/facebook" method="post">
    <input type="hidden" name="_method" value="delete" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>