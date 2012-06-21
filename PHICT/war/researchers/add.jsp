<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<title>researcher Add</title>
</head>
<body>
    <form name="addResearcher" action="new" method="POST">
        <div class="add">
            <center>Add a new researcher <br /><br /></center>
	        Partner:
	        <select name="partner" class="addtxt">
	            <c:forEach var="partner" items="${partners}">
	                <option value="${f:h(partner.id)}">${f:h(partner.description)}</option>
	            </c:forEach>
	           <-- TODO se aggiungaimo partners.name modificare qui sopra description in name -->
	        </select> <br /><br />
	        
	        Curriculum: <input name="curriculum" class="addtxt" type="text" /> <br /><br />
	        
	        <input type="submit" value="Submit" />
        </div>
    </form>
</body>
</html>
