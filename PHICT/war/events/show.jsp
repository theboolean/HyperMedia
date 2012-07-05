<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="event Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<a href="/projects/">All projects</a> &nbsp; &gt; &nbsp; 
			<a href="/projects/show?key=${f:h(projectKey)}">${f:h(project.name)}</a> &nbsp; &gt; &nbsp;
			<a href="/events/show?project=${f:h(projectKey)}">Events</a>
		</div>

		<div id="content">
			<p>${ event.presentation }</p>
		</div>
		
		<div id="navigation">
			<a href="#">Previous Event</a> &nbsp; | &nbsp; 
			<a href="/events/show?project=${f:h(projectKey)}">All Events</a> &nbsp; | &nbsp; 
			<a href="#">Next Event</a>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />
