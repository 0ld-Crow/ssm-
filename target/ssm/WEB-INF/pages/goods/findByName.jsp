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

    <h3>根据商品的Name查询商品成功</h3>

    <c:forEach items="${list}" var="goods">
        ${goods.openId}
        ${goods.goodsId}
        ${goods.goodsName}
        ${goods.howNew}
        ${goods.pictures}
        ${goods.cost}
        ${goods.kinds}
        ${goods.amounts}
        ${goods.address}
        ${goods.phone}
        <br>
    </c:forEach>


</body>
</html>
