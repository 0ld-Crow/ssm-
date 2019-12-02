<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%--引入标签--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>预约信息</title>
    <%
        pageContext.setAttribute("BASE_PATH", request.getContextPath());
    %>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12" align="center">
            <h2>所有商品信息</h2>
        </div>
    </div>
<%--    <div class="row">--%>
<%--        <div class="col-md-2 offset-md-10">--%>
<%--            <button class="btn btn-primary btn-sm">添加</button>--%>
<%--            <button class="btn btn-danger btn-sm">删除</button>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>openId</th>
                    <th>goodsId</th>
                    <th>goodsName</th>
                    <th>howNew</th>
                    <th>pictures</th>
                    <th>cost</th>
                    <th>kinds</th>
                    <th>amounts</th>
                    <th>address</th>
                    <th>phone</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="goods">
                    <tr>
                        <th>${goods.openId}</th>
                        <th>${goods.goodsId}</th>
                        <th>${goods.goodsName}</th>
                        <th>${goods.howNew}</th>
                        <th>${goods.pictures}</th>
                        <th>${goods.cost}</th>
                        <th>${goods.kinds}</th>
                        <th>${goods.amounts}</th>
                        <th>${goods.address}</th>
                        <th>${goods.phone}</th>
                        <th>
                            <button class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                修改1
                            </button>
                            <button class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                修改2
                            </button>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            第${pageInfo.pageNum}页，共${pageInfo.pages}页，共${pageInfo.total}条记录
        </div>
        <div class="col-md-6 offset-md-4">
            <nav aria-label="Page navigation example">
                <ul class="pagination pagination-sm">
                    <li class="page-item"><a class="page-link" href="${BASE_PATH}/goods/findAll?page=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li class="page-item"><a class="page-link"
                                                 href="${BASE_PATH}/goods/findAll?page=${pageInfo.pageNum-1}">上一页</a></li>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                        <c:if test="${page==pageInfo.pageNum}">
                            <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                        </c:if>
                        <c:if test="${page!=pageInfo.pageNum}">
                            <li class="page-item"><a class="page-link"
                                                     href="${BASE_PATH}/goods/findAll?page=${page}">${page}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li class="page-item"><a class="page-link"
                                                 href="${BASE_PATH}/goods/findAll?page=${pageInfo.pageNum+1}">下一页</a></li>
                    </c:if>
                    <li class="page-item"><a class="page-link" href="${BASE_PATH}/goods/findAll?page=${pageInfo.pages}">末页</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>

</body>
</html>
