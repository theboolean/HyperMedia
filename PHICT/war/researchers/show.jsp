<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="researcher Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<a href="#a">aaaa</a> &nbsp; &gt; &nbsp; <a href="#b">bbbb</a>
		</div>

		<div id="content">
			<p>${f:h(researcher.name)} ${f:h(researcher.surname)}</p>
			<p>${f:h(researcher.curriculum)}</p>
			<br /> <br /> Semantic links: <br /> <a
				href="/partners/show?researcher=${f:h(researcherKey)}"
				title="Partner affiliation">Partner affiliation</a>
		</div>

		<div id="navigation">
			<a href="#">Previous Researcher</a> &nbsp; | &nbsp; <a
				href="/researchers/show?partner=${f:h(partnerKey)}">All
				Researcher</a> &nbsp; | &nbsp; <a href="#">Next Resarcher</a>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />

