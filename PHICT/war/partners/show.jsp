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
			<a href="/partners/">All partners</a> &nbsp; &gt; &nbsp;
			${f:h(partner.name)}
		</div>

		<div id="content">
			<div class="postit">
				Related content:
				<ul>
					<li>Researchers</li>
					<li>Projects</li>
				</ul>
			</div>

			<div id="content-text">

				<h2>${f:h(partner.name)}</h2>
				<p>${ partner.description }</p>
			</div>

			<div class="clear"></div>

			<div id="navigation">
				<a href="/partners/previous?key=${f:h(partnerKey)}">Previous
					Partner</a> &nbsp; | &nbsp; <a href="/partners/">All Partners</a>
				&nbsp; | &nbsp; <a href="/partners/next?key=${f:h(partnerKey)}">Next
					Partner</a>
			</div>
		</div>

	</div>
</div>

<jsp:include page="../common/footer.jsp" />

