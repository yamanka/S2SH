<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="commons.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


 <link rel="stylesheet" type="text/css" href="<%=basePath%>ui/easyui/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>ui/easyui/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>ui/easyui/color.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>ui/easyui/demo.css">	
    
    <link href="<%=basePath%>ui/login.css" type="text/css" media="screen" rel="stylesheet" />	

<script type="text/javascript" src="<%=basePath%>ui/easyui/jquery.easyui.min.js"></script>
<style type="text/css">
		img, div { behavior: url(iepngfix.htc) }
		</style>
<title>登陆界面</title>
</head>
<body id="login">
		<div id="wrappertop"></div>
			<div id="wrapper">
					<div id="content">
						<div id="header">
							<h1><a href=""><img src="<%=basePath%>ui/logo.png" alt="FreelanceSuite"></a></h1>
						</div>
						<div id="darkbanner" class="banner320">
							<h2>Login</h2>
						</div>
						<div id="darkbannerwrap">
						</div>
						<form method="post" >
						<fieldset class="form">
                        	                                                                                       <p>
								<label for="user_name">Username:</label>
								<input name="user_name" id="user_name" type="text" value="" />
							</p>
							<p>
								<label for="user_password">Password:</label>
								<input name="user_password" id="user_password" type="password" />
							</p>
							
							<button  class="positive"  onclick="dologin();return false;">
								<img src="<%=basePath%>ui/key.png" alt="Announcement"/>Login</button>
								<a href="javascript:void(0)" onclick="javascript:$('#dlg').dialog('open').dialog('setTitle','注册')">注册用户</a>
							
                            						</fieldset>
						</form>
						
					</div>
				</div>   
				 <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">新用户</div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>用户名:</label>
                <input name="username" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>密码:</label>
                <input name="password" class="easyui-textbox" type="password" required="true">
            </div>
            <div class="fitem">
                <label>重复密码:</label>
                <input name="rpassword" class="easyui-textbox" type="password" required="true">
            </div>
            <div class="fitem">
                <label>真实姓名:</label>
                <input name="realname" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>所属学校:</label>
                <input name="school" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>电话号码:</label>
                <input name="phonenum" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>Email:</label>
                <input name="email" class="easyui-textbox" validType="email">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser();" style="width:90px">注册</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>

</body>
<script type="text/javascript">
function saveUser(){
	
	$(fm).form('submit',{
		url:"<%=basePath%>loginAction/regist.do",
		onSubmit:function(){
			if (!$(fm).form('validate')){
				alert("必填域为空或格式错误！");
				return false;
			}
			if($("input[name='password']").val()!=$("input[name='rpassword']").val()){
				alert("两次密码不一致");
				return false;
			}
		},
		success:function(data){
			if (data="success")
			$('#dlg').dialog('close');
			else
				alert("用户名已存在");
		}
	});
}
function dologin(){
	var username=document.getElementById("user_name").value;
	var userpassword=document.getElementById("user_password").value;
	var params={};
	params["username"]=username;
	params["password"]=userpassword;
	if (username==null){
		alert("用户名不能为空");
		return;
	}else
		if (userpassword==null){
			alert("密码不能为空");
			return;
		}
	$.ajax({
		type:"post" ,
		url:"<%=basePath%>loginAction/login.do",
		data : params,
		async: false,
		dataType : "text",
		 success :function (data) {
			
			 if(data == "success"){
                 window.location.href = "<%=basePath%>main.jsp";

             }
             else{
            	 alert( "用户名或密码错误");
                 document.getElementById("user_password").value='';
             }
		 },
		 error:function(data){
			 alert(data);
		 }
	});
}
</script>
</html>