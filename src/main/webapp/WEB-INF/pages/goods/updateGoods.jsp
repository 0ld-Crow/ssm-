<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/6
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>更新商品成功</h3>

<%--    <c:forEach items="${list}" var="account">--%>
<%--        ${account.name}--%>
<%--    </c:forEach>--%>
    <h3> ${goods.openId}</h3>
    <h3> ${goods.goodsId}</h3>
    <h3> ${goods.goodsName}</h3>
    <h3> ${goods.howNew}</h3>
    <h3> ${goods.pictures}</h3>
    <h3> ${goods.cost}</h3>
    <h3> ${goods.kinds}</h3>
    <h3> ${goods.amounts}</h3>
    <h3> ${goods.address}</h3>
    <h3> ${goods.phone}</h3>
</body>
</html>
