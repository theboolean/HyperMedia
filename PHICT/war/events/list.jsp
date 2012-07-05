<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="events Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<c:choose> 
                <c:when test="${project == null}"> 
                    <a href="/events/">All Events</a>
                </c:when> 
                <c:otherwise> 
                    <a href="/themes/show?key=${f:h(projectTheme.id)}">${f:h(projectTheme.name)}</a> &nbsp; &gt; &nbsp; 
                    <a href="/projects/show?key=${f:h(project.id)}">${f:h(project.name)}</a> &nbsp; &gt; &nbsp; 
                    Events
                </c:otherwise> 
            </c:choose>
		</div>

		<div id="content">
			<c:choose> 
			    <c:when test="${project == null}"> 
			        <p> This is a raw list of all recent events. Be ware: list items are unrelated and presented only for a matter
                    of completeness. This list is not intended to be browsed directly. Please, use the <a href="/themes/" title="Themes">theme section</a>
                    to select a project of your choice and then proceed to view its events. </p>
		        </c:when> 
			    <c:otherwise> 
			        <p> The <i>${f:h(project.name)}</i> project has the following list of events:</p>
			    </c:otherwise> 
			</c:choose> 
			
			<ul>
			<c:forEach var="event" items="${projectEvents}">
				<li> <a href="/events/show?key=${f:h(event.id)}" title="Go to event's home"> ${ event.presentation }</a> </li>
			</c:forEach>
			</ul>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />

