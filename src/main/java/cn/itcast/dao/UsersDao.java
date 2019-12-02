package cn.itcast.dao;


import cn.itcast.domain.Goods;
import cn.itcast.domain.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户dao接口
 */

@Repository
public interface UsersDao {


    /**
     * 根据：用户的id
     * 操作：查询用户
     * @param openId
     * @return 返回用户全部信息和其拥有的商品List
     */


    @Select("select *  from users where openId = #{openId}")
    @Results(id="usersMap",value={
            @Result(id=true,column = "openId",property = "openId"),
            //            @Result(property = "goods",column = "openId",one=@One(select = "cn.itcast.dao.GoodsDao.findByopenIdFor1",fetchType = FetchType.EAGER)),

          @Result(property = "goodsList",column = "openId",many = @Many(select = "cn.itcast.dao.GoodsDao.findByopenIdFor",fetchType = FetchType.LAZY)),
    })
    public Users findByopenId(String openId);


    /**
     * 根据：用户的phone
     * 操作：查询用户
     * @param phone
     * @return 返回用户全部信息和其拥有的商品
     */
    @Select("select * from users where phone = #{phone}")
//    @ResultMap(value = {"usersMap"})
    public Users findByphone(String phone);


    /**
     * 根据：用户的姓名nickName
     * 操作：查询该姓名的所有用户的list
     * @param nickName
     * @return 返回用户全部信息
     */
    @Select("select * from users where nickName = #{nickName}")
    public List<Users> findBynickName(String nickName);


    /**
     * 根据:用户的id openid
     * 操作：查询该用户的订单List（flag为0）【即卖家还没有确定】
     * @param openid
     * @return
     */
    @Select("select * from users where openId = #{openId}")
//    @Results(id="ordersMap0",value={
//            @Result(id=true,column = "openId",property = "openId"),
//            @Result(property = "ordersList",column = "openId",many=@Many(select = "cn.itcast.dao.OrdersDao.findBysellerIdForflag0",fetchType = FetchType.LAZY)),
//    })
    public Users findByopenidForflag0(String openid);


    /**
     * 根据:用户的id openid
     * 操作：查询该用户的订单List（flag为1）【即卖家已经确定】
     * @param openId
     * @return
     */
    @Select("select * from users where openId = #{openId}")
//    @Results(id="ordersMap1",value={
//            @Result(id=true,column = "openId",property = "openId"),
//            @Result(property = "ordersList",column = "openId",many=@Many(select = "cn.itcast.dao.OrdersDao.findBysellerIdForflag1",fetchType = FetchType.LAZY)),
//    })
    public Users findByopenidForflag1(String openId);








    //更新用户
    @Update("update users set openId=#{openId},nickName=#{nickName}," +
            "avatarUrl=#{avatarUrl},gender=#{gender},phone=#{phone},address=#{address}  where openId=#{openId}" )
    public  void updateUsers(Users users);

    //添加新用户
    @Insert("insert into users(openId,nickName,avatarUrl,gender,phone,address)values(#{openId},#{nickName}," +
            "#{avatarUrl},#{gender},#{phone},#{address})")
    public void saveUsers(Users users);

    //删除用户
    @Delete("delete from users where openId= #{openId}")
    public  void deleteUsers(String openId);

    //********************************************************************************
    //以下的方法用于别的表的多表操作


    @Select("select * from users where openId = #{openId}")
    public Users findByopenIdFor(String openId);




}
