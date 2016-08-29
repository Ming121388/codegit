<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
</body>

<form action="userController/showUser.do" method="post">

登陆<br>
输入您的名字：<input id="name" type ="text" name="name"></input><br>
输入你的密码：<input id="psw"  type ="password" name="psw"></input><br>
<input type="submit" value="登陆"></input><br>

</form>
<a href="login.jsp">返回登陆窗</a><br>
<a href="index.jsp">返回注册窗</a>
</html>
