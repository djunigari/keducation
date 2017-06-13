<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/header.jsp"></jsp:include>
<link href="/css/style.css" rel="stylesheet">
<div class="container">
    <div class="row content-form">
            <form class="form" method="GET" action="/school">
                <div class="row">
                    <div class="col-xs-12 col-sm-5 form-group">
                        <input name="region" class="form-control" list="regions" placeholder="Search by Region">
                        <datalist id="regions">
                            <c:forEach items="${regions}" var="r">
                                <option>${r.name}</option>
                            </c:forEach>
                        </datalist>
                    </div>
                    <div class="col-xs-12 col-sm-5 form-group">
                        <input class="form-control" type="text" name="school-name" placeholder="School Name" />
                    </div>
                    <div class="col-xs-12 col-sm-2 form-group">
                        <button type="submit" class="btn btn-success">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div>
                </div>
            </form>

            <hr />
            <div class="row">
                <div class="col-xs-12 pull-left">
                    <strong>Search result: ${totalResult} schools</strong>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 pull-left">
                    <div class="list-group">
                        <c:forEach items="${schools}" var="s">
                            <a href="/school/reviews?school-id=${s.schoolId}" class="list-group-item">${s.name}</a>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <nav class="text-center">
                <ul class="pagination">
                    <c:if test="${currentPage < 10}">
                        <c:forEach var="i" begin="1" end="${totalPages <= 10 ? totalPages : 10}">
                            <li class="${currentPage == i ? 'active' : ''}"><a href="${href}${i}">${i}</a></li>
                        </c:forEach>
                    </c:if>
                    <c:if test="${currentPage >= 10}">
                        <c:forEach var="i" begin="${currentPage == totalPages ? currentPage-9 : currentPage-5}" end="${currentPage+4 <= totalPages ? currentPage+4 : totalPages}">
                            <li class="${currentPage == i ? 'active' : ''}"><a href="${href}${i}">${i}</a></li>
                        </c:forEach>
                    </c:if>
                </ul>
            </nav>
		</div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>