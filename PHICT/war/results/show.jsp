<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="result Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<a href="#a">aaaa</a> &nbsp; &gt; &nbsp; <a href="#b">bbbb</a>
		</div>

		<div id="content">
			<p>${f:h(result.overview)}</p>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />

