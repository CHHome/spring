<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>用户登录</legend>
	<form action="${pageContext.request.contextPath }/user/login.html" method="post">
		<div>
			<label>用户名</label><input type="text" name="username" />
		</div>
		<div>
			<label>密码</label><input type="password" name="password" />
		</div>
		<div><button>登录</button> <input type="reset" value="重置" /></div>
	</form>
</fieldset>
</body>
</html>