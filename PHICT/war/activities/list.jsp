<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp" >
<jsp:param name="pageName" value="activities Show"/>
</jsp:include>

	<c:forEach var="activity" items="${projectActivities}">
		<h2>
			<a href="/activities/show?key=${f:h(activity.id)}"
				title="Go to activity's home"> ${f:h(activity.goals)}</a>
		</h2>
		    ${f:h(activity.schedule)}  
		    <br>
		<br>
	</c:forEach>
	
<jsp:include page="/common/footer.jsp" />

