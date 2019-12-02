package cn.itcast.controller;

import cn.itcast.domain.Orders;
import cn.itcast.domain.Users;
import cn.itcast.service.OrdersService;
import cn.itcast.service.UsersService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 订单控制器
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;



    //根据订单的orderId查询订单
    @RequestMapping("/findByorderId")
    public @ResponseBody Orders findByorderId(@RequestBody Orders orders){
        System.out.println("表现层：根据订单的orderId查询订单...");
        // 调用service的方法
        Orders orders1 = ordersService.findByorderId(orders);

        return orders1;
    }

    //根据订单的sellerIdbuyerId查询订单
    @RequestMapping("/findBysellerIdbuyerId")
    public @ResponseBody Orders findBysellerIdbuyerId(@RequestBody Orders orders){
        System.out.println("表现层：根据订单的sellerIdbuyerId查询订单...");
        // 调用service的方法
        Orders orders1 = ordersService.findBysellerIdbuyerId(orders);

        return orders1;
    }



    //更新订单（并返回新订单的信息）
    @RequestMapping("/updateOrders")
    public @ResponseBody Orders updateGoods(@RequestBody Orders orders){
        System.out.println("表现层：更新订单...");
        //把从小程序端传过来的json数据转化成可以存入数据库的类数据
        JSONObject jsonObject= JSONObject.fromObject(orders);
        Orders orders1= (Orders) JSONObject.toBean(jsonObject,Orders.class);
        // 调用service的方法
        ordersService.updateOrders(orders1);

        return orders;
    }


    //添加新订单（并返回新订单信息）
    @RequestMapping("/saveOrders")
    public  @ResponseBody Orders saveGoods( @RequestBody Orders orders){
        System.out.println("表现层：添加新订单...");
        //把从小程序端传过来的json数据转化成可以存入数据库的类数据
        JSONObject jsonObject= JSONObject.fromObject(orders);
        Orders orders1= (Orders) JSONObject.toBean(jsonObject,Orders.class);
        // 调用service的方法
        ordersService.saveOrders(orders1);

        return orders;
    }


    //删除订单（并返回被订单的商品信息）
    @RequestMapping("/deleteOrders")
    public @ResponseBody Orders deleteGoods(@RequestBody Orders orders) {
        System.out.println("表现层：删除订单...");
        Orders orders1 =orders;
        // 调用service的方法
        ordersService.deleteOrders(orders);

        return orders1;
    }
}
