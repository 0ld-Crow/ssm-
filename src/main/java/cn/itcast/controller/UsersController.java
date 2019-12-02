package cn.itcast.controller;

import cn.itcast.domain.Goods;
import cn.itcast.domain.Users;
import cn.itcast.service.GoodsService;
import cn.itcast.service.UsersService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    //处理登录
    @RequestMapping(value = "/login")
    public String login(Users users, Model model) {


        //判断openId或phone是否为空
        if (users.getOpenId() == "" || users.getPhone() == "") {
            model.addAttribute("msg", "openId或phone不能为空，请重新输入！");
            System.out.println("openId或phone不能为空，请重新输入！");
            return "login";
        }


        // 判断ipenId和phone是否是正确的
        Users users1 = usersService.findByopenId(users);
        if(users1 == null){
            model.addAttribute("msg", "openId错误，请重新输入！");
            System.out.println("openId错误，请重新输入！");
            return "login";
        }
        if (!users1.getPhone().equals(users.getPhone())) {
            model.addAttribute("msg", "phone错误，请重新输入！");
            System.out.println("phone错误，请重新输入！");
            return "login";
        }

        System.out.println("openId和phone都正确，成功跳转到管理者页面！");
        return "conversion";

    }



    //根据用户的openId查询用户 并返回该用户所拥有的商品 (卖家)
    @RequestMapping("/findByopenId")
    public @ResponseBody Users findByopenId(@RequestBody Users users){
        System.out.println("表现层：根据用户的openId查询用户...");
        // 调用service的方法
        Users users2 = usersService.findByopenId(users);
        return users2;
    }


    //根据用户phone查询用户
    @RequestMapping("/findByphone")
    public @ResponseBody Users findByphone(@RequestBody Users users){
        System.out.println("表现层：根据phone查询用户...");
        // 调用service的方法
        Users users2 = usersService.findByphone(users);

        return users2;
    }


    //根据用户name查询用户list
    @RequestMapping("/findBynickName")
    public @ResponseBody List<Users> findBynickName(@RequestBody Users users){
        System.out.println("表现层：根据用户nickName查询用户...");
        // 调用service的方法
        List<Users> list = usersService.findBynickName(users);

        return list;
    }

    //根据用户的openId查询用户（以卖家的身份来查订单0）
//    @RequestMapping("/findByopenidForSellerflag0")
//    public @ResponseBody Users findByopenidForSellerflag0(@RequestBody Users users){
//        System.out.println("表现层：根据用户的openId查询用户（以卖家的身份来查订单0）...");
//        // 调用service的方法
//        Users users2 = usersService.findByopenidForSellerflag0(users);
//
//        return users2;
//    }

//    //根据用户的openId查询用户（以卖家的身份来查订单1）
//    @RequestMapping("/findByopenidForSellerflag1")
//    public @ResponseBody Users findByopenidForSellerflag1(@RequestBody Users users){
//        System.out.println("表现层：根据用户的openId查询用户（以卖家的身份来查订单1）...");
//        // 调用service的方法
//        Users users2 = usersService.findByopenidForSellerflag1(users);
//
//        return users2;
//    }

    //根据用户的openId查询用户（以买家的身份来查订单0）
//    @RequestMapping("/findByopenidForBuyerflag0")
//    public @ResponseBody Users findByopenidForBuyerflag0(@RequestBody Users users){
//        System.out.println("表现层：根据用户的openId查询用户（以买家的身份来查订单0）...");
//        // 调用service的方法
//        Users users2 = usersService.findByopenidForBuyerflag0(users);
//
//        return users2;
//    }


    //根据用户的openId查询用户（以买家的身份来查订单1）
//    @RequestMapping("/findByopenidForBuyerflag1")
//    public @ResponseBody Users findByopenidForBuyerflag1(@RequestBody Users users){
//        System.out.println("表现层：根据用户的openId查询用户（以买家的身份来查订单1）...");
//        // 调用service的方法
//        Users users2 = usersService.findByopenidForBuyerflag1(users);
//
//        return users2;
//    }
//




    ////更新用户信息（并返回新用户的信息）
    @RequestMapping("/updateUsers")
    public @ResponseBody Users updateUsers(@RequestBody Users users){
        System.out.println("表现层：更新用户...");
        //把从小程序端传过来的json数据转化成可以存入数据库的类数据
        JSONObject jsonObject= JSONObject.fromObject(users);
        Users users1= (Users) JSONObject.toBean(jsonObject,Users.class);
        // 调用service的方法
        usersService.updateUsers(users1);

        return users;
    }



    //添加新用户（并返回新用户信息）
    @RequestMapping("/saveUsers")
    public  @ResponseBody Users saveUsers( @RequestBody Users users){
        System.out.println("表现层：添加新用户...");
        //把从小程序端传过来的json数据转化成可以存入数据库的类数据
        JSONObject jsonObject= JSONObject.fromObject(users);
        Users users1= (Users) JSONObject.toBean(jsonObject,Users.class);
        // 调用service的方法
        usersService.saveUsers(users1);

        return users;
    }


    ////删除用户（并返回被删除的用户信息）
    @RequestMapping("/deleteUsers")
    public @ResponseBody Users deleteUsers(@RequestBody Users users) {
        System.out.println("表现层：删除用户...");
        //把从小程序端传过来的json数据转化成可以存入数据库的类数据
        JSONObject jsonObject= JSONObject.fromObject(users);
        Users users1= (Users) JSONObject.toBean(jsonObject,Users.class);
        Users users2 = users;
        // 调用service的方法
        usersService.deleteUsers(users1);

        return users2;
    }

}
