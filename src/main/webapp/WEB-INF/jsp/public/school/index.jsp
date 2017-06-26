<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="/header.jsp"></jsp:include>

<script type="text/javascript">
$(document).ready(function() {
  $(".js-example-basic-single").select2();
});
</script>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
    		<form role="form" action="/school" method="POST">
    			<div class="text-center">
    			    <h2>Register School</h2>
    			</div>
    			<hr class="colorgraph">

                <c:set var="nameHasBindError"><form:errors path="school.name"/></c:set>
                <div class="form-group ${not empty nameHasBindError ? 'has-error' : ''}">
                    <input type="text" autocomplete="off" name="name" class="form-control input-lg" value="${school.name}" placeholder="School Name" tabindex="1">
                    <c:if test="${not empty nameHasBindError}"><label class="control-label">${nameHasBindError}</label></c:if>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon3">http://</span>
                        <input class="form-control input-lg" type="text" autocomplete="off" name="webSite" value="${school.webSite}" placeholder="WebSite" tabindex="2">
                    </div>

                </div>
    			<div class="form-group form-group-lg">
                    <select class="js-example-basic-single form-control" style="width:100%;" name="regionalCouncil.regionalCouncilId">
                        <c:forEach items="${regions}" var="r">
                            <option value="${r.regionalCouncilId}">${r.name}</option>
                        </c:forEach>
                    </select>
                </div>
    			<hr class="colorgraph">
    			<div class="row">
    				<div class="col-xs-12"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="3"></div>
    			</div>
    			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		</form>
    	</div>
    </div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>