var base = {} || base;
	
	base.suc =function(msg,time){
		var $tip = $(".unite_tip");
		$tip.removeClass("tip_error").addClass("tip_suc");
		$tip.find("span").html(msg);
		$tip.show();
		var t = 1500;
		if(time)t = time;
		setTimeout(function(){
			$tip.hide();
		},t);
	};
	base.fail =function(msg,time){
		var $tip = $(".unite_tip");
		$tip.removeClass("tip_suc").addClass("tip_error");
		$tip.find("span").html(msg);
		$tip.show();
		var t = 1500;
		if(time)t = time;
		setTimeout(function(){
			$tip.hide();
		},t);
	};
	base.loadingShow =function(msg){
		var $tip = $(".tip_loading");
		$tip.find("span").html(msg);
		$tip.show();
	};
	base.loadingHide =function(){
		var $tip = $(".tip_loading");
		$tip.hide();
	};
	
	
