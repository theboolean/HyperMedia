<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="researchers Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			Researchers
		</div>

		<div id="content">
			<c:forEach var="researcher" items="${partnerResearchers}">
				<h2>
					<a href="/researchers/show?key=${f:h(researcher.id)}"
						title="Go to researcher's home"> ${f:h(researcher.name)}
						${f:h(researcher.surname)}</a>
				</h2>
				<br>
				<br>
			</c:forEach>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />

