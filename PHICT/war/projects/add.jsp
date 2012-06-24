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
    	<center>Add a new project <br /><br /></center>
	        Name: <input name="name" class="addtxt" type="text" /> <br /><br />
	        Description: <input name="description" class="addtxt" type="text" /> <br /><br />
	        Main Goals: <input name="mainGoals" class="addtxt" type="text" /> <br /><br />
	        <input type="submit" value="Add" />
    	</div>
    </form>
</body>
</html>