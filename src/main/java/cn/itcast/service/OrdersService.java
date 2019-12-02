package cn.itcast.service;


import cn.itcast.domain.Orders;


import java.util.List;

public interface OrdersService {

    //根据订单orderId查询订单
    public Orders findByorderId(Orders orders);

    //根据订单sellerId,buyerId查询订单
    public Orders findBysellerIdbuyerId(Orders orders);




    //更新订单
    public  void updateOrders(Orders orders);

    //添加新订单
    public void saveOrders(Orders orders);

    //删除订单
    public  void deleteOrders(Orders orders);

}
