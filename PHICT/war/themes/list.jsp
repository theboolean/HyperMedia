<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="themes Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			All Themes
		</div>

		<div id="content">
		    <c:forEach var="theme" items="${themes}">
			    <div class="theme">
					<h2><a href="/themes/show?key=${f:h(theme.id)}" title="Projects by this theme">${f:h(theme.name)}</a></h2>
					${ theme.description }
			    </div>
			</c:forEach>
		</div>
	</div>
</div>


<jsp:include page="/common/footer.jsp" />

