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
			<a href="/themes/show?key=${f:h(projectTheme.id)}">${f:h(projectTheme.name)}</a>
			&nbsp; &gt; &nbsp; <a href="/projects/show?key=${f:h(project.id)}">${f:h(project.name)}</a>
			&nbsp; &gt; &nbsp; Events
		</div>

		<div id="content">
			<div class="postit">
				Related content:
				<ul>
					<li><a href="/projects/show?key=${f:h(project.id)}"
						title="Project of this event">Related Project</a></li>
				</ul>
			</div>


			<p>${ event.presentation }</p>

			<div class="clear"></div>
		</div>

		<div id="navigation">
			<a
				href="/events/previous?project=${f:h(project.id)}&key=${f:h(event.id)}">Previous
				Event</a> &nbsp; | &nbsp; <a
				href="/events/show?project=${f:h(project.id)}">All Events</a> &nbsp;
			| &nbsp; <a
				href="/events/next?project=${f:h(project.id)}&key=${f:h(event.id)}">Next
				Event</a>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />
