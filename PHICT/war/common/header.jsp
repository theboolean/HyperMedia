<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <script type="text/javascript" src="/js/jquery-1.7.2.min.js"> </script>
    <title><%= request.getParameter("pageName")%></title>
    
    <script type="text/javascript">
    $(function() {
        var landmarks = $("#landmarks li");
        var slideshowCounter = 0;
        var slideshowSize = landmarks.size();
        
        var illustration = $("#sponsor .illustration");
        var description = $("#sponsor .description");
        var sponsorContent = $("#sponsor *");
        
        var firstInvocationTime = (new Date()).getTime();
        var hovering = false;
        var defaultTimeout = 7000;
        
        // Transition function invoked when the slideshow needs to be changed 
        var transition = function(index) {
        	// If no index if supplied, the current index is incremented by 1 
        	if (index < 0) {
        		// But only if a proper time span has elapsed since the last invocation and the 
        		// mouse is not hovering any slideshow link 
        		var currentTime = (new Date()).getTime();
        		if ((currentTime - firstInvocationTime < defaultTimeout) || hovering) return;
        		firstInvocationTime = currentTime;
            	slideshowCounter = (slideshowCounter + 1) % slideshowSize;	 
        	} else {
        		// Otherwise, take the specified index 
        		slideshowCounter = index; 
        	}
        	
        	// Contains the target link to be displayed 
            var target = $(landmarks.get(slideshowCounter));
            
        	// If the current image equals the image related to target, then there's not need to change 
            if (illustration.attr("src") == target.find(".illustration").attr("src")) {
                return 0;
            }

        	// Otherwise, renders all slideshow links normally 
        	landmarks.each(function() { $(this).removeClass("selected"); });
        	// Selected target 
        	target.addClass("selected");
        	// And displays an image and a description related to target 
            sponsorContent.fadeOut(function() {
                illustration.attr("src", target.find(".illustration").attr("src"));
                description.text(target.find(".description").text());
                sponsorContent.fadeIn();
            });
        };
        
        // Creates a timer that forces slideshow transition every X milliseconds 
        var timer = setInterval(function() { transition(-1); }, defaultTimeout);
        
        // The slideshow can be halted by hovering on any link 
        landmarks
        	.mouseenter(function() {
        		hovering = true;
	        	clearInterval(timer);
	        	timer = "";
	        	transition($(this).index());
	        })
	        .mouseout(function() {
	        	hovering = false;
	        	timer = setInterval(function() { transition(-1); }, defaultTimeout);
	        });
    });
    </script>
</head>

<body>
    <img class="background" src="/images/background_grey.png" />
    
    <div id="header">
        <div id="title">  
            <span class="mainTitle">
            	<a href="/"><span class="whiteOnShadow">PHICT</span> <span class="blackOnShadow">Program</span></a> 
         	</span> 
         	<span class="slogan"> An european funded international program for ICT enrichment. </span>    
        </div>
        
        <div id="landmarks">
            <ul>
                <li class="selected"> 
                    <a href="/europe">EU Commission</a>
                    <span class="description"> The european commission has invested over 2.45 billion euros in the PHICT program and is currently helping in the development of major projects that will improve our quality of life. Learn more about the commission and its objectives in this section. </span>
                    <img class="illustration" src="/images/eu_flag_small.jpg" />
                </li>
                <li>
                    <a href="/results"> Program Results</a>
                    <span class="description"> The PHICT program has been operative since the end of 2011 and a few projects begun to show significant results. This section outlines the main trends of the program.</span>
                    <img class="illustration" src="/images/ict_small.jpg" />
                </li>
                <li>
                    <a href="/partners/">Partners</a>
                    <span class="description"> Our partners are universities and companies spread across the european territory. </span>
                    <img class="illustration" src="/images/academy_small.jpg" />
                </li>
                <li>
                    <a href="/themes/">Projects</a>
                    <span class="description"> The project area covers a wide range of topics, from robotics to networks, from biotechnology to cryptography, etc... Here you can browse all the main topics of research.</span>
                    <img class="illustration" src="/images/technology_small.jpg" />
                </li>
                <li>
                    <a href="/history" class="last">History</a>
                    <span class="description"> Here you can find the list of all completed projects, along with all published documents, involved researchers, partners and events of the past year. </span>
                    <img class="illustration" src="/images/trend_small.jpg" />
                </li>
            </ul>
        </div>
        
        <div id="sponsor">
            <img class="illustration"  src="/images/eu_flag_small.jpg" />
            <span class="description">The european commission has invested over 2.45 billion euros in the PHICT program and is currently helping in the development of major projects that will improve our quality of life. Learn more about the commission and its objectives in this section. </span>
        </div>
    </div>