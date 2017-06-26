<form class="form center-block" role="form" method="post" action="/contact">
    <div class="row">
        <div class="col-xs-12 col-sm-6 form-group">
            <input type="text" class="form-control" name="lastName" placeholder="Last Name" required>
        </div>
        <div class="col-xs-12 col-sm-6 form-group">
            <input type="text" class="form-control" name="firstName" placeholder="First Name" required>
        </div>
    </div>
    <div class="row">
		<div class="col-xs-12 col-sm-6 form-group">
			<input type="email" class="form-control" name="email" placeholder="Email" required>
		</div>
		<div class="col-xs-12 col-sm-6 form-group">
		    <input type="text" class="form-control" name="phone" placeholder="Phone Number" required>
		</div>
    </div>
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
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>