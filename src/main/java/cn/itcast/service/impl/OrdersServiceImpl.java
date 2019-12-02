package cn.itcast.service.impl;

import cn.itcast.dao.GoodsDao;
import cn.itcast.dao.OrdersDao;
import cn.itcast.domain.Goods;
import cn.itcast.domain.Orders;
import cn.itcast.service.GoodsService;
import cn.itcast.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrdersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    //根据订单orderId查询订单
    public Orders findByorderId(Orders orders){
        System.out.println("业务层：根据订单的orderId查找订单...");
        return ordersDao.findByorderId(orders.getOrderId());
    }


    //根据订单sellerIdbuyerId查询订单
    public Orders findBysellerIdbuyerId(Orders orders){
        System.out.println("业务层：根据订单的sellerId,buyerId查找订单...");
        return ordersDao.findBysellerIdbuyerId(orders);
    }


    //更新订单
    public void updateOrders(Orders orders) {
        System.out.println("业务层：更新订单...");
        ordersDao.updateOrder(orders);

    }

    //添加新订单
    public void saveOrders(Orders orders) {
        System.out.println("业务层：保存新订单...");
        ordersDao.saveOrder(orders);
    }

    //删除订单
    public void deleteOrders(Orders orders) {
        System.out.println("业务层：删除订单...");
        ordersDao.deleteOrder(orders.getOrderId());
    }





}
