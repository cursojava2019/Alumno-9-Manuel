$(document).ready(function(){
	$("#nav > li").eq(2).mouseover(function(){
	    var $p=$("#nav > li").eq(2).children();
		$p.parent().addClass("hover");
		$p.addClass("submenu");
		$p.show("slow");	
	});
		
	$("#nav > li").eq(1).mouseover(function(){
	    var $p=$("#nav > li").eq(2).children();
		$p.parent().removeClass("hover");
		$p.removeClass("submenu");
		$p.hide();
	});       

	$("#nav > li").eq(0).mouseover(function(){
	    var $p=$("#nav > li").eq(2).children();
		$p.parent().removeClass("hover");
		$p.removeClass("submenu");
		$p.hide();
	});
});