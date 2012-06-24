<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp" >
<jsp:param name="pageName" value="results Show"/>
</jsp:include>

	<c:forEach var="result" items="${projectResults}">
	    ${f:h(result.overview)}  
	    <br> <br>
    </c:forEach>

<jsp:include page="/common/footer.jsp" />

