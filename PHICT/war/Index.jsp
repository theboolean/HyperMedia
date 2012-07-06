<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="Index" />
</jsp:include>

<script type="text/javascript" src="/js/tabs.js"></script>
<script type="text/javascript">
$(function() {
	makeTabs();
});
</script>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="content">
			<div class="tabContent">
		        <h2>A promise for the future</h2>
		        <div class="tabChanger">
		            Change tab: 
		            <a href="initiativeDescription" title="A promise for the future">Description</a>, 
                    <a href="rules" title="Rules">Rules</a>, 
                    <a href="submissionInfo" title="Submission Info">Submission Info</a>
                </div>
                
                <div class="tab initiativeDescription">
                    Over the last decade, the European Commission has developed a particular sensibility to
					the problems of research. Some of the most recent measures have been targeted to the digitalization
					of paper documents and the speeding up of some slow law processes. Although these measures
					aren't actually applied by all european members, the commission is encouraging the switch to 
					modern means of communication.  This is only a small example that exeplains the emerging 
					interest in technology. <br/>
					There are many important research themes that offer a lot of still open problems, whose
					solutions would significantly increase our knowledge and thus allow us to build better, faster
					and more powerful devices. Moreover, there is a raising interest in ecology and sustainability. <br/>
					For these reasons, some of the members of the European Commission have proposed to embark into this
					project and their ideas have had a general and genuine consensus. We are working for our future.
					<br/> <br/>
					<img class="center" src="/images/eu_commission_hq.jpg" />
					<br/>
                </div>
                <div class="tab rules" style="display: none;">
                    If you want to know admission rules, see "Submission Info" section. <br/>
                    For every project enrolled into the program, the EU Commission provides a list of simple rules to
                    follow in order to coordinate well. Here is a hint of these rules, whilst the complete specifications
                    are available for download in pdf format.
                    <ul>
                    	<li> Once enrolled into the program, the team must provide full documentation of the experiment
                    	within one week. The documentation must contain: a comprehensive description of all procedures
                    	that are to be executed in order to obtain a result, a list of every asset involved into the
                    	process (specifing also the quantity and price for each of them), a list of all members of the
                    	team (including roles within the project and at least two different contacts).</li>
                    	<li> In addition, every involved partner will be required to provide a document of every
                    	external asset and collaborator. </li>
                    	<li> The team must complete the entire work within any specified terms that the commission
                    	has agreed upon. On expiration of this term, the commission won't provide further financial
                    	aid any more, until the team enrolls for another project. The maximum expiration date can be
                    	exceeded by no more than 2 weeks. </li>
                    	<li> For those teams occupying european funded facilities, it will be required to move out
                    	of the laboratory at least one week before the expiration term. </li>
                    	<li> In order to be examined by the european scientific consulting team, any funding request
                    	must be previously approved by at least 51% of the team members. </li>
                    </ul>
                    For further details, please, download and read the following <b>document</b>.
                </div>
                <div class="tab submissionInfo" style="display: none;">
                    You can participate simply posting your project proposals to us. A team will evaluate the proposal and will
					inform you if the proposal appears to be good.
					Proposal are published in the Official Journal of the European Union.  With your proposal you must provide, 
					in addition to the description of the thematic areas, topics or research objectives, calls comprise information
					on the following items:
					<ul>
						<li> Closure date(s) </li>
					  	<li> Indicative budget and its distribution per area and/or instrument </li>
						<li> Minimum number of participants </li>
						<li> One-stage or two-stage submission and evaluation procedure </li>
						<li> Non-standard evaluation criteria </li>
						<li> Indicative delays for evaluation and selection of proposals </li>
					</ul>
                </div>
		    </div>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />
