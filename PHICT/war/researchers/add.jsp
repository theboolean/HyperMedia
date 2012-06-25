<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/add.css" />
<title>researcher Add</title>
</head>
<body>
    <form name="addResearcher" action="new" method="POST">
        <div class="add">
            <h3>Add a new researcher </h3>
            
            <div class="formRow">
		        Partner:
		        <select name="partner">
		            <c:forEach var="partner" items="${partners}">
		                <option value="${f:h(partner.id)}">${f:h(partner.name)}</option>
		            </c:forEach>
		        </select>
	        </div>
	        
	        <div class="formRow"> Name: <input name="name" type="text" /> </div>
	        
	        <div class="formRow"> Surname: <input name="surname" type="text" /> </div>
	        
	        <div class="formRow"> Curriculum: <textarea name="curriculum"></textarea> </div>
	        
	        <input type="submit" value="Submit" />
        </div>
    </form>
</body>
</html>
