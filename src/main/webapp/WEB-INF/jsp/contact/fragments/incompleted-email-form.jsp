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
            <button type="submit" class="btn btn-primary btn-block">Send</button>
        </div>
    </div>
    <input type="hidden" name="lastName" value="${sessionScope.user.lastName}">
    <input type="hidden" name="firstName" value="${sessionScope.user.firstName}">
    <input type="hidden" name="email" value="${sessionScope.user.email}">
    <input type="hidden" name="phone" value="${sessionScope.user.mobile}">
</form>