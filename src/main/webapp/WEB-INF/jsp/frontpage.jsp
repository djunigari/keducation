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
    </head>
<body>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="menu">
                <ul class="nav navbar-nav">
                    <li><a href="/about">About Us</a></li>
                    <li><a href="/school">List of Schools</a></li>
                    <li><a href="/agentLists">List of Agents</a></li>
                    <li><a href="/">Keducation Awards</a></li>
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

        <div class="site-wrapper text-center">
            <div class="site-wrapper-inner">
                <div class="cover-container">
                    <div class="inner cover">
                        <img src="/images/main-logo_1.png"/>
                        <h1 class="cover-heading">FOR A BETTER CHOICE OF EDUCATION</h1>
                        <p class="lead">
                            Share your experience! Share your view!
                        </p>
                    </div>
                    <form class="form-search form-horizontal center-block" method="get" action="/school">
                        <div class="col-xs-0 col-sm-4"></div>
                        <div class="col-xs-12 col-sm-4 input-group">
                            <input name="region" class="form-control" list="regions" placeholder="Search by Region">
                            <datalist id="regions">
                                <c:forEach items="${regions}" var="r">
                                    <option>${r.name}</option>
                                </c:forEach>
                            </datalist>
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-default">
                                    <span class="glyphicon glyphicon-search">
                                        <span class="sr-only">Search...</span>
                                    </span>
                                </button>
                            </span>
                        </div>
                        <div class="col-xs-0 col-sm-4"></div>
                    </form>

                </div>
            </div>
        </div>
    <jsp:include page="/footer.jsp"></jsp:include>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>