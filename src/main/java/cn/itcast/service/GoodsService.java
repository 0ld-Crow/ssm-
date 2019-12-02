package cn.itcast.service;

import cn.itcast.domain.Goods;

import java.util.List;

public interface GoodsService {

    // 查询所有商品
    public List<Goods> findAll();

    //根据商品的goodsName查询商品
    public  List<Goods> findBygoodsName(Goods goods);

    //根据商品的goodsId查询商品
    public  Goods findBygoodsId(Goods goods);

    //根据商品的种类kinds查询商品
    public List<Goods> findBykinds(Goods goods);

    //更新商品
    public  void updateGoods(Goods goods);

    //添加新商品
    public void saveGoods(Goods goods);

    //删除商品
    public  void deleteGoods(Goods goods);

}
