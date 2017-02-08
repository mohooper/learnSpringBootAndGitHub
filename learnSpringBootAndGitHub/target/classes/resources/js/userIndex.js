var userIndex = {} || userIndex;
$(function(){
	
	
	//下拉选择功能
    $(".search_area").find(".roll_select .dropdown_switch").click(function(event){
		event.stopPropagation();
		$(".roll_list").hide();
		$(this).next().show();
		
	});
	 $(".search_area").undelegate(".roll_list li","click").delegate(".roll_list li","click",function(){
		var $txt=$(this).html();
		var cid = $(this).attr("data");
		$(this).parents(".roll_select").find(".jsBtLabel").html($txt).attr("data",cid);
		$(".roll_list").hide();
	});
	 
	 
	
	var $userLS = $(".userLS");
	var $userLS_tbody = $userLS.find(".userLS_tbody");
	userIndex.userList = function(pageIndex){
		var userName = $userLS.find("input[name='userName']").val();
		var userMobile = $userLS.find("input[name='userMobile']").val();
		var userAddress = $userLS.find("input[name='userAddress']").val();
		var userGender = $userLS.find(".userGender .jsBtLabel").attr("data");
		base.loadingShow("加载中...");
		$.ajax({
		    url :   "/user/list",
		    dataType : "json", 
		    data:{userName:userName,userMobile:userMobile,userAddress:userAddress,userGender:userGender},
		    type : "post"
	    }).done(function(data) {
	    	base.loadingHide();
	    	if(data.isSuc=='1'){
	    		if (data.rows != "") {
	    			$userLS_tbody.html($("#_tpl_userLS_tbody").tmpl(data));
	    		}else{
	    			$userLS_tbody.html("<tr><td colspan='9'><div class='alignCenter'>~暂无相关数据~</div></td></tr>");
	    		}
	    	}else{
	    	    base.fail("出错了");	
	    	}

	    	$(".userLs input.chAll").prop("checked",false);
	    	setuserTableHeight();
	    });
		
	};
	
	userIndex.userList(1);
	
	//直接按回车执行查询操作
	document.onkeydown = function(event){
		  
		  $(".userLs .userGender").blur();
	        ev = event ? event :(window.event ? window.event : null); 
	            if(ev.keyCode ==13) {
			    	userIndex.userList(1);
	            }
	    };  
	
	$(".userLS .userLS_query").click(function(){
		userIndex.userList(1);
	});
	
	$userLS.undelegate("input.chAll","change").delegate("input.chAll","change",function(){
		var $this = $(this);
		$(".userLS_tbody input.ch").prop("checked",$this.prop("checked"));
		
	});
	$userLS.undelegate("input.ch","change").delegate("input.ch","change",function(){
		var allNum = $userLS.find("input.ch").length;
		var snum = $userLS.find("input.ch:checked").length;
		if(allNum>0 && allNum==snum){
			$(".userLs input.chAll").prop("checked",true);
		}else{
			$(".userLs input.chAll").prop("checked",false);
		}
	});
	
	
	var $userAE = $(".userAE");
	//新增用户
	$(".userLs .addUser").click(function(){
		$userAE.find("input[name='name']").val("");
		$userAE.find("input[name='mobile']").val("");
		$userAE.find("input[name='address']").val("");
		$userAE.find("input[name='code']").val("");
		$userAE.find("input[name='remark']").val("");
		
		$userAE.find("input[name='userId']").val("");
	    $(".shadow_outer,.userAE").show();
	});
	
	
	//编辑用户
	$(".userLs .editUser").click(function(){
		var selectlist = new Array();
		var selectrow = null;
		$(".userLs .userLs_tbody").find(".ch:checked").each(function(){
			selectlist.push($(this).attr("sid"));
			selectrow = $(this).closest("tr");
		})
		if(selectlist.length==0){
			base.fail("请先选择用户");
			return;
		}
		if(selectlist.length>1){
			base.fail("请选择一个用户");
			return;
		}
		
		$userAE.find("input[name='name']").val(selectrow.find("td").eq(2).text());
		$userAE.find("input[name='mobile']").val(selectrow.find("td").eq(5).text());
		$userAE.find("input[name='address']").val(selectrow.find("td").eq(6).text());
		$userAE.find("input[name='code']").val(selectrow.find("td").eq(3).text());
		$userAE.find("input[name='remark']").val(selectrow.find("td").eq(7).text());
		$userAE.find("input[name='remark']").val(selectrow.find("td").eq(7).text());
		
		$userAE.find("input[name='userId']").val(selectrow.find("td").eq(0).attr("uid"));
		var gender = selectrow.find("td").eq(4).attr("gender");
		if(gender=='1'||gender==1){
		
		}else{
			$userAE.find("input[name='gender']").eq(1).prop("checked",true);
		}
		
		$(".shadow_outer,.userAE").show();
		
		
	});
	
	
	//编辑新增保存
	$userAE.undelegate(".sure_submit_data","click").delegate(".sure_submit_data","click",function(){
		var validate = true;
		
		var name = $userAE.find("input[name='name']").val();
		if(name.trim()==''){
			$userAE.find(".e_shname").css("display","inline-block");
			validate = false;
		}else{
			$userAE.find(".e_shname").hide();
		}
		var mobile = $userAE.find("input[name='mobile']").val();
		if(mobile.trim()==''){
			$userAE.find(".e_mobile").css("display","inline-block");
			validate = false;
		}else{
			$userAE.find(".e_mobile").hide();
		}
		if(!validate)return;
		
		
		base.loadingShow("保存中...");
		$.ajax({
		    url :   "/user/save",
		    dataType : "json", 
		    data:{userName:name,userMobile:mobile,userAddress:$userAE.find("input[name='address']").val(),
		    	userGender:$userAE.find("input[name='gender']:checked").val(),userCode:$userAE.find("input[name='code']").val(),
		    	userRemark:$userAE.find("input[name='remark']").val(),id:$userAE.find("input[name='userId']").val()},
		    type : "post"
	    }).done(function(data) {
	    	base.loadingHide();
	    	if(data.isSuc=='1'){
	    		base.suc("保存成功");
	    		$(".shadow_outer,.userAE").hide();
	    		userIndex.userList(1);
	    	}else{
	    	    base.fail("出错了");	
	    	}

	    });
		
	
	});
	
	//删除用户
	$(".userLs .delUser").click(function(){
		var selectlist = new Array();
		$(".userLs .userLs_tbody").find(".ch:checked").each(function(){
			selectlist.push($(this).attr("uid"));
		})
		if(selectlist.length==0){
			base.fail("请先选择用户");
			return;
		}
		
		$(".unite_dialog_to_sure").attr("ids",selectlist.toString());
		$(".shadow_outer,.unite_dialog_to_sure").show();
		
		
	});
	
	$(".unite_dialog_to_sure .sure_btn").click(function(){
		
		var ids = $(".unite_dialog_to_sure").attr("ids");
		
		base.loadingShow("处理中...");
		$.ajax({
		    url :   "/user/del",
		    dataType : "json", 
		    data:{ids:ids},
		    type : "post"
	    }).done(function(data) {
	    	base.loadingHide();
	    	if(data.isSuc=='1'){
	    		base.suc("删除成功");
	    		$(".shadow_outer,.unite_dialog_to_sure").hide();
	    		userIndex.userList(1);
	    	}else{
	    	    base.fail("出错了");	
	    	}

	    });
		
	});
	
});