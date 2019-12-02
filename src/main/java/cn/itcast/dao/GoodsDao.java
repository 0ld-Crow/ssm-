package cn.itcast.dao;

import cn.itcast.domain.Goods;
import com.github.pagehelper.ISelect;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品dao接口
 */
@Repository
public interface GoodsDao {


    /**
     * 根据：
     *操作：查询所有商品list
     * @return 所有商品list的每个商品的全部信息
     */
    @Select("select * from goods")
    public List<Goods> findAll();


    /**
     * 根据：商品的goodsName
     * 操作：查询名称为goodsName的商品list
     * @param goodsName
     * @return 商品list的每个商品的全部信息
     */
    @Select("select * from goods where goodsName = #{goodsName}")
    public List<Goods> findByName(String goodsName);


    /**
     * 根据：商品的goodsId
     * 操作：查询ID为goodsId的商品
     * @param goodsId
     * @return ID为goodId的商品的全部信息和卖家seller信息
     */

    @Select("select * from goods,users where goods.goodsId = #{goodsId} and goods.openId=users.openId")
    @Results(id="",value = {
            @Result(id=true,property = "goodsId",column = "goodsId"),
//            @Result(column = "openId",property = "openId"),   //如果不写这一行的话openId为null
            @Result(property = "seller",column = "openId",one=@One(select="cn.itcast.dao.UsersDao.findByopenIdFor",fetchType = FetchType.EAGER)),
    })
    public Goods findBygoodsId(int goodsId);







    /**
     * 根据：商品的kings
     * 操作：查询种类为kinds的商品List
     * @param kinds
     * @return 商品的list的每个商品的全部信息
     */
    // 根据商品的种类kinds查询商品
    @Select("select * from goods where kinds = #{kinds}")
    public List<Goods> findByKinds(String kinds);



    //amounts-1
    @Update("update goods set openId=#{openId} where goodsId=#{goodsId}" )
    public void reduceGoods(Goods goods);


    // 更新商品
    @Update("update goods set openId=#{openId},goodsId=#{goodsId}," +
            "goodsName=#{goodsName},howNew=#{howNew},pictures=#{pictures},cost=#{cost}," +
            "kinds=#{kinds},amounts=#{amounts},address=#{address},phone=#{phone} where goodsId=#{goodsId}" )
    public void updateGoods(Goods goods);

    // 把新商品插入数据库
    @Insert("insert into goods(openId,goodsId,goodsName,howNew,pictures,cost,kinds," +
            "amounts,address,phone)values(#{openId},#{goodsId},#{goodsName}," +
            "#{howNew},#{pictures},#{cost},#{kinds},#{amounts},#{address},#{phone})")
    public void saveGoods(Goods goods);

    // 删除商品
    @Delete("delete from goods where goodsId= #{goodsId}")
    public void deleteGoods(int goodsId);


    //********************************************************************************
    //以下的方法用于别的表的多表操作


    @Select("select * from goods where goodsId = #{goodsId}")
    public Goods findBygoodsIdFor(int goodsId);

    @Select("select * from goods where openId = #{openId}")
    public List<Goods> findByopenIdFor(String openId);

    @Select("select * from goods where openId = #{openId}")
    public Goods findByopenIdFor1(String openId);
}
