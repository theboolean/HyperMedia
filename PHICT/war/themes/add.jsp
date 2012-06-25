<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/add.css" />
<title>themes Add</title>
</head>
<body>
    <form name="addTheme" action="new" method="POST">
        <div class="add">
            <h3>Add a new theme </h3>
            
	        <div class="formRow"> Name: <input name="name" type="text" /> </div>
	        <div class="formRow"> Description: <br/> <textarea name="description"></textarea> </div>
	        
	        <input type="submit" value="Submit" />
        </div>
    </form>
</body>
</html>
