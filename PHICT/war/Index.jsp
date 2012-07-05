<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<jsp:include page="/common/header.jsp">
	<jsp:param name="pageName" value="Index" />
</jsp:include>

<div id="mainContainer">
	<div id="innerContainer">
		<div id="content">
			<p>
				<h2>A promise for the future</h2>
				Over the last decade, the European Commission has developed a particular sensibility to
				the problems of research. Some of the most recent measures have been targeted to the digitalization
				of paper documents and the speeding up of some slow law processes. Although these measures
				aren't actually applied by all european members, the commission is encouraging the switch to 
				modern means of communication.  This is only a small example that exeplains the emerging 
				interest in technology. <br/>
				There are many important research themes that offer a lot of still open problems, whose
				solutions would significantly increase our knowledge and thus allow us to build better, faster
				and more powerful devices. Moreover, there is a raising interest in ecology and sustainability.
				
			</p>
		</div>
	</div>
</div>

<jsp:include page="/common/footer.jsp" />
