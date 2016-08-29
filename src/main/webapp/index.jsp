<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
</body>

<form action="userController/zhuCe.do" method="post">
<!--input id="id"  type ="text" name="id"-->
注册<br>
输入您的名字：<input id="name" type ="text" name="name"></input><br>
输入你的密码：<input id="psw"  type ="password" name="psw"></input><br><br>
<input type="submit" value="注册"></input>
<input type="button" value="已有账号？点击转跳登陆页面" onclick="javascript:top.location='login.jsp';"></input>
</form>
<a href="ajax.jsp">ajax.jsp</a><br>
<a href="detail.html">detail.html</a>
<a href="index.html">index.html</a>
</html>
