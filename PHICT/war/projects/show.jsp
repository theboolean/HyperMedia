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
    <h1> ${f:h(project.name)} </h1>
    ${f:h(project.description)}
    
    <br />
    <br />
    Semantic links: <br />
    
    <a href="/activities/show?project=${f:h(projectKey)}" title="Activities for this project">Activities</a>
</body>
</html>
