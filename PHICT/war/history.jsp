<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="History" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="content">
			<p> Here you can browse all our projects that have been already completed. </p>
			<c:forEach var="project" items="${projects}">
				<div class="project">
					<h2> 
						<a href="/projects/show?key=${f:h(project.id)}"  title="Go to project's home"> 
							${f:h(project.name)} 
					    </a> 
					    (${ project.startYear } - ${ project.endYear })
					</h2>
	 	  			${ project.description }
	  	  		</div>
			</c:forEach>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />
