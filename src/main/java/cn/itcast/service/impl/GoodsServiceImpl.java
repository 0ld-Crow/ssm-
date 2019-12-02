package cn.itcast.service.impl;

import cn.itcast.dao.GoodsDao;
import cn.itcast.domain.Goods;
import cn.itcast.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;


    //查询所有的商品
    public List<Goods> findAll() {
        System.out.println("业务层：查询所有商品...");
        return goodsDao.findAll();

    }

    //根据商品的goodsName查询商品
    public List<Goods> findBygoodsName(Goods goods) {
        System.out.println("业务层：根据Name查找商品...");
        return goodsDao.findByName(goods.getGoodsName());
    }

    //根据商品的id查询商品
    public Goods findBygoodsId(Goods goods) {
        System.out.println("业务层：根据Id查找商品...");
        return goodsDao.findBygoodsId(goods.getGoodsId());
    }

    //根据商品的种类kinds查询商品
    public List<Goods> findBykinds(Goods goods) {
        System.out.println("业务层：根据商品的种类kinds查询商品...");
        return goodsDao.findByKinds(goods.getKinds());
    }

    //更新商品
    public void updateGoods(Goods goods) {
        System.out.println("业务层：更新商品...");
        goodsDao.updateGoods(goods);

    }

    //添加新商品
    public void saveGoods(Goods goods) {
        System.out.println("业务层：保存新商品...");
        goodsDao.saveGoods(goods);
    }

    //删除商品
    public void deleteGoods(Goods goods) {
        System.out.println("业务层：删除商品...");
        goodsDao.deleteGoods(goods.getGoodsId());
    }




}
