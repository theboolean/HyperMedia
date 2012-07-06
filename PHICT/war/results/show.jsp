<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="result Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<a href="/themes/show?key=${f:h(projectTheme.id)}">${f:h(projectTheme.name)}</a> &nbsp; &gt; &nbsp; <a href="/projects/show?key=${f:h(projectKey)}">${f:h(project.name)}</a> &nbsp; &gt; &nbsp; 
            <a href="/activities/show?key=${f:h(activity.id)}">${f:h(activity.schedule)}</a> &nbsp; &gt; &nbsp; Results
		</div>

		<div id="content">
			<p>${f:h(result.overview)}</p>
		</div>
		
		<div id="navigation">
			<a href="/results/previous?activity=${f:h(activity.id)}&key=${f:h(result.id)}">Previous Result</a> &nbsp; | &nbsp; 
			<a href="/results/show?activity=${f:h(activity.id)}">All Result</a> &nbsp; | &nbsp; 
			<a href="/results/next?activity=${f:h(activity.id)}&key=${f:h(result.id)}">Next Result</a>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />

