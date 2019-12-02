package cn.itcast.dao;



import cn.itcast.domain.Orders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单dao接口
 */
@Repository
public interface OrdersDao {

    /**
     * 根据：订单的id orderId
     * 操作：查询该订单
     * @param orderId
     * @return 该订单的所有信息
     */
    @Select("select * from orders where orderId = #{orderId}")
    @Results(id="orderMap",value={
            @Result(id=true,column = "orderId",property = "orderId"),
            @Result(property = "goods",column = "goodsId",one=@One(select = "cn.itcast.dao.GoodsDao.findBygoodsIdFor",fetchType = FetchType.EAGER)),
            @Result(property = "seller",column = "sellerId",one=@One(select = "cn.itcast.dao.UsersDao.findByopenIdFor",fetchType = FetchType.EAGER)),
            @Result(property = "buyer",column = "buyerId",one=@One(select = "cn.itcast.dao.UsersDao.findByopenIdFor",fetchType = FetchType.EAGER)),
    })//用于订单和买家，订单和卖家，订单和商品的一对一查询操作
    public Orders findByorderId(int orderId);


    /**
     *根据：订单的sellerid 和 buyerid
     * 操作：查该订单和goodsid对应的商品
     * @param order
     * @return 订单和goodsid对应的商品
     */
    @Select("select * from orders where sellerId=#{sellerId} and buyerId=#{buyerId}")
    @Results(id="orderMap1",value={
            @Result(id=true,column = "orderId",property = "orderId"),
            @Result(property = "goods",column = "goodsId",one=@One(select = "cn.itcast.dao.GoodsDao.findBygoodsIdFor",fetchType = FetchType.EAGER)),
    })
    public Orders findBysellerIdbuyerId(Orders order);




    // 更新订单
    @Update("update orders set orderId=#{orderId},goodsId=#{goodsId}," +
            "sellerId=#{sellerId},buyerId=#{buyerId},dateTime=#{dateTime},comments=#{comments}," +
            "flag=#{flag} where orderId=#{orderId}" )
    public void updateOrder(Orders order);

    // 把新订单插入数据库
    @Insert("insert into orders(orderId,goodsId,sellerId,buyerId,dateTime,comments,flag)" +
            "values(#{orderId},#{goodsId},#{sellerId},#{buyerId},#{dateTime},#{comments},#{flag})")
    public void saveOrder(Orders order);

    // 删除订单
    @Delete("delete from orders where orderId= #{orderId}")
    public void deleteOrder(int orderId);



    //********************************************************************************
    //以下的方法用于别的表的多表操作


    //根据订单sellerId查询订单中flag为0的
    @Select("select * from orders where sellerId = #{sellerId},flag={0}")
    @ResultMap(value = {"orderMap"})
    public List<Orders> findBysellerIdForflag0(int sellerId);

    //根据订单sellerId查询订单中flag为1的
    @Select("select * from orders where sellerId = #{sellerId},flag={1}")
    @ResultMap(value = {"orderMap"})
    public List<Orders> findBysellerIdForflag1(int sellerId);
}
