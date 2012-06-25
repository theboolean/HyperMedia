<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/add.css" />
<title>projects Add</title>
</head>
<body>
    <form name="addProject" action="new" method="POST">
    	<div class="add">
    		<h3> Add a new project </h3>
	        <div class="formRow">
	        	Name: <input name="name" type="text" />
	        </div>
	        <div class="formRow">
	        	Description: <br/> <textarea name="description"></textarea>
	        </div>
	        <div class="formRow">
	        	Main Goals: <br/> <textarea name="mainGoals"></textarea>
	        </div>
	        <div class="formRow">
	        	Public Documentation (optional): <br/> <textarea name="publicDocumentation"></textarea>
	        </div>
	        <div class="formRow">
	        	Theme:
		        <select name="theme">
		            <c:forEach var="theme" items="${themes}">
		                <option value="${f:h(theme.id)}">${f:h(theme.name)}</option>
		            </c:forEach>
		        </select>
	        </div>
	        
	        <input type="submit" value="Add" />
    	</div>
    </form>
</body>
</html>