<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="../common/header.jsp">
	<jsp:param name="pageName" value="project Show" />
</jsp:include>

<script type="text/javascript">
$(function(){
	$(".tabChanger a").click(function(e) {
        e.preventDefault();
        
		var tabName = $(this).attr("href");
		var tabTitle = $(this).attr("title");
		
		$(".tabContent").fadeOut(500, function() {
			$(this).find("h2").text(tabTitle);
			$(this).find(".tab").css("display", "none");
			$(this).find("." + tabName).css("display", "block");
			$(this).fadeIn();
		});
		
	});
})
</script>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<a href="/themes/show?key=${f:h(theme.id)}">${f:h(theme.name)}</a> &nbsp; &gt; &nbsp; ${f:h(project.name)}
		</div>

		<div id="content">
		    <div class="postit">
		        Related content:
		        <ul>
		            <li> <a href="/activities/show?project=${f:h(projectKey)}" title="Activities for this project">Activities</a> </li>
		            <li> <a href="/events/show?project=${f:h(projectKey)}" title="Events for this project">Events</a> </li> 
		            <li> <a href="/partners/show?project=${f:h(projectKey)}" title="Partners involved in this project">Partners</a> </li>
		            <li> Important Results </li>
                </ul>
		    </div>

		    <div class="tabContent">
		        <h2>Description</h2>
		        <div class="tabChanger">
		            Change tab: 
		            <a href="projectDescription" title="Description">Description</a>, 
                    <a href="mainGoals" title="Main Goals">Main Goals</a>, 
                    <a href="publicDocumentation" title="Public Documentation">Public Documentation</a>
                </div>
                
                <div class="tab projectDescription">
                    ${ project.description }
                </div>
                <div class="tab mainGoals" style="display: none;">
                    ${ project.mainGoals }
                </div>
                <div class="tab publicDocumentation" style="display: none;">
                    ${ project.publicDocumentation }
                </div>
		    </div>
		    
		    
			<div class="clear"></div>
		</div>
	</div>
</div>

<jsp:include page="../common/footer.jsp" />

