<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/6
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="${pageContext.request.contextPath }/goods/findAll">查询所有的商品</a>
    <br/>


    <h3>根据商品的goodsName查询商品</h3>
    <form action="${pageContext.request.contextPath }/goods/findByName" method="post">
        goodsName：<input type="text" name="goodsName" value=${goodsName} ><br/>
        <input type="submit" value="查询"/><br/>
        <%--用于当在数据库中查不到该goodsName时候返回给前端的--%>
        <h3> ${msggoodsName}</h3>
    </form>
    <br/>


    <h3>根据商品的goodsId查询商品</h3>
    <form action="${pageContext.request.contextPath }/goods/findById" method="post">
        goodsId：<input type="text" name="goodsId" value=${goodsId}><br/>
        <input type="submit" value="查询"/><br/>
        <%--用于当在数据库中查不到该goodsId时候返回给前端的--%>
        <h3> ${msggoodsId}</h3>
    </form>
    <br/>



    <h3>根据商品的Kinds查询商品</h3>
    <form action="${pageContext.request.contextPath }/goods/findByKinds" method="post">
        kinds：<input type="text" name="kinds" value=${kinds}><br/>
        <input type="submit" value="查询"/><br/>
        <%--用于当在数据库中查不到该kinds时候返回给前端的--%>
        <h3> ${msgkinds}</h3>


    </form>
    <br/>


    <h3>更新商品</h3>
    <form action="${pageContext.request.contextPath }/goods/updateGoods" method="post">
        openId：<input type="text" name="openId" value=${updateOpenId}><br/>
        goodsId：<input type="text" name="goodsId" value=${updateGoodsId}><br/>
        goodsName：<input type="text" name="goodsName" value=${updateGoodsName}><br/>
        howNew：<input type="text" name="howNew" value=${updateHowNew}><br/>
        pictures：<input type="text" name="pictures" value=${updatePictures}><br/>
        cost：<input type="text" name="cost" value=${updateCost}><br/>
        kinds：<input type="text" name="kinds" value=${updateKinds}><br/>
        amounts：<input type="text" name="amounts" value=${updateAmounts}><br/>
        address：<input type="text" name="address" value=${updateAddress}><br/>
        phone：<input type="text" name="phone" value=${updatePhone}><br/>
        <input type="submit" value="更新"><br/>
        <h3> ${msgupdateGoods}</h3>
    </form>
    <br/>

    <h3>添加新商品</h3>
    <form action="${pageContext.request.contextPath }/goods/saveGoods" method="post">
        openId：<input type="text" name="openId" value=${updateOpenId}><br/>
        goodsId：<input type="text" name="goodsId" value=${updateGoodsId}><br/>
        goodsName：<input type="text" name="goodsName" value=${updateGoodsName}><br/>
        howNew：<input type="text" name="howNew" value=${updateHowNew}><br/>
        pictures：<input type="text" name="pictures" value=${updatePictures}><br/>
        cost：<input type="text" name="cost" value=${updateCost}><br/>
        kinds：<input type="text" name="kinds" value=${updateKinds}><br/>
        amounts：<input type="text" name="amounts" value=${updateAmounts}><br/>
        address：<input type="text" name="address" value=${updateAddress}><br/>
        phone：<input type="text" name="phone" value=${updatePhone}><br/>
        <input type="submit" value="添加"/><br/>
        <h3> ${msgsaveGoods}</h3>
    </form>
    <br/>

    <h3>根据goodsId删除商品</h3>
    <form action="${pageContext.request.contextPath }/goods/deleteGoods" method="post">
        goodsId：<input type="text" name="goodsId" /><br/>
        <input type="submit" value="删除"/><br/>
        <h3> ${msgdeleteGoods}</h3>
    </form>
    <br/>








</body>
</html>
