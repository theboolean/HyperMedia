<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="years Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			All Years
		</div>

		<div id="content">
			<p><a href="/themes/">You can also browse Project by Themes</a></p>
			<c:forEach var="year" items="${years}">
				<h2><a href="/years/show?key=${f:h(year)}" title="Projects of this year">${f:h(year)}</a></h2>
				<br>
				<br>
			</c:forEach>
		</div>
	</div>
</div>


<jsp:include page="/common/footer.jsp" />

