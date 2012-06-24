<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp" >
<jsp:param name="pageName" value="Error"/>
</jsp:include>

    <c:forEach var="error" items="${messages}">
        ${f:h(error)} <br>
    </c:forEach>

<jsp:include page="/common/footer.jsp" />

