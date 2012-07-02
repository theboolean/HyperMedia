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
			<a href="#">All years</a>
		</div>

		<div id="content">
			<c:forEach var="year" items="${years}">
				<h2><a
				href="/projects/show?year=${f:h(year)}"
				title="Projects by this year">${f:h(year)}</a></h2>
				<br>
				<br>
			</c:forEach>
			<p><a href="/themes/">Browse Project By Themes</a></p>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />
