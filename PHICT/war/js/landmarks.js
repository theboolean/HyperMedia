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