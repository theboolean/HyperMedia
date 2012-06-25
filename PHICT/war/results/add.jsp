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
            <h3>Add a new result </h3>
            
            <div class="formRow">
		        Activity:
		        <select name="activity">
		            <c:forEach var="activity" items="${activities}">
		                <option value="${f:h(activity.id)}">${f:h(activity.goals)}</option>
		            </c:forEach>
		        </select>
	        </div>
	        
	        <div class="formRow"> Overview: <input name="overview" type="text" /> </div>
	        
	        <div class="formRow">
		        Important: <br/>
		        <input type="radio" name="important" value="true" /> <label>Yes</label> <br/>
				<input type="radio" name="important" value="false" checked> <label>No</label>
			</div>
			
	        <input type="submit" value="Submit" />
        </div>
    </form>
</body>
</html>
