<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="Admin" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			Admin Page
		</div>

		<div id="content">
			ADD:
			<p><a href="/activities/add">add new activity</a></p>
			<p><a href="/events/add">add new event</a></p>
			<p><a href="/partners/add">add new partner</a></p>
			<p><a href="/projects/add">add new project</a></p>
			<p><a href="/researchers/add">add new researcher</a></p>
			<p><a href="/results/add">add new result</a></p>
			<p><a href="/themes/add">add new theme</a></p>
			
			SHOW:
			<p><a href="/activities/">show all activities</a></p>
			<p><a href="/events/">show all events</a></p>
			<p><a href="/partners/">show all partners</a></p>
			<p><a href="/projects/">show all projects</a></p>
			<p><a href="/researchers/">show all researchers</a></p>
			<p><a href="/results/">show all results</a></p>
			<p><a href="/themes/">show all themes</a></p>
			
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />
