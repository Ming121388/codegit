<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<script type="text/javascript"
	src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function showYue() {
		$.ajax({
			url : 'userController/showYue.do',
			data : "",
			dataType : 'json',
			type : 'GET',
			success : function() {
				$("#yue").html(data.yue);
			}
		});
	}
</script>
<script type="text/javascript">
	var items = $("input[name='good']:checked").serialize();
	function order() {
		$.ajax({
			url : 'userController/order.do',
			data : items,
			dataType : 'json',
			type : 'GET',
			success : function(data) {
				$("#result").html(data.msg);
			}

		});
	}
</script>

</head>
<body>${name}你好登陆成功
	<input type="submit" value="点击查询余额" onclick="shouwYue();">
	<div id="yue"></div>
	<form action="logOut.do">
		<input type="submit" value="退出登录">
	</form>
	<div>
		Espresso <input type="checkbox" name="good" value="Espresso"
			checked="checked" /> <br /> Cappuccino <input type="checkbox"
			name="good" value="Cappuccino" /> <br /> Coffee Latte <input
			type="checkbox" name="good" value="CoffeeLatte" /> <br /> Dry
		Martin <input type="checkbox" name="good" value="DryMartin" /> <br />
		Lafite(82) <input type="checkbox" name="good" value="Lafite" /> <br />
		<br /> <input type="submit" value="Submit" onclick="order();" />
	</div>
	<a href="../ajax.jsp">ajax.jsp</a>
	<br>
</body>
</html>