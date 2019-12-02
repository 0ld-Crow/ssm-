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




    <body>
    <form action="${pageContext.request.contextPath }/conversation/go" method="post">
        请选择主界面：<select name="DropDownList1">
        <option value="" selected>请选择</option>
        <option value="商品主界面">商品主界面</option>
        <option value="订单主界面">订单主界面</option>
        <option value="用户主界面">用户主界面</option>
    </select><br>
        <input type="submit" value="确定" ><br>
    </form>
    </body>






</body>
</html>
