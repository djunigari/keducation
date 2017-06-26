<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="/header.jsp"></jsp:include>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<div class="form-gap"></div>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h3><i class="fa fa-lock fa-4x"></i></h3>
                        <h2 class="text-center">Reset Password?</h2>
                        <div class="panel-body">
                            <form role="form" method="post" action="/user/reset-password" >
                                <div class="row">
                                    <div class="col-xs-12">
                                        <c:set var="passwordHasBindError"><form:errors path="resetPassword.password"/></c:set>
                                        <div class="form-group ${not empty passwordHasBindError ? 'has-error' : ''}">
                                            <input type="password" name="password" class="form-control input-lg" placeholder="New Password" tabindex="1">
                                            <c:if test="${not empty passwordHasBindError}"><label class="control-label">${passwordHasBindError}</label></c:if>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <c:set var="confirmationPasswordHasBindError"><form:errors path="resetPassword.passwordConfirmation"/></c:set>
                                        <div class="form-group ${not empty confirmationPasswordHasBindError ? 'has-error' : ''}">
                                            <input type="password" name="passwordConfirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="2">
                                            <c:if test="${not empty confirmationPasswordHasBindError}"><label class="control-label">${confirmationPasswordHasBindError}</label></c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input name="recover-submit" class="btn btn-lg btn-success btn-block" value="Reset Password" type="submit">
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
          </div>
	</div>
</div>
<jsp:include page="/footer.jsp"></jsp:include>