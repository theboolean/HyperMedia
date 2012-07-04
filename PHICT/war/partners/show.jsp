<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="../common/header.jsp">
	<jsp:param name="pageName" value="partner Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<a href="#a">aaaa</a> &nbsp; &gt; &nbsp; <a href="#b">bbbb</a>
		</div>

		<div id="content">
			<h1>${f:h(partner.name)}</h1>
			${f:h(partner.description)} <br /> <br /> Semantic links: <br /> <a
				href="/researchers/show?partner=${f:h(partnerKey)}"
				title="Researchers of this partner">Researchers</a> <br /> <a
				href="/projects/show?partner=${f:h(partnerKey)}"
				title="Projects of this partner">Projects</a>
		</div>
		
		<div id="navigation">
			<a href="#">Previous Partner</a> &nbsp; | &nbsp; <a href="/partners/">All Partners</a> &nbsp; | &nbsp; <a href="#">Next Partner</a>
		</div>
	</div>
</div>

<jsp:include page="../common/footer.jsp" />

