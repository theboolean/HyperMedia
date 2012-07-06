<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="years Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="content">
			<p><a href="/themes/">You can also browse Project by Themes</a></p>
			
			<c:if test="${ empty years }">
				<p> <i> Sorry, our calendar is still empty! </i> </p>
			</c:if>
			
			<ul>
			<c:forEach var="year" items="${years}">
				<li> <a href="/years/show?key=${f:h(year)}" title="Projects of this year">${f:h(year)}</a> </li>
			</c:forEach>
			</ul>
		</div>
	</div>
</div>


<jsp:include page="/common/footer.jsp" />

