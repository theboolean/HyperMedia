<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>projects Add</title>
</head>
<body>
    <form name="addProject" action="new" method="POST">
        Name: <input name="name" type="text" /> <br>
        Description: <input name="description" type="text" /> <br>
        Main Goals: <input name="mainGoals" type="text" /> <br>
        <input type="submit" value="Add" />
    </form>
</body>
</html>
