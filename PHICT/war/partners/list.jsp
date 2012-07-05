<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="../common/header.jsp">
	<jsp:param name="pageName" value="partners Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<a href="/partners/">All Partners</a>
		</div>

		<div id="content">
			<p> All the partners that are participating in the program: </p>
			<c:forEach var="partner" items="${projectPartners}">
			    <div class="project">
					<h2> <a href="/partners/show?key=${f:h(partner.id)}" title="Go to partner's home"> ${f:h(partner.name)}</a> </h2>
		 	  		${ partner.description }
	  	  		</div>
			</c:forEach>
		</div>
	</div>
</div>

<jsp:include page="../common/footer.jsp" />

