<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
    		<form role="form" action="/user" method="POST">
    			<div class="text-center">
    			    <h2>Please Sign Up</h2>
    			</div>
    			<hr class="colorgraph">
    			<c:set var="nameHasBindError"><form:errors path="user.userName"/></c:set>
                <div class="form-group ${not empty nameHasBindError ? 'has-error' : ''}">
                    <input class="form-control input-lg" type="text" autocomplete="off" name="userName" value="${user.userName}" placeholder="Display Name" tabindex="3">
                    <c:if test="${not empty nameHasBindError}"><label class="control-label">${nameHasBindError}</label></c:if>
                </div>
                <c:set var="emailHasBindError"><form:errors path="user.email"/></c:set>
                <div class="form-group ${not empty emailHasBindError ? 'has-error' : ''}">
    		        <input class="form-control input-lg" type="email" autocomplete="off" name="email" value="${user.email}" placeholder="Email Address" tabindex="4">
                    <c:if test="${not empty emailHasBindError}"><label class="control-label">${emailHasBindError}</label></c:if>
                </div>
    			<div class="row">
    		        <div class="col-xs-12 col-sm-6">
                        <c:set var="passwordHasBindError"><form:errors path="user.password"/></c:set>
                        <div class="form-group ${not empty passwordHasBindError ? 'has-error' : ''}">
    		                <input type="password" name="password" class="form-control input-lg" placeholder="Password" tabindex="5">
    		                <c:if test="${not empty passwordHasBindError}"><label class="control-label">${passwordHasBindError}</label></c:if>
                        </div>
    		        </div>
    		        <div class="col-xs-12 col-sm-6">
                        <c:set var="confirmationPasswordHasBindError"><form:errors path="user.passwordConfirmation"/></c:set>
                        <div class="form-group ${not empty confirmationPasswordHasBindError ? 'has-error' : ''}">
    		                <input type="password" name="passwordConfirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="6">
    		                <c:if test="${not empty confirmationPasswordHasBindError}"><label class="control-label">${confirmationPasswordHasBindError}</label></c:if>
                        </div>
    		        </div>
    			</div>
    			<hr class="colorgraph">
    			<div class="row">
    				<div class="col-xs-12"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="12"></div>
    			</div>
    			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		</form>
    	</div>
    </div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>
