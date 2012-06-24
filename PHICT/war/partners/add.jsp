<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/add.css" />
<title>partners Add</title>
</head>
<body>
    <form name="addPartner" action="new" method="POST">
    	<div class="add">
    	<center>Add a new partner <br /><br /></center>
	Project:
	        <select name="project" class="addtxt">
	            <c:forEach var="project" items="${projects}">
	                <option value="${f:h(project.id)}">${f:h(project.name)}</option>
	            </c:forEach>
	        </select> <br /><br />
	        Name: <input name="name" class="addtxt" type="text" /> <br /><br />
	        Description: <input name="description" class="addtxt" type="text" /> <br /><br />

	        <input type="submit" value="Submit" />    	</div>
    </form>
</body>
</html>