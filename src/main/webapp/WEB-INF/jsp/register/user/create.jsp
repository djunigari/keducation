<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
    		<form role="form" action="/register/user" method="POST">
    			<div class="text-center">
    			    <h2>Please Sign Up</h2>
    			</div>
    			<hr class="colorgraph">

    			<div class="row">
                    <div class="col-xs-12 col-sm-6">
                        <c:set var="firstNameHasBindError"><form:errors path="user.firstName"/></c:set>
                        <div class="form-group ${not empty firstNameHasBindError ? 'has-error' : ''}">
                            <input type="text" autocomplete="off" name="firstName" class="form-control input-lg" value="${user.firstName}" placeholder="First Name" tabindex="1">
                            <c:if test="${not empty firstNameHasBindError}"><label class="control-label">${firstNameHasBindError}</label></c:if>
                        </div>
                    </div>

                    <div class="col-xs-12 col-sm-6">
                        <c:set var="lastNameHasBindError"><form:errors path="user.firstName"/></c:set>
                        <div class="form-group ${not empty lastNameHasBindError ? 'has-error' : ''}">
                            <input type="text" autocomplete="off" name="lastName" class="form-control input-lg" value="${user.lastName}" placeholder="Last Name" tabindex="2">
                            <c:if test="${not empty lastNameHasBindError}"><label class="control-label">${lastNameHasBindError}</label></c:if>
                        </div>
                    </div>
    			</div>
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

                <div class="row">
                    <div class="col-xs-4">
                        <div class="form-group">
                            <h4>Date of Birth</h4>
                        </div>
                    </div>
                    <div class="col-xs-8">
                        <fmt:formatDate type="date" value="${user.birthday.time}" var="birthday" pattern="yyyy-MM-dd" />
                        <c:set var="birthdayHasBindError"><form:errors path="user.birthday"/></c:set>
                        <div class="form-group ${not empty birthdayHasBindError ? 'has-error' : ''}">
                            <input type="date" autocomplete="off" name="birthday" class="form-control input-lg" value="${birthday}" placeholder="Birthday" tabindex="7">
                            <c:if test="${not empty birthdayHasBindError}"><label class="control-label">${birthdayHasBindError}</label></c:if>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-4">
                        <div class="form-group">
                            <h4>Gender</h4>
                        </div>
                    </div>
                    <div class="col-xs-8 btn-group">
                        <div class="form-group" style="margin-top:10px">
                            <label class="radio-inline"> <input type="radio" name="gender" value="female" ${empty user || user.gender == 'female' ? 'checked' : '' } >Female </label>
                            <label class="radio-inline"> <input type="radio" name="gender" value="male" ${user.gender == 'male' ? 'checked' : '' } >Male </label>
                            <label class="radio-inline"> <input type="radio" name="gender" value="other" ${user.gender == 'other' ? 'checked' : '' }>Other </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" name="phone" autocomplete="off" class="form-control input-lg" value="${user.phone}" placeholder="Phone Number" tabindex="8">
                </div>
                <c:set var="mobileHasBindError"><form:errors path="user.mobile"/></c:set>
                <div class="form-group ${not empty mobileHasBindError ? 'has-error' : ''}">
                    <input type="text" name="mobile" autocomplete="off" class="form-control input-lg" value="${user.mobile}" placeholder="Mobile Number" tabindex="9">
                    <c:if test="${not empty mobileHasBindError}"><label class="control-label">${mobileHasBindError}</label></c:if>
                </div>
                <div class="form-group">
                    <input type="text" name="address" autocomplete="off" class="form-control input-lg" value="${user.address}" placeholder="Address" tabindex="10">
                </div>
                <div class="form-group">
                    <input type="text" name="country" autocomplete="off" class="form-control input-lg" value="${user.country}" placeholder="Country" tabindex="11">
                </div>
    			<hr class="colorgraph">
    			<div class="row">
    				<div class="col-xs-12 col-sm-6"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="12"></div>
    				<div class="col-xs-12 col-sm-6"><a href="/login" class="btn btn-success btn-block btn-lg">Sign in</a></div>
    			</div>
    		</form>
    	</div>
    </div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>
