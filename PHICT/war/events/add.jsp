<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/add.css" />
<title>events Add</title>
</head>
<body>
    <form name="addEvent" action="new" method="POST">
        <div class="add">
            <h3>Add a new event </h3>
            
            <div class="formRow">
		        Project:
		        <select name="project">
		            <c:forEach var="project" items="${projects}">
		                <option value="${f:h(project.id)}">${f:h(project.name)}</option>
		            </c:forEach>
		        </select>
	        </div>
	        
	        <div class="formRow"> Presentation: <input name="presentation" type="text" /> </div>
	        
	        <input type="submit" value="Submit" />
        </div>
    </form>
</body>
</html>
