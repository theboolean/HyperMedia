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
			<a href="/Themes">All Themes</a> &nbsp; &gt; &nbsp; <a href="#">Projects By Theme</a>
		</div>

		<div id="content">
			<c:forEach var="project" items="${projects}">
				<h1>
					<a href="show?key=${f:h(project.id)}" title="Go to project's home">
						${f:h(project.name)} </a>
				</h1>
	 	  		${f:h(project.description)}
	  	  		<br>
				<br>
			</c:forEach>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />

