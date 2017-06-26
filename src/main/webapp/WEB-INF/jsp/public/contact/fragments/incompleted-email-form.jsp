<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="customUser" property="principal" />
<form class="form center-block" role="form" method="post" action="/contact">
	<div class="form-group">
        <input type="text" class="form-control" name="subject" placeholder="Subject" required>
    </div>
    <div class="form-group">
        <textarea class="form-control" type="textarea" name="message" placeholder="Message" maxlength="254" rows="7" required></textarea>
    </div>
    <div class="row">
        <div class="col-xs-0 col-sm-6">
        </div>
        <div class="col-xs-12 col-sm-6 form-group">
            <button type="submit" class="btn btn-success btn-block">Send</button>
        </div>
    </div>
    <input type="hidden" name="lastName" value="${customUser.user.lastName}">
    <input type="hidden" name="firstName" value="${customUser.user.firstName}">
    <input type="hidden" name="email" value="${customUser.user.email}">
    <input type="hidden" name="phone" value="${customUser.user.mobile}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>