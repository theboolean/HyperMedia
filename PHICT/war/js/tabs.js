function makeTabs() {
	$(".tabChanger a").click(function(e) {
        e.preventDefault(); // Prevents the default link-click behavior from sending a page request
        
		var tabName = $(this).attr("href");
		var tabTitle = $(this).attr("title");
		
		$(".tabContent").fadeOut(500, function() {
			$(this).find("h2").text(tabTitle); // Changes paragraph title
			$(this).find(".tab").css("display", "none"); // Hides other tabs
			$(this).find("." + tabName).css("display", "block"); // Displays tab content
			$(this).fadeIn(); // Shows everything
		});
		
	});
}