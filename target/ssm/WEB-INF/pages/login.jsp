<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/6
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



    <h3>输入用户的openId和phone</h3>
    <form action="${pageContext.request.contextPath }/users/login" method="post">
        openId：<input type="text" name="openId" /><br/>
        phone：<input type="text" name="phone" /><br/>
        <input type="submit" value="登录"/><br/>
    </form>
    <br/>


    <h3> ${msg}</h3>

</body>
</html>
