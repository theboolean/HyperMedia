<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="../common/header.jsp">
	<jsp:param name="pageName" value="project Show" />
</jsp:include>

<script type="text/javascript" src="/js/tabs.js"></script>
<script type="text/javascript">
	$(function() {
		makeTabs();
	});
</script>

<div id="mainContainer">

	<div id="innerContainer">
		<div id="breadcrumbs">
			<a href="/themes/show?key=${f:h(theme.id)}">${f:h(theme.name)}</a>
			&nbsp; &gt; &nbsp; ${f:h(project.name)}
		</div>

		<div id="content">
			<div class="postit">
				Related content:
				<ul>
					<li><a href="/activities/show?project=${f:h(projectKey)}"
						title="Activities for this project">Activities</a></li>
					<li><a href="/events/show?project=${f:h(projectKey)}"
						title="Events for this project">Events</a></li>
					<li><a href="/partners/show?project=${f:h(projectKey)}"
						title="Partners involved in this project">Partners</a></li>
					<li>Important Results</li>
				</ul>
			</div>
			
			<div id="myTabs">
				<ul>
					<li><a href="/description.html">Description</a></li>
					<li><a href="/maingoal.html">Main Goals</a></li>
					<li><a href="/documentation.html">Documentation</a></li>
				</ul>
			</div>

			<script type="text/javascript">
				$(function() {
					$("#myTabs").tabs();
				});
			</script>

			<div class="clear"></div>
		</div>
	</div>
</div>

<jsp:include page="../common/footer.jsp" />

