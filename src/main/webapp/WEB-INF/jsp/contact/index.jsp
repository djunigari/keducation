<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/header.jsp"></jsp:include>
<link href="/css/style.css" rel="stylesheet">
<div class="content content-form">
    <div class="row">
        <div class="col-xs-12 text-center">
            <h3>Contact Us</h3>
            <c:if test="${empty sessionScope.user.userName}">
                <jsp:include page="fragments/completed-email-form.jsp"></jsp:include>
            </c:if>
            <c:if test="${not empty sessionScope.user.userName}">
                    <jsp:include page="fragments/incompleted-email-form.jsp"></jsp:include>
            </c:if>
        </div>
        <div class="col-xs-12">
            <div class="row">
                <div class="col-xs-12 col-sm-6">
                    <p><strong>&copy;Copyright</strong></p>
                    <p><strong>Address : </strong> --- </p>
                    <p><strong>Phone : </strong> --- </p>
                    <p><strong>E-mail : </strong>contact@keducation.co.nz</p>
                </div>
                <div class="col-xs-12 col-sm-6 text-center">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3192.6097678171677!2d174.75785978747143!3d-36.851820879937904!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6d0d47ee5baf7847%3A0xf7c6175acd274621!2s171+Hobson+St%2C+Auckland%2C+1010!5e0!3m2!1sen!2snz!4v1496810673956" width="400" height="300" frameborder="0" style="border:0" allowfullscreen></iframe>
                </div>
            </div>
        </div>
	</div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>