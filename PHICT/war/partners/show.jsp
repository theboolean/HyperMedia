<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<title>partners Show</title>
</head>
<body>
	<h1>${f:h(partner.name)}</h1>
	${f:h(partner.description)}
	<br />
	<br /> Semantic links:
	<br />

	<a href="/researchers/show?partner=${f:h(partnerKey)}"
		title="Researchers of this partner">Researchers</a>
	<br />
	<a href="/projects/show?partner=${f:h(partnerKey)}"
		title="Projects of this partner">Projects</a>
</body>
</html>
