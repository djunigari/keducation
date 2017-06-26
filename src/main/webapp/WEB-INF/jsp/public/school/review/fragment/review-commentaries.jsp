<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<link href="/css/review.css" rel="stylesheet">

<div class="container">
    <div class="row review-commentaries">
        <div class="col-xs-12 center-block">
            <div class="well well-sm">
                <c:forEach var="review" items="${schoolReview.reviewList}">
                    <div class="row">
                        <div class="col-xs-12 col-sm-2">
                            <div class="review-block-name"><a href="${review.user['class'].simpleName == 'FacebookUser' ? review.user.link : '#' }"><c:out value="${review.user.userName}" /></a></div>
                            <div class="review-block-date"><fmt:formatDate type = "both" value = "${review.dataReview.time}" /></div>
                        </div>
                        <div class="col-xs-12 col-sm-10">
                            <div class="row">
                                <div class="col-xs-12 review-block-rate">
                                    <c:forEach begin="1" end="${review.score}">
                                        <span class="glyphicon glyphicon-star"></span>
                                    </c:forEach>
                                    <c:forEach begin="${review.score}" end="4">
                                        <span class="glyphicon glyphicon-star-empty"></span>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <textarea class="form-control text-area-commentary" rows="3" readonly><c:out value="${review.commentary}" /></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr/>
                </c:forEach>
            </div>
        </div>
    </div>
</div>