<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<title>activity Show</title>
</head>
<body>
	<c:forEach var="activity" items="${projectActivities}">
	    ${f:h(activity.goals)}  
	    ${f:h(activity.schedule)}  
	    <br> <br>
    </c:forEach>
</body>
</html>
