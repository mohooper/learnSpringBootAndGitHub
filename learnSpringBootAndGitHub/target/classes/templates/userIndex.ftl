
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/jquery.tmpl.js"></script>
<script type="text/javascript" src="js/userIndex.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<style type="text/css">
body,h1,h2,h3,h4,h5,h6,hr,p,blockquote,dl,dt,dd,ul,ol,li,pre,form,fieldset,legend,button,input,textarea,th,td,iframe
	{margin: 0;padding: 0;vertical-align: baseline;}
.clearfix:before,.clearfix:after {content: '';display: table}
.clearfix:after {clear: both;overflow: hidden}
.clearfix {zoom: 1}
input,select,button,h1,h2,h3,h4,h5,h6 {font-family: inherit;font-size: 100%;}
table {border-collapse: collapse;border-spacing: 0;}
a {color: #333;text-decoration: none;}
a:hover{cursor: pointer;}
a,img,button,input,select {outline: 0 none;}
img {border: 0 none;vertical-align: top;}
i,em {font-style: normal;}
input:focus,textarea:focus{box-shadow: 0 0 0 1px #007eff, 0 0 4px 0 #3d96e3;outline: none;}
body{color: #333;font-family:"Microsoft Yahei",verdana,Arial,sans-serif;font-size: 13px;line-height: 1.6;background: #fff;overflow: hidden;height: 100%;}
.search_area{font-size: 12px;background: #f8f8f8;padding-top: 10px;}
.table{font-size: 12px;}
.table th{border: 1px solid #e0e0e0;font-weight: normal;padding:0 10px;text-align: left;line-height: 33px;background: url(images/th_bg.png) repeat-x;}
.table_header{background: url(images/th_bg1.png) repeat-x;position: relative;overflow-x: hidden;}
.table td{padding:5px 10px;position: relative;border: 1px solid #e0e0e0;word-break: break-all;}
.table td a.ico_edit{background: url(images/ico_edit.png) no-repeat;width: 18px;height: 18px;position: absolute;right: 5px;top: 50%;margin-top: -9px;}
.table td a{color: #326bd2;display: inline-block;}
.table td a.mLeft20{margin-left: 10px;}
.table td a:hover{text-decoration: underline;}
.table tr:hover{background: #f3f3f3;}
.table tr.actived{background: #e5efff;}
.btn{line-height: 24px;display: inline-block;background: url(images/btn_bg.png) repeat-x;padding: 0 10px;border: 1px solid #a9a9a9;border-radius: 3px;color: #666666;vertical-align: middle;}
.btn:hover,.btn.on{background: url(images/btn_hover_bg.png) repeat-x;}
.btn.disabled{color: #ccc;border-color: #ccc;cursor: default;}
.btn.disabled:hover{background: url(images/btn_bg.png) repeat-x;}
.cell input[type='text']{width: 140px;height: 24px;border: 1px solid #e0e0e0;padding: 0 10px;vertical-align: middle;}
.cell input[type='checkbox']{vertical-align: 0px;margin-right: 3px;}
.search_content{padding: 0px 15px;}
.search_fold_btn{height: 1px;background: #9ea7b6;position: relative;margin: 5px 15px 0;}
.search_fold_btn a{background: #f8f8f8;position: absolute;right: 0;top:-10px;line-height: 20px;}
.search_fold_btn a:hover{color: #ff6e07;}
.search_fold_btn b{display: inline-block;vertical-align: 1px;width: 12px;height: 7px;position: relative;margin: 0 6px 0 8px;background: url(images/search_arrow_top.png) no-repeat;}
.search_fold_btn a.on b{background: url(images/search_arrow_down.png) no-repeat;}
.search_fold_btn a:hover b{background: url(images/search_arrow_top_on.png) no-repeat;}
.search_fold_btn a.on:hover b{background: url(images/search_arrow_down_on.png) no-repeat;}
.cell{float: left;margin-bottom: 10px;line-height: 24px;height: 24px;margin-right: 25px;}
.cell_btn{margin-right: 0;}
.cell span{display: inline-block;text-align: right;}
.roll_select{position: relative;  width: 160px; display: inline-block; vertical-align: middle;border: 1px solid #e0e0e0;}
.dropdown_switch {background-color: #fff;  border-color: #e6e7ec;color: #222;display: block; height: 24px; line-height: 24px; position: relative;  text-align: left; width: auto;}
.dropdown_switch label {cursor: pointer; display: block;margin-left: 10px;  margin-right: 20px;  overflow: hidden;  overflow-wrap: normal;  white-space: nowrap;width: auto; word-break: normal;}
.dropdown_switch .arrow {border-color: #c6c6c6 transparent transparent; border-style: solid dashed dashed;
    border-width: 5px 5px 0;display: inline-block;  height: 0; margin-top: -2.5px; position: absolute; right: 5px; top: 50%;width: 0;}
.roll_list{position: absolute;top: 25px;left: -1px;border: 1px solid #e2e2e2;border-top: none;width: 100%;background: #fff;display: none;z-index: 9;overflow: auto;max-height: 260px;}
.roll_list li{line-height: 26px;text-align: left;cursor: pointer;}
.roll_list li a:hover{background: #f0f0f0;}
.roll_list li a{display: block;padding: 0 10px;white-space: nowrap;overflow: hidden;}
.side_opert a{margin-right: 10px;float: left;}
.side_opert{padding:10px 15px;overflow: hidden;}
.page_fixed{background: #f3f3f3;border-top:1px solid #e0e0e0;line-height: 49px;position: absolute;bottom: 0;left: 0;width: 100%;}
.page span{padding: 0 10px;}
.table_content{overflow: auto;margin-top: -1px;}
li.line{margin: 0 15px;height: 1px;background: #3f4c61;}

.tip{display: none;width: 110px;height: 110px;background: #343f51;border-radius: 5px;position: fixed;z-index: 1001;top: 50%;left: 50%;margin: -55px 0 0 -55px;color: #fff;text-align: center;font-size: 14px;}
.tip i{display: block;width: 48px;height: 48px;margin: 17px auto 8px;}
.tip_error i{background: url(images/ico_tip_error.png) no-repeat;}
.tip_suc i{background: url(images/ico_tip_right.png) no-repeat;} 
.tip_loading i{background:url(images/loding.gif) no-repeat ;background-size:100% 100%;}
.edit_tip_mes{color: #bbb;margin-top: 4px;font-size: 12px;}


/*dialgo Beign*/
.shadow{position: fixed;width: 100%;height: 100%;z-index: 9;background: #000000;opacity: 0.5;filter:alpha(opacity=50);left: 0;top: 0;display: none;}
.model.dialog{width: 1014px;top: 50%;left: 50%;margin-left: -507px;z-index: 88;}
.footer_btn{position: absolute;right:10px;top: 0;}
.footer_btn a{margin-right: 10px;}
.dialog_footer{font-size: 12px;}
.dialog_header{height: 32px;border-bottom: 1px solid #e0e0e0;position: relative;background: url(images/dialog_header_bg.png) repeat-x;border-top-left-radius: 3px;border-top-right-radius: 3px;}
.dialog_header span{display: block;line-height: 32px;margin-left: 20px ;}
.dialog_header a{display: inline-block;width: 20px;height: 20px;position: absolute;right: 10px;top: 50%;margin-top: -10px;background: url(images/ico_close_btn.png) center center no-repeat;}
.dialog_header a:hover{background: url(images/ico_close_btn_hover.png) center center no-repeat;}
/*tip*/
.model{position: fixed;width: 600px;top: 50%;left: 50%;margin: -271px 0 0 -300px;z-index: 99;border-radius: 3px;overflow: hidden;padding-bottom: 37px;display: none;}
.dialog_content_add{height: 100%;}
.model .dialog_content,.dialog .dialog_content{height:472px ;overflow: auto;position: relative;background: #fff;}
.model .dialog_alert_footer{font-size: 12px;position: static;}
.model .dialog_alert_footer .btn{padding: 0 20px;}
/*alert*/
.dialog_alert{width: 400px;height: 208px;position: fixed;z-index: 888;left: 50%;top: 50%;margin: -104px 0 0 -200px;background: #fff;border-radius: 3px;display: none;}
.dialog_alert .dialog_content{height: 137px;}
.dialog_content_alert{padding: 48px;}
.dialog_content_alert h3{font-weight: normal;}
p.font-orange{color: #FF6E07;}
.dialog_alert_footer{position: absolute;left: 0;bottom: 0;width: 100%;background: #f3f3f3;border-top: 1px solid #e0e0e0;padding: 5px 0;border-bottom-left-radius: 3px;border-bottom-right-radius: 3px;}
.dialog_alert_footer div{float: right;}
.dialog_alert_footer div a{margin-right: 10px;}
.dialog_content_confirm input{border: 1px solid #e0e0e0;line-height: 26px;padding: 0 10px;}
.dialog_content_confirm{padding: 50px 45px;}
/*dialgo End*/
.edit{font-size: 12px;overflow: auto;height: 100%;background: #fff;}
.edit .editTable{width: 100%;}
.edit .editTable th{background: #eeeeee;text-align: left;padding: 4px 10px;vertical-align: middle;border: 1px solid #e0e0e0;line-height: inherit;font-weight: bold;}
.edit .editTable td{border: 1px solid #e0e0e0;padding: 7px 10px;vertical-align: middle;}
.edit .editTable em{color: #f00;}
.edit .editTable td textarea{border: 1px solid #e0e0e0;resize: none;}
.edit .editTable textarea{font-size: 12px;padding:5px 10px;height: 70px;}
.padding10{padding: 10px;}

.alignLeft{text-align: left;}
.alignRight{text-align: right;}
.alignCenter{text-align: center;}
.error_tip{color: #f00;display: inline-block;display: none;}



.userLS{width:1600px;margin-left: -800px;left:50%;position: fixed;margin-top:50px;}
</style>

<body>
<div class="userLS">
	<div class="search_area">
		 <div class="search_content clearfix">
			 <div class="cell">
			 	<span style="width: 91px;">用户姓名:</span>
			 	<input type="text" name="userName" placeholder="请输入用户姓名">
			 </div>
			 <div class="cell">
			 	<span style="width: 91px;">联系电话:</span>
			 	<input  type="text" name="userMobile" placeholder="请输入联系电话">
			 </div>
			 <div class="cell">
			 	<span style="width: 85px;">联系地址:</span>
			 	<input  type="text" name="userAddress"  placeholder="请输入用户地址">
			 </div>
			 <div class="cell">
			 	<span style="width: 85px;">性别：</span>
			 	<div class="roll_select userGender" style="display: inline-block;vertical-align: middle;">
					<a class="dropdown_switch">
						<label class="jsBtLabel" data="">全部</label>
						<i class="arrow"></i>
					</a>
					<div class="roll_list" style="display: none;">
						<ul>
							<li data=""><a>全部</a></li>
							<li data="1"><a>男</a></li>
							<li data="0"><a>女</a></li>
						</ul>
					</div>
				 </div>
			 </div>
			<div class="cell cell_btn"><a class="btn userLS_query">查询</a></div>
			
		</div>
		<div class="search_fold_btn">
			<a><b></b>筛选条件</a>
		</div>
		<div class="side_opert">
			<a class="btn addUser" >新增用户</a>
			<a class="btn editUser">编辑用户信息</a>
			<a class="btn delUser">删除用户</a> 
		</div>
	</div>
	
	<div class="table">
		<div class="table_header">
			<table border="1" bordercolor="#e0e0e0" width="100%">
				<tr>
				    <th style="width: 5%;" ><input type="checkbox" class="chAll"></input></th>
				    <th style="width: 5%;" >序号</th>
					<th style="width: 10%;"  class="sort" data="S.FULL_SPELL">用户姓名</th>
					<th style="width: 10%;">用户编号</th>
					<th style="width: 5%;">用户性别</th>
					<th style="width: 10%;">联系电话</th>
					<th style="width: 30%;">用户地址</th>
					<th style="width: 15%;">备注</th>
				</tr>
			</table>
		</div>
		<div class="table_content userLS_content">
			<table border="1" bordercolor="#e0e0e0" width="100%"  class="userLS_tbody">
			</table>
		</div>
		
		
		
	</div>
	
	
	<div class="model dialog userAE" style="display: none;">
		<div class="dialog_header">
			<span class="edit_add_title">新增用户</span><a title="关闭" onclick="$('.userAE,.shadow_outer').hide();" ></a>
		</div>
		<div class="dialog_content">
			<div class="dialog_content_userAE">
				<div class="edit">
				<div class="padding10">
					<table cellpadding="0" cellspacing="0" class="cell editTable" style="margin-bottom: 0;float: none;font-size: 12px;">
					    <input type="hidden" value="" name="userId"/>
						<tr>
							<th colspan="2">用户基础信息</th>
						</tr>
						<tr>
							<td class="alignRight"><em>*</em>用户姓名：</td><td><input type="text" placeholder="请输入用户姓名" name="name" />
							  <p class="error_tip e_shname">请填写用户姓名</p>
							</td>
						</tr>
						
						<tr>
							<td class="alignRight"><em>*</em>联系电话：</td><td><input type="text" placeholder="请输入联系电话" name="mobile" />
						     	<p class="error_tip e_mobile" >请正确填写终端联系电话</p>
							</td>
						</tr>
						
						<tr>
							<th colspan="2">其它信息</th>
						</tr>
						<tr>
							<td class="alignRight">性别：</td><td><input type="radio" name="gender"  checked="checked" value="1" />男<input type="radio" name="gender" value="0" style="margin-left:10px;" />女
							</td>
						</tr>
						<tr>
							<td class="alignRight">用户地址：</td><td><input type="text" style="width: 285px;" placeholder="请输入用户地址" name="address"  />
							</td>
						</tr>
						<tr>
							<td class="alignRight">用户编号：</td><td><input type="text" style="width: 285px;" placeholder="请输入用户编号" name="code"  />
							</td>
						</tr>
						<tr>
							<td class="alignRight">备注：</td><td><input type="text" style="width: 285px;"  placeholder="" name="remark"  />
							</td>
						</tr>
					
					</table>
				   </div>
			     </div>
			  </div>
		</div>
		<div class="dialog_alert_footer clearfix">
			<div><a class="btn sure_submit_data">确定</a><a class="btn"  onclick="$('.userAE,.shadow_outer').hide();">取消</a></div>
		</div>
	</div>
	
	


<script id="_tpl_userLS_tbody" type="text/x-jquery-tmpl">
	<colgroup>
			<col style="width: 5%;" />
			<col style="width: 5%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 5%;" />
			<col style="width: 10%;" />
			<col style="width: 30%;" />
			<col style="width: 15%;" />
	</colgroup> 
	 
	{{each(i,row) rows}}
		<tr>   
	       <td uid="@{id}"><input type="checkbox" class="ch" uid="@{id}" ></td>
	       <td>@{i+1}</td>
	       <td>@{name}</td>
	       <td>@{code}</td>
	       <td gender="@{gender}">{{if gender==1}}男{{else}}女{{/if}}</td>
	       <td>@{mobile}</td>
	       <td>@{address}</td>
	       <td>@{remark}</td>
		</tr>
	{{/each}}
	</script>

<script type="text/javascript">
	$(function(){
		$(window).resize(function(){
			setuserTableHeight()
		});
		
		//折叠搜索区域,重新计算table高度
		$(".userLS  .search_fold_btn a").click(function(){
			if($(this).hasClass("on")){
				$(this).removeClass("on");
				$(".userLS  .search_content").show()
			}
			else{
				$(this).addClass("on");
				$(".userLS  .search_content").hide()
			}
			setuserTableHeight();
		})
	});
	function setuserTableHeight(){
		
		var $h_search_area=$(".userLS .search_area").outerHeight();//搜索区域高度
		var $h_table_header=$(".userLS .table_header").height();//表头高度
		var $h_page_fixedr=$(".userLS .page_fixed").outerHeight();//分页区域高度
		var $h_window=900;
		var $h_table=$(".userLS .table_content>table").height();
		$(".userLS .userLS_content").height($h_window-$h_search_area-$h_table_header-$h_page_fixedr);
		//为了对齐table，计算滚动条宽度
		if($h_table>$(".userLS .table_content").height()){
			var scrollbarWidth = $('.userLS .table_content')[0].offsetWidth - $('.userLS .table_content')[0].scrollWidth;
			$(".userLS .table_header").css("padding-right",scrollbarWidth);
		}
		else{
			$(".userLS .table_header").css("padding-right","0");
		}
	}
	setuserTableHeight();
	
	
	
</script>

</body>


<!--提示-->
<div class="tip unite_tip  tip_error" >
	<i></i>
	<span>提交失败</span>
</div>
<!--loading-->
<div class="tip tip_loading">
	<i></i>
	<span>加载中...</span>
</div>
<!--遮罩弹出框-->
<div class="shadow  shadow_outer"></div>

<!--alert弹出框-->
<div class="dialog_alert unite_dialog_to_sure">
	<div class="dialog_header">
		<span>提示</span><a title="关闭" onclick="$('.shadow_outer,.unite_dialog_to_sure').hide()"></a>
	</div>
	<div class="dialog_content ">
		<div class="dialog_content_alert">
			<h3>确定要删除吗？</h3>
			<p class="font-orange">用户删除后将不再显示</p>
		</div>
	</div>
	<div class="dialog_alert_footer">
		<div><a class="btn sure_btn">确定</a><a class="btn cancel_btn" onclick="$('.shadow_outer,.unite_dialog_to_sure').hide()">取消</a></div>
	</div>
</div>


	