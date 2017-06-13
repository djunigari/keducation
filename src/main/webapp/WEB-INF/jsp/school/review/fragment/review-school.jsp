<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<link href="/css/review.css" rel="stylesheet">
<div class="container">
    <div class="row review-score-grade">
        <div class="col-xs-12 center-block">
            <div class="well well-sm">
                <div class="row">
                        <div class="col-xs-12">
                            <div class="row">
                                <div class="col-xs-12 text-center">
                                    <h3><c:out value="${schoolReview.school.name}" /></h3>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12 text-center">
                                    <button type="button" class="btn btn-info text-capitalize btn-xs"><a class="a-btn" href=${not empty schoolReview.school.webSite ? schoolReview.school.webSite : "#"}>Website</a></button>
                                    <button type="button" class="btn btn-info text-capitalize btn-xs"><a class="a-btn" href="#">Courses</a></button>
                                    <button type="button" class="btn btn-info text-capitalize btn-xs"><a class="a-btn" href="#">Gallery</a></button>
                                    <button type="button" class="btn btn-info text-capitalize btn-xs"><a class="a-btn" href="#">News</a></button>
                                    <c:if test="${not empty sessionScope.user.userName}">
                                            <button type="button" class="btn btn-success text-capitalize btn-xs" data-toggle="modal" data-target="#reviewModal" >My Review</button>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                <hr />
                <div class="row">
                    <div class="col-xs-12 col-sm-6 form-group text-center">
                        <h1 class="rating-num">
                            <fmt:formatNumber value = "${schoolReview.score}" maxFractionDigits = "2" />
                            <small>/ 5</small>
                        </h1>
                        <div class="rating">
                            <c:forEach begin="1" end="${schoolReview.score}">
                                <span class="glyphicon glyphicon-star"></span>
                            </c:forEach>
                            <c:forEach begin="${schoolReview.score}" end="4">
                                <span class="glyphicon glyphicon-star-empty"></span>
                            </c:forEach>
                        </div>
                        <div>
                            <span class="glyphicon glyphicon-user"></span><c:out value="${schoolReview.totalReviews}" /> total
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 form-group text-center">
                        <div class="row">
                            <div class="col-xs-3 text-left">
                                <strong>Quality</strong>
                            </div>
                            <div class="col-xs-9">
                                <c:forEach begin="1" end="${schoolReview.qualityScore}">
                                    <span class="glyphicon glyphicon-star"></span>
                                </c:forEach>
                                <c:forEach begin="${schoolReview.qualityScore}" end="4">
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </c:forEach>
                            </div>
                        </div><!-- qualityScore -->
                        <div class="row">
                            <div class="col-xs-3 text-left">
                                <strong>Comfort</strong>
                            </div>
                            <div class="col-xs-9">
                                <c:forEach begin="1" end="${schoolReview.comfortScore}">
                                    <span class="glyphicon glyphicon-star"></span>
                                </c:forEach>
                                <c:forEach begin="${schoolReview.comfortScore}" end="4">
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </c:forEach>
                            </div>
                        </div><!-- comfortScore -->
                        <div class="row">
                            <div class="col-xs-3 text-left">
                                <strong>Location</strong>
                            </div>
                            <div class="col-xs-9">
                                <c:forEach begin="1" end="${schoolReview.locationScore}">
                                    <span class="glyphicon glyphicon-star"></span>
                                </c:forEach>
                                <c:forEach begin="${schoolReview.locationScore}" end="4">
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </c:forEach>
                            </div>
                        </div><!-- locationScore -->
                        <div class="row">
                            <div class="col-xs-3 text-left">
                                <strong>Price</strong>
                            </div>
                            <div class="col-xs-9">
                                <c:forEach begin="1" end="${schoolReview.priceScore}">
                                    <span class="glyphicon glyphicon-star"></span>
                                </c:forEach>
                                <c:forEach begin="${schoolReview.priceScore}" end="4">
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </c:forEach>
                            </div>
                        </div><!-- priceScore -->
                        <div class="row">
                            <div class="col-xs-3 text-left">
                                <strong>Support</strong>
                            </div>
                            <div class="col-xs-9 ">
                                <c:forEach begin="1" end="${schoolReview.supportScore}">
                                    <span class="glyphicon glyphicon-star"></span>
                                </c:forEach>
                                <c:forEach begin="${schoolReview.supportScore}" end="4">
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </c:forEach>
                            </div>
                        </div><!-- supportScore -->
                    </div>
                </div>
                <div class= "row">
                    <div class="col-xs-12">
                        <div class="progress">
                            <c:choose>
                                <c:when test="${schoolReview.recommendation <= 25}">
                                    <c:set var = "progressbar" value="progress-bar-danger"/>
                                </c:when>
                                <c:when test="${schoolReview.recommendation <= 50}">
                                    <c:set var = "progressbar" value="progress-bar-warning"/>
                                </c:when>
                                <c:when test="${schoolReview.recommendation <= 75}">
                                    <c:set var = "progressbar" value="progress-bar-info"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var = "progressbar" value="progress-bar-success"/>
                                </c:otherwise>
                            </c:choose>
                            <div class="progress-bar ${progressbar}" role="progressbar" aria-valuenow="${schoolReview.recommendation}" aria-valuemin="0" aria-valuemax="100" style="width: ${schoolReview.recommendation}%"></div>
                            <span class="progress-type">Recommendations</span>
                            <span class="progress-completed">${schoolReview.recommendation}%</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- MODAL -->
<div class="modal fade" id="reviewModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
  <div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
			<div class="row">
                <div class="col-xs-12 text-center">
                    <h3 class="modal-title"><c:out value="${schoolReview.school.name}" /></h3>
                </div>
            </div>
		</div>
		<div class="modal-body">
		    <form class="form center-block" role="form" method="post" action="/school/review" accept-charset="UTF-8" id="login-nav">
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 form-group">
                            <div class="input-group">
                                <span class="input-group-addon">Quality</span>
                                <select name="qualityScore" class="form-control">
                                    <option value="5" ${review.qualityScore == 5 ? 'selected' : ''}>Wonderful</option>
                                    <option value="4" ${review.qualityScore == 4 ? 'selected' : ''}>Good</option>
                                    <option value="3" ${review.qualityScore == 3 ? 'selected' : ''}>Okay</option>
                                    <option value="2" ${review.qualityScore == 2 ? 'selected' : ''}>Poor</option>
                                    <option value="1" ${review.qualityScore == 1 ? 'selected' : ''}>Very Poor</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 form-group">
                            <div class="input-group">
                                <span class="input-group-addon">Comfort</span>
                                <select name="comfortScore" class="form-control">
                                    <option value="5" ${review.comfortScore == 5 ? 'selected' : ''}>Wonderful</option>
                                    <option value="4" ${review.comfortScore == 4 ? 'selected' : ''}>Good</option>
                                    <option value="3" ${review.comfortScore == 3 ? 'selected' : ''}>Okay</option>
                                    <option value="2" ${review.comfortScore == 2 ? 'selected' : ''}>Poor</option>
                                    <option value="1" ${review.comfortScore == 1 ? 'selected' : ''}>Very Poor</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 form-group">
                            <div class="input-group">
                                <span class="input-group-addon">Location</span>
                                <select name="locationScore" class="form-control">
                                    <option value="5" ${review.locationScore == 5 ? 'selected' : ''}>Wonderful</option>
                                    <option value="4" ${review.locationScore == 4 ? 'selected' : ''}>Good</option>
                                    <option value="3" ${review.locationScore == 3 ? 'selected' : ''}>Okay</option>
                                    <option value="2" ${review.locationScore == 2 ? 'selected' : ''}>Poor</option>
                                    <option value="1" ${review.locationScore == 1 ? 'selected' : ''}>Very Poor</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 form-group">
                            <div class="input-group">
                                <span class="input-group-addon">Price</span>
                                <select name="priceScore" class="form-control">
                                    <option value="5" ${review.priceScore == 5 ? 'selected' : ''}>Wonderful</option>
                                    <option value="4" ${review.priceScore == 4 ? 'selected' : ''}>Good</option>
                                    <option value="3" ${review.priceScore == 3 ? 'selected' : ''}>Okay</option>
                                    <option value="2" ${review.priceScore == 2 ? 'selected' : ''}>Poor</option>
                                    <option value="1" ${review.priceScore == 1 ? 'selected' : ''}>Very Poor</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 pull-center form-group">
                            <div class="input-group">
                                <span class="input-group-addon">Support</span>
                                <select name="supportScore" class="form-control" option="">
                                    <option value="5" ${review.supportScore == 5 ? 'selected' : ''}>Wonderful</option>
                                    <option value="4" ${review.supportScore == 4 ? 'selected' : ''}>Good</option>
                                    <option value="3" ${review.supportScore == 3 ? 'selected' : ''}>Okay</option>
                                    <option value="2" ${review.supportScore == 2 ? 'selected' : ''}>Poor</option>
                                    <option value="1" ${review.supportScore == 1 ? 'selected' : ''}>Very Poor</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 form-group">
                            <strong>Do you Recommend this school ?</strong>
                        </div>
                        <div class="col-xs-12 col-sm-6 form-group">
                            <div class="form-inline required">
                                <div class="col-xs-6 form-group has-feedback">
                                    <label class="input-group">
                                        <span class="input-group-addon">
                                            <input type="radio" name="recommendation" value="true" ${review.recommendation ? 'checked' : ''} />
                                        </span>
                                        <div class="form-control form-control-static">
                                            YES
                                        </div>
                                    </label>
                                </div>
                                <div class="col-xs-6 form-group has-feedback ">
                                    <label class="input-group">
                                        <span class="input-group-addon">
                                            <input type="radio" name="recommendation" value="false" ${review.recommendation ? '' : 'checked'} />
                                        </span>
                                        <div class="form-control form-control-static">
                                            NO
                                        </div>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>

                <div class="form-group">
                    <textarea class="form-control" name="commentary" placeholder="Commentary" rows="3" maxlength=255><c:if test="${not empty review.commentary}"><c:out value="${review.commentary}" /></c:if></textarea>
                </div>
                <input type="hidden" name="reviewPK.schoolId" value="${schoolReview.school.schoolId}" />
                <div class="modal-footer">
                	<div class="btn-group btn-group-justified" role="group" aria-label="group button">
                	    <div class="btn-group" role="group">
                			<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Close</button>
                		</div>
                		<div class="btn-group btn-delete hidden" role="group">
                			<button type="button" class="btn btn-default btn-hover-red" data-dismiss="modal"  role="button">Delete</button>
                		</div>
                		<div class="btn-group" role="group">
                		    <button type="submit" class="btn btn-default btn-hover-green" data-action="save" role="button">Save</button>
                		</div>
                    </div>
                </div>
            </form>
		</div>
	</div>
  </div>
</div>