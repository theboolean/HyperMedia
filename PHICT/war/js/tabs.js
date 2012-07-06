function makeTabs() {
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
}