<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="events Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<a href="#a">aaaa</a> &nbsp; &gt; &nbsp; <a href="#b">bbbb</a>
		</div>

		<div id="content">
			<c:forEach var="event" items="${projectEvents}">
				<h2>
					<a href="/events/show?key=${f:h(event.id)}"
						title="Go to event's home"> ${f:h(event.presentation)}</a>
				</h2>
				<br>
				<br>
			</c:forEach>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />

