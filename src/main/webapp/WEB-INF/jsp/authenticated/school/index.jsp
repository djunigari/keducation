<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="/header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
    		<form role="form" action="/user" method="POST">
    			<div class="text-center">
    			    <h2>Register School</h2>
    			</div>
    			<hr class="colorgraph">

                <c:set var="nameHasBindError"><form:errors path="school.name"/></c:set>
                <div class="form-group ${not empty nameHasBindError ? 'has-error' : ''}">
                    <input type="text" autocomplete="off" name="name" class="form-control input-lg" value="${school.name}" placeholder="School Name" tabindex="1">
                    <c:if test="${not empty nameHasBindError}"><label class="control-label">${nameHasBindError}</label></c:if>
                </div>
    			<c:set var="webSiteHasBindError"><form:errors path="school.webSite"/></c:set>
                <div class="form-group ${not empty webSiteHasBindError ? 'has-error' : ''}">
                    <input class="form-control input-lg" type="text" autocomplete="off" name="webSite" value="${school.webSite}" placeholder="WebSite" tabindex="2">
                    <c:if test="${not empty webSiteHasBindError}"><label class="control-label">${webSiteHasBindError}</label></c:if>
                </div>
    			<div class="row">
    		        <div class="col-xs-12 col-sm-6">
                        <c:set var="phoneHasBindError"><form:errors path="school.phone"/></c:set>
                        <div class="form-group ${not empty phoneHasBindError ? 'has-error' : ''}">
    		                <input type="password" name="phone" class="form-control input-lg" placeholder="Phone" tabindex="3">
    		                <c:if test="${not empty phoneHasBindError}"><label class="control-label">${phoneHasBindError}</label></c:if>
                        </div>
    		        </div>
    		        <div class="col-xs-12 col-sm-6">
                        <c:set var="faxHasBindError"><form:errors path="school.fax"/></c:set>
                        <div class="form-group ${not empty faxHasBindError ? 'has-error' : ''}">
    		                <input type="password" name="fax" class="form-control input-lg" placeholder="Fax" tabindex="4">
    		                <c:if test="${not empty faxHasBindError}"><label class="control-label">${faxHasBindError}</label></c:if>
                        </div>
    		        </div>
    			</div>
                <c:set var="streetHasBindError"><form:errors path="school.webSite"/></c:set>
                <div class="form-group ${not empty streetHasBindError ? 'has-error' : ''}">
                    <input class="form-control input-lg" type="text" autocomplete="off" name="street" value="${school.street}" placeholder="Street number and name" tabindex="5">
                    <c:if test="${not empty streetHasBindError}"><label class="control-label">${streetHasBindError}</label></c:if>
                </div>
                <div class="form-group">
                    <input class="form-control input-lg" name="suburb" list="suburbs" placeholder="Suburb">
                    <datalist id="suburbs">
                        <c:forEach items="${suburbs}" var="s">
                            <option value="${s.suburbId}">${s.name}</option>
                        </c:forEach>
                    </datalist>
                </div>
                <c:set var="postAddress2HasBindError"><form:errors path="school.webSite"/></c:set>
                <div class="form-group ${not empty postAddress2HasBindError ? 'has-error' : ''}">
                    <input class="form-control input-lg" type="text" autocomplete="off" name="postAddress2" value="${school.postAddress2}" placeholder="Town/City" tabindex="6">
                    <c:if test="${not empty postAddress2HasBindError}"><label class="control-label">${postAddress2HasBindError}</label></c:if>
                </div>
                <div class="form-group ${not empty postAddress3HasBindError ? 'has-error' : ''}">
                    <input class="form-control input-lg" type="text" autocomplete="off" name="webSite" value="${school.postAddress3}" placeholder="State/Province/Region" tabindex="7">
                    <c:if test="${not empty postAddress3HasBindError}"><label class="control-label">${postAddress3HasBindError}</label></c:if>
                </div>
                <c:set var="postAddress1HasBindError"><form:errors path="school.webSite"/></c:set>
                <div class="form-group ${not empty postAddress1HasBindError ? 'has-error' : ''}">
                    <input class="form-control input-lg" type="text" autocomplete="off" name="postAddress1" value="${school.postAddress1}" placeholder="P.O. Box" tabindex="8">
                    <c:if test="${not empty postAddress1HasBindError}"><label class="control-label">${postAddress1HasBindError}</label></c:if>
                </div>
                <c:set var="postCodeHasBindError"><form:errors path="school.webSite"/></c:set>
                <div class="form-group ${not empty postCodeHasBindError ? 'has-error' : ''}">
                    <input class="form-control input-lg" type="text" autocomplete="off" name="postCode" value="${school.postCode}" placeholder="Post/Zip code" tabindex="9">
                    <c:if test="${not empty postCodeHasBindError}"><label class="control-label">${postCodeHasBindError}</label></c:if>
                </div>
                <div class="form-group">
                    <input class="form-control input-lg" name="authoritySchool" list="authorities" placeholder="Authority School">
                    <datalist id="authorities">
                        <c:forEach items="${authorities}" var="a">
                            <option value="${a.authoritySchoolId}">${a.name}</option>
                        </c:forEach>
                    </datalist>
                </div>
                <div class="form-group">
                    <input class="form-control input-lg" name="categorySchool" list="categories" placeholder="Category School">
                    <datalist id="categories">
                        <c:forEach items="${categories}" var="c">
                            <option value="${c.categorySchoolId}">${c.name}</option>
                        </c:forEach>
                    </datalist>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                            <input class="form-control input-lg" name="typeSchool" list="typeSchoolList" placeholder="Type School">
                            <datalist id="typeSchoolList">
                                <c:forEach items="${typeSchoolList}" var="t">
                                    <option value="${t.typeSchoolId}">${t.name}</option>
                                </c:forEach>
                            </datalist>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                            <input class="form-control input-lg" name="fundingType" list="fundingTypeList" placeholder="Funding Type">
                            <datalist id="fundingTypeList">
                                <c:forEach items="${fundingTypeList}" var="f">
                                    <option value="${f.name}">${f.value}</option>
                                </c:forEach>
                            </datalist>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                            <input class="form-control input-lg" name="regionalCouncil" list="regions" placeholder="Regional Council">
                            <datalist id="regions">
                                <c:forEach items="${regions}" var="r">
                                    <option value="${r.regionalCouncilId}">${r.name}</option>
                                </c:forEach>
                            </datalist>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                            <input class="form-control input-lg" name="territorialAuthority" list="territorialAuthorityList" placeholder="Territorial Authority">
                            <datalist id="territorialAuthorityList">
                                <c:forEach items="${territorialAuthorityList}" var="t">
                                    <option value="${t.territorialAuthorityId}">${t.name}</option>
                                </c:forEach>
                            </datalist>
                        </div>
                    </div>
                </div>
    			<hr class="colorgraph">
    			<div class="row">
    				<div class="col-xs-12"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="12"></div>
    			</div>
    			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		</form>
    	</div>
    </div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>
