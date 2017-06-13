<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>My International Education</title>
        <link rel="shortcut icon" href="/images/logos/icon-logo.png" />

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <link href="/css/frontpage.css" rel="stylesheet">

        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    </head>
<body>
    <nav class="navbar navbar-default navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="menu">
                <ul class="nav navbar-nav">
                    <li><a href="/school">Schools</a></li>
                    <li><a href="/agentLists">Agents</a></li>
                    <li><a href="/contact">Contact Us</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${empty sessionScope.user.userName}">
                        <li><p class="navbar-text">Already have an account?</p></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
                            <ul id="login-dp" class="dropdown-menu">
                                <li>
                                    <jsp:include page="/WEB-INF/jsp/login/fragments/login-fragment.jsp"></jsp:include>
                                </li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${not empty sessionScope.user.userName}">
                        <jsp:include page="/WEB-INF/jsp/login/fragments/login-menu-fragment.jsp"></jsp:include>
                    </c:if>
                 </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1" class=""></li>
            <li data-target="#myCarousel" data-slide-to="2" class=""></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="active item ">
                <div class="container">
                    <div class="carousel-caption">
                        <h1>Example headline.</h1>
                        <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="container">
                    <div class="carousel-caption">
                        <h1>Another example headline.</h1>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                    </div>
                </div>
            </div>
            <div class="item">
                <img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
                <div class="container">
                    <div class="carousel-caption">
                        <h1>One more for good measure.</h1>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                    </div>
                </div>
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <div class="container marketing">
        <div class="row">
            <h2>Best Schools</h2>
        </div>
        <div class="row">
            <div class="col-sm-4">
                <a class="btn icon-btn btn-danger" href="#"><span class="glyphicon btn-glyphicon glyphicon-fire img-circle text-danger"></span>First</a>
                <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                <h1>School Name</h1>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle text-success"></span>100%</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-star img-circle text-success"></span>5.0</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-user img-circle text-success"></span>10.000</a>
            </div><!-- /.col-lg-4 -->
            <div class="col-sm-4">
                <a class="btn icon-btn btn-info" href="#"><span class="glyphicon btn-glyphicon glyphicon-fire img-circle text-info"></span>Second</a>
                <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                <h1>School Name</h1>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle text-success"></span>100%</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-star img-circle text-success"></span>5.0</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-user img-circle text-success"></span>10.000</a>
            </div><!-- /.col-lg-4 -->
            <div class="col-sm-4">
                <a class="btn icon-btn btn-default" href="#"><span class="glyphicon btn-glyphicon glyphicon-fire img-circle text-muted"></span>Third</a>
                <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                <h1>School Name</h1>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle text-success"></span>100%</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-star img-circle text-success"></span>5.0</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-user img-circle text-success"></span>10.000</a>
            </div><!-- /.col-lg-4 -->
        </div>
    </div>
    <div class="container marketing">
        <div class="row">
            <h2>Best Agents</h2>
        </div>
        <div class="row">
            <div class="col-sm-4">
                <a class="btn icon-btn btn-danger" href="#"><span class="glyphicon btn-glyphicon glyphicon-fire img-circle text-danger"></span>First</a>
                <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                <h2>Agency</h2>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle text-success"></span>100%</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-star img-circle text-success"></span>5.0</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-user img-circle text-success"></span>10.000</a>
            </div><!-- /.col-lg-4 -->
            <div class="col-sm-4">
                <a class="btn icon-btn btn-info" href="#"><span class="glyphicon btn-glyphicon glyphicon-fire img-circle text-info"></span>Second</a>
                <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                <h2>Agency</h2>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle text-success"></span>100%</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-star img-circle text-success"></span>5.0</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-user img-circle text-success"></span>10.000</a>
            </div><!-- /.col-lg-4 -->
            <div class="col-sm-4">
                <a class="btn icon-btn btn-default" href="#"><span class="glyphicon btn-glyphicon glyphicon-fire img-circle text-muted"></span>Third</a>
                <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                <h2>Agency</h2>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle text-success"></span>100%</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-star img-circle text-success"></span>5.0</a>
                <a class="btn icon-btn btn-success" href="#"><span class="glyphicon btn-glyphicon glyphicon-user img-circle text-success"></span>10.000</a>
            </div><!-- /.col-lg-4 -->
        </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>