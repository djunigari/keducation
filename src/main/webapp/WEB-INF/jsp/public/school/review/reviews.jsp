<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="fragment/review-school.jsp"></jsp:include>
<c:if test="${fn:length(schoolReview.reviewList) gt 0}">
    <jsp:include page="fragment/review-commentaries.jsp"></jsp:include>
</c:if>
<jsp:include page="/footer.jsp"></jsp:include>



