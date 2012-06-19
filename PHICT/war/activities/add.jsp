<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>activities Add</title>
</head>
<body>
    <form name="addActivity" action="new" method="POST">
        Project:
        <select name="project">
            <c:forEach var="project" items="${projects}">
                <option value="${f:h(project.id)}">${f:h(project.name)}</option>
            </c:forEach>
        </select> <br />
        
        Schedule: <input name="schedule" type="text" /> <br />
        Goals: <input name="goals" type="text" /> <br />
        
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
