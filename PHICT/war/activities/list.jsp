<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="activities Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<c:choose> 
                <c:when test="${project == null}"> 
                    All Activities
                </c:when> 
                <c:otherwise> 
                    <a href="/themes/show?key=${f:h(projectTheme.id)}">${f:h(projectTheme.name)}</a> &nbsp; &gt; &nbsp; <a href="/projects/show?key=${f:h(projectKey)}">${f:h(project.name)}</a> &nbsp; &gt; &nbsp; Activities
                </c:otherwise> 
            </c:choose>
		</div>

		<div id="content">
		    <c:choose> 
			    <c:when test="${project == null}"> 
			        <p> This is a raw list of all recent activities. Be ware: list items are unrelated and presented only for a matter
                    of completeness. This list is not intended to be browsed directly. Please, use the <a href="/themes/" title="Themes">theme section</a>
                    to select a project of your choice and then proceed to view its activities. </p>
		        </c:when> 
			    <c:otherwise> 
			        <p> The <i>${f:h(project.name)}</i> project has the following list of activities:</p>
			    </c:otherwise> 
			</c:choose> 
			
			<c:if test="${ empty projectActivities }">
				<p> <i> Sorry, there aren't any activities in this section! </i> </p>
			</c:if>
			
		    <ul>
			<c:forEach var="activity" items="${projectActivities}">
			    <li> <a href="/activities/show?key=${f:h(activity.id)}" title="Go to activity's home"> ${f:h(activity.goals)}</a> </li>
			</c:forEach>
			</ul>
		</div>
	</div>
</div>


<jsp:include page="/common/footer.jsp" />

