<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="activity Show" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="breadcrumbs">
			<a href="/themes/show?key=${f:h(projectTheme.id)}">${f:h(projectTheme.name)}</a> &nbsp; &gt; &nbsp; 
			<a href="/projects/show?key=${f:h(projectKey)}">${f:h(project.name)}</a> &nbsp; &gt; &nbsp;
			Activities
		</div>

		<div id="content">
		    <div class="postit">
                Related content:
                <ul>
                    <li> <a href="/results/show?activity=${f:h(activity.id)}" title="Results of this activity">Results</a> </li>
                    <li> <a href="/projects/show?key=${f:h(projectKey)}" title="Project of this activity">Related Project</a> </li>
                </ul>
            </div>
			<p>
			    <h2>Schedule</h2>
				${ activity.schedule }
			</p>
			
			<p>
			    <h2>Goals</h2>
			    ${ activity.goals }
			</p>
			
			<div class="clear"></div>
			
			<div id="navigation">
			<a href="/activities/previous?project=${f:h(projectKey)}&key=${f:h(activity.id)}">Previous Activity</a> &nbsp; | &nbsp; 
			<a href="/activities/show?project=${f:h(projectKey)}">All Activity</a> &nbsp; | &nbsp; 
			<a href="/activities/next?project=${f:h(projectKey)}&key=${f:h(activity.id)}">Next Activity</a>
		</div>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />

