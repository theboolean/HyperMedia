<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="../common/header.jsp" >
<jsp:param name="pageName" value="projects show"/>
</jsp:include>

	<h1>${f:h(project.name)}</h1>
	${f:h(project.description)}
	<br />
	<br />${f:h(project.mainGoals)}
	<br />
	<br /> Semantic links:
	<br />

	<a href="/activities/show?project=${f:h(projectKey)}"
		title="Activities for this project">Activities</a>
	<br />
	<a href="/events/show?project=${f:h(projectKey)}"
		title="Events for this project">Events</a>
	<br />
	<a href="/partners/show?project=${f:h(projectKey)}"
		title="Partners for this project">Partners</a>
	<br />
	<a href="/results/show?project=${f:h(projectKey)}"
		title="Important results of this project">Important Results</a>

<jsp:include page="../common/footer.jsp" />

