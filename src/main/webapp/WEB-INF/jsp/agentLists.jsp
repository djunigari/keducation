<jsp:include page="/header.jsp"></jsp:include>
<link href="/css/style.css" rel="stylesheet">
    <div class="content">
		<div class="content-form">
		    <div class="row">
                <div class="col-xs-12 pull-left">
            	    <strong>Agent Directory by Region:</strong>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 pull-left">
                    <a href="agentLists?Northland" style="text-decoration: none;">Northland</a> ||
					<a href="agentLists?Auckland" style="text-decoration: none;">Auckland</a> ||
					<a href="agentLists?Waikato" style="text-decoration: none;">Waikato</a> ||
					<a href="agentLists?Bay Of Plenty" style="text-decoration: none;">Bay Of Plenty</a> ||
					<a href="agentLists?Gisborne" style="text-decoration: none;">Gisborne</a> ||
					<a href="agentLists?Hawkes Bay" style="text-decoration: none;">Hawkes Bay</a> ||
					<a href="agentLists?Taranaki" style="text-decoration: none;">Taranaki</a> ||
					<a href="agentLists?Manawatu-Wanganui" style="text-decoration: none;">Manawatu-Wanganui</a> ||
					<a href="agentLists?Wellington" style="text-decoration: none;">Wellington</a> ||
					<a href="agentLists?Nelson" style="text-decoration: none;">Nelson</a> ||
					<a href="agentLists?Marlborough" style="text-decoration: none;">Marlborough</a> ||
					<a href="agentLists?West Coast" style="text-decoration: none;">West Coast</a> ||
					<a href="agentLists?Canterbury" style="text-decoration: none;">Canterbury</a> ||
					<a href="agentLists?Otago" style="text-decoration: none;">Otago</a> ||
					<a href="agentLists?Southland" style="text-decoration: none;">Southland</a> ||
					<a href="agentLists?Tasman" style="text-decoration: none;">Tasman</a>
                </div>
            </div>
            <hr />
            <div class="row">
                <div class="col-xs-12 pull-left">
                <strong>Find an agent in New Zealand:</strong>
                </div>
            </div>
			<form method="post" action="agentLists">
			    <div class="row">
					<div class="col-xs-12 col-sm-5">
						<input class="form-control" type="text" name="sRegion" id="search" size="25" placeholder="Your region" />
					</div>
					<div class="col-xs-12 col-sm-5">
						<input class="form-control" type="text" name="sName" id="search" size="25" placeholder="Agent name (optional)" />
					</div>
					<div class="col-xs-12 col-sm-2">
                        <button type="submit" class="btn btn-success">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div>
                </div>
            </form>
            <hr />
            <div class="row">
                <div class="col-xs-12 pull-left">
                    <strong>Search result:</strong>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 pull-left">
                    <div style="height: 220px; line-height: 10px; overflow: scroll; overflow-y: scroll;">
                        <%=result%>
                    </div>
                </div>
            </div>
		</div>
	</div>
<jsp:include page="/footer.jsp"></jsp:include>
