<link href="/css/signin.css" rel="stylesheet">

<div class="row div-signin">
    <div class="col-md-12 center-block">

        <div class="social-buttons text-center">
            <h3>Login or <a href="/register/user">Sign up</a></h3>
            <br />
            <form action="/connect/facebook" method="POST">
            	<input type="hidden" name="scope" value="user_posts" />
                <button class="btn btn-fb" type="submit">Connect to Facebook</button>
            </form>
        </div>
		<hr class="colorgraph">
        <form class="form center-block" role="form" method="post" action="/login" accept-charset="UTF-8" id="login-nav">
            <div class="form-group">
                <label class="sr-only" for="exampleInputEmail2">Email address</label>
                <input type="email" autocomplete="off" name="email" class="form-control" placeholder="Email address" required>
            </div>
            <div class="form-group">
                <label class="sr-only" for="exampleInputPassword2">Password</label>
                <input type="password" name="password" class="form-control" placeholder="Password" required>
                <div class="help-block text-right"><a href="/forgotten-password">Forget the password ?</a></div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Sign in</button>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" name="keepLogged"> keep me logged-in
                </label>
            </div>
        </form>
    </div>
</div>