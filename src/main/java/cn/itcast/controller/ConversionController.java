package cn.itcast.controller;

import cn.itcast.domain.Users;
import cn.itcast.service.UsersService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 中转控制器
 */
@Controller
@RequestMapping("/conversation")
public class ConversionController {




    //
    @RequestMapping(value = "/go")
    public String login ( String DropDownList1) {

        if(DropDownList1.equals("商品主界面") ){
            System.out.println("成功跳转到商品主界面！");
            return "interface/goodsInterface";
        }else if(DropDownList1.equals("订单主界面")){
            System.out.println("成功跳转到订单主界面！");
            return "interface/ordersInterface";
        }else if(DropDownList1.equals("用户主界面")){
            System.out.println("成功跳转到用户主界面！");
            return "interface/usersInterface";
        }
        return "conversion";

    }






}
