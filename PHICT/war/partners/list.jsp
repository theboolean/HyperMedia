<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="../common/header.jsp">
	<jsp:param name="pageName" value="partners Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<c:choose> 
                <c:when test="${project != null}"> 
                	<div id="breadcrumbs">
                    	<a href="/themes/show?key=${f:h(projectTheme.id)}">${f:h(projectTheme.name)}</a> &nbsp; &gt; &nbsp; 
                    	<a href="/projects/show?key=${f:h(project.id)}">${f:h(project.name)}</a> &nbsp; &gt; &nbsp; 
                    	Involved partners
                    </div> 
                </c:when>
        </c:choose>
		
		<div id="content">
			<c:choose> 
			    <c:when test="${project == null}"> 
			        <p> This is a complete list of all our affiliates. You can find academic institutions and
			        organizations supporting the program with their solid contributions:</p>
		        </c:when> 
			    <c:otherwise> 
			        <p> The <i>${f:h(project.name)}</i> project is powered by researchers belonging to those institutions:</p>
			    </c:otherwise> 
			</c:choose>
			
			<c:if test="${ empty projectPartners }">
				<p> <i> Sorry, there aren't any partners listed in this section! </i> </p>
			</c:if>
			
			<c:forEach var="partner" items="${projectPartners}">
			    <div class="project">
					<h2> <a href="/partners/show?key=${f:h(partner.id)}" title="Go to partner's home"> ${f:h(partner.name)}</a> </h2>
		 	  		${ partner.description }
	  	  		</div>
			</c:forEach>
		</div>
	</div>
</div>

<jsp:include page="../common/footer.jsp" />

