<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="commons.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
	<head>
	
		<meta charset="utf-8">
		<title>Pure CSS3 Menu</title>
		<link href="<%=basePath%>ui/menu_demo/style.css" media="screen" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>ui/menu_demo/iconic.css" media="screen" rel="stylesheet" type="text/css" />
		<script src="<%=basePath%>ui/menu_demo/prefix-free.js"></script>
	</head>

<body>
	<div class="wrap">
	
	<nav>
		<ul class="menu">
			<li><a href="#"><span class="iconic home"></span> Home</a></li>
			<li><a href="#"><span class="iconic plus-alt"></span> About</a>
				<ul>
					<li><a href="#">Company History</a></li>
					<li><a href="#">Meet the team</a></li>
				</ul>
			</li>
			<li ><a href="#" onclick="change('search')" ><span class="iconic magnifying-glass"></span> Services</a>
<!-- 				<ul> -->
<!-- 					<li><a href="#">Web Design</a></li> -->
<!-- 					<li><a href="#">App Development</a></li> -->
<!-- 					<li><a href="#">Email Campaigns</a></li> -->
<!-- 					<li><a href="#">Copyrighting</a></li> -->
<!-- 				</ul> -->
			</li>
			<li><a href="#"><span class="iconic map-pin"></span> Products</a>
				<ul>
					<li><a href="#">Widget One</a></li>
					<li><a href="#">Widget Two</a></li>
					<li><a href="#">Web App Three</a></li>
					<li><a href="#">Web App Four</a></li>
					<li><a href="#">Crazy Products</a></li>
					<li><a href="#">iPhone Apps</a></li>
				</ul>
			</li>
			<li><a href="#"><span class="iconic mail"></span> Contact</a>
				<ul>
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">Directions</a></li>
				</ul>
			</li>
		</ul>
		<div class="clearfix"></div>
	</nav>
	</div>
	 <iframe id="formContent" name="formContent" src="" width="100%" height="100%" frameborder="0" marginheight="0" marginwidth="0"></iframe>
</body>
<script type="text/javascript">
function change(data){
	if (data=="search")
$('#formContent').attr("src","<%=basePath%>ticketBuy.jsp");
}
</script>
</html>