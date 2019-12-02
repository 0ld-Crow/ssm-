package cn.itcast.test;

import cn.itcast.dao.GoodsDao;
import cn.itcast.domain.Goods;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    /**
     * 测试查询所有
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        GoodsDao dao = session.getMapper(GoodsDao.class);
        // 查询所有数据
        List<Goods> list = dao.findAll();
        for(Goods goods : list){
            System.out.println(goods);
        }
        // 关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {
//        Goods goods = new Goods();
//        goods.setName("熊大");
//        goods.setId(100);

        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        GoodsDao dao = session.getMapper(GoodsDao.class);

        // 保存
//        dao.saveGoods(goods);

        // 提交事务
        session.commit();

        // 关闭资源
        session.close();
        in.close();
    }

}
