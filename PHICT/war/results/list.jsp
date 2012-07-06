<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="results Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<c:choose> 
                <c:when test="${activity == null}"> 
                    All Events
                </c:when> 
                <c:otherwise> 
                    <a href="/themes/show?key=${f:h(projectTheme.id)}">${f:h(projectTheme.name)}</a> &nbsp; &gt; &nbsp; <a href="/projects/show?key=${f:h(projectKey)}">${f:h(project.name)}</a> &nbsp; &gt; &nbsp; 
                    <a href="/activities/show?key=${f:h(activity.id)}">${f:h(activity.schedule)}</a> &nbsp; &gt; &nbsp; Results
                </c:otherwise> 
            </c:choose>
		</div>

		<div id="content">
		<c:choose> 
			    <c:when test="${project == null}"> 
			        <p> This is a raw list of all recent results. Be ware: list items are unrelated and presented only for a matter
                    of completeness. This list is not intended to be browsed directly. Please, use the <a href="/themes/" title="Themes">theme section</a>
                    to select a project of your choice, proceed to view its activities and then their results. </p>
		        </c:when> 
			    <c:otherwise> 
			        <p> The <i>${f:h(activity.schedule)}</i> activity has the following list of results:</p>
			    </c:otherwise> 
			</c:choose> 
			
			<c:if test="${ empty projectActivities }">
				<p> <i> Sorry, there aren't any results in this section! </i> </p>
			</c:if>
			
		    <ul>
			<c:forEach var="result" items="${projectResults}">
					<li> <a href="/results/show?key=${f:h(result.id)}"
						title="Go to result's home"> ${f:h(result.overview)}</a> </li>
			</c:forEach>
			</ul>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />

