<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/add.css" />
<title>result Add</title>
</head>
<body>
    <form name="addResult" action="new" method="POST">
        <div class="add">
            <center>Add a new result <br /><br /></center>
	        Activity:
	        <select name="activity" class="addtxt">
	            <c:forEach var="activity" items="${activities}">
	                <option value="${f:h(activity.id)}">${f:h(activity.goals)}</option>
	            </c:forEach>
	        </select> <br /><br />
	        
	        Overview: <input name="overview" class="addtxt" type="text" /> <br /><br />
	        
	        Important:  
	        <div class = "addRadio">
	        <input type="radio" name="important" value="true"> yes
			<input type="radio" name="important" value="false" checked> no<br>
	        </div>
	        <br /><br />
	        <input type="submit" value="Submit" />
        </div>
    </form>
</body>
</html>
