<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<title>projects Show</title>
</head>
<body>
	<c:forEach var="partner" items="${projectPartners}">
		<h2>
			<a href="/partners/show?key=${f:h(partner.id)}"
				title="Go to partner's home"> ${f:h(partner.name)}</a>
		</h2>
			${f:h(partner.description)} <br>
		<br>
	</c:forEach>
</body>
</html>
