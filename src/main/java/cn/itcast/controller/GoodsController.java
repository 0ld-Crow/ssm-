package cn.itcast.controller;

import cn.itcast.domain.Goods;
import cn.itcast.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品控制器
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    //查询所有商品（利用PageHelpler实现了分页查询）
    @RequestMapping("/findAll")
    public String findAll(Model model,@RequestParam(value = "page", defaultValue = "1") Integer page){
        System.out.println("表现层：查询所有商品...");


        PageHelper.startPage(page, 8);   //这个方法得在select上面     紧跟的第一个select方法被分页
        // 调用service的方法
        List<Goods> list = goodsService.findAll();
        System.out.println(list);

        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list,5);

        model.addAttribute("pageInfo", pageInfo);

        return "goods/findAll";
    }


    //根据商品的goodsName查询商品
    @RequestMapping("/findByName")
    public  String findByName( Goods goods,Model model){
        System.out.println("表现层：根据商品的goodsName查询商品...");
        // 调用service的方法
        List<Goods> list = goodsService.findBygoodsName(goods);

        //用来处理要是在数据库中找不到该goodsName的情况
        List<Goods> a = new ArrayList<>();
        if(list.equals(a)  ){
            model.addAttribute("goodsName",goods.getGoodsName()); //用于回显数据
            model.addAttribute("msggoodsName", "数据库没有该goodsName，请重新输入！");
            System.out.println("数据库没有该goodsName，请重新输入！");
            return "interface/goodsInterface";
        }

        System.out.println(list);
        model.addAttribute("list",list);
        return "goods/findByName";
    }


    //根据商品的goodsId查询商品 并返回该商品所属的卖家
    @RequestMapping("/findById")
    public String findById( Goods goods,Model model){
        System.out.println("表现层：根据goodsId查询商品...");
        // 调用service的方法
        Goods goods1 = goodsService.findBygoodsId(goods);

        System.out.println(goods1.getSeller());

        //用来处理要是在数据库中找不到该goodsId的情况
        if(goods1 == null  ){
            model.addAttribute("goodsId",goods.getGoodsId()); //用于回显数据
            model.addAttribute("msggoodsId", "数据库没有该goodsId，请重新输入！");
            System.out.println("数据库没有该goodsId，请重新输入！");
            return "interface/goodsInterface";
        }

        System.out.println(goods1);
        model.addAttribute("goods1",goods1);
        return "goods/findById";
    }


    //根据商品的种类kinds查询商品
    @RequestMapping("/findByKinds")
    public String findByKinds( Goods goods,Model model){
        System.out.println("表现层：根据商品的种类kinds查询商品...");
        // 调用service的方法
        List<Goods> list = goodsService.findBykinds(goods);

        //用来处理要是在数据库中找不到该kinds的情况
        List<Goods> a = new ArrayList<>();
        if(list.equals(a)  ){
            model.addAttribute("kinds",goods.getKinds()); //用于回显数据
            model.addAttribute("msgkinds", "数据库没有该kinds，请重新输入！");
            System.out.println("数据库没有该kinds，请重新输入！");
            return "interface/goodsInterface";
        }

        System.out.println(list);
        model.addAttribute("list",list);
        return "goods/findByKinds";
    }


    //更新商品（并返回新商品的信息）
    @RequestMapping("/updateGoods")
    public String updateGoods(Goods goods,Model model){
        System.out.println("表现层：更新商品...");

        Goods goods2 = goodsService.findBygoodsId(goods);
        //用来处理要是在数据库中找不到该goodsId的情况
        if(goods2 == null  ){

            model.addAttribute("updateOpenId",goods.getOpenId()); //用于回显数据
            model.addAttribute("updateGoodsId",goods.getGoodsId()); //用于回显数据
            model.addAttribute("updateGoodsName",goods.getGoodsName()); //用于回显数据
            model.addAttribute("updateHowNew",goods.getHowNew()); //用于回显数据
            model.addAttribute("updatePictures",goods.getPictures()); //用于回显数据
            model.addAttribute("updateCost",goods.getCost()); //用于回显数据
            model.addAttribute("updateKinds",goods.getKinds()); //用于回显数据
            model.addAttribute("updateAmounts",goods.getAmounts()); //用于回显数据
            model.addAttribute("updateAddress",goods.getAddress()); //用于回显数据
            model.addAttribute("updatePhone",goods.getPhone()); //用于回显数据

            model.addAttribute("msgupdateGoods", "数据库没有该goodsId，请重新输入！");
            System.out.println("数据库没有该goodsId，请重新输入！");
            return "interface/goodsInterface";
        }


//        //把从小程序端传过来的json数据转化成可以存入数据库的类数据
//        JSONObject jsonObject= JSONObject.fromObject(goods);
//        Goods goods1= (Goods) JSONObject.toBean(jsonObject,Goods.class);

        // 调用service的方法
        goodsService.updateGoods(goods);
        System.out.println(goods);
        model.addAttribute("goods",goods);
        return "goods/updateGoods";
    }


    //添加新商品（并返回新商品信息）
    @RequestMapping("/saveGoods")
    public  String saveGoods( Goods goods,Model model){
        System.out.println("表现层：添加新商品...");

        System.out.println(model);
        Goods goods2 = goodsService.findBygoodsId(goods);
        //用来处理要是在数据库中已经有该goodsId的情况
        if(goods2 != null  ){

            model.addAttribute("updateOpenId",goods.getOpenId()); //用于回显数据
            model.addAttribute("updateGoodsId",goods.getGoodsId()); //用于回显数据
            model.addAttribute("updateGoodsName",goods.getGoodsName()); //用于回显数据
            model.addAttribute("updateHowNew",goods.getHowNew()); //用于回显数据
            model.addAttribute("updatePictures",goods.getPictures()); //用于回显数据
            model.addAttribute("updateCost",goods.getCost()); //用于回显数据
            model.addAttribute("updateKinds",goods.getKinds()); //用于回显数据
            model.addAttribute("updateAmounts",goods.getAmounts()); //用于回显数据
            model.addAttribute("updateAddress",goods.getAddress()); //用于回显数据
            model.addAttribute("updatePhone",goods.getPhone()); //用于回显数据

            model.addAttribute("msgsaveGoods", "数据库已经有该goodsId，请重新输入！");
            System.out.println("数据库已经有该goodsId，请重新输入！");
            return "interface/goodsInterface";
        }


//        //把从小程序端传过来的json数据转化成可以存入数据库的类数据
//        JSONObject jsonObject= JSONObject.fromObject(goods);
//        Goods goods1= (Goods) JSONObject.toBean(jsonObject,Goods.class);

        // 调用service的方法
        goodsService.saveGoods(goods);
        System.out.println(goods);
        model.addAttribute("goods",goods);
        return "goods/saveGoods";
    }


    //删除商品（并返回被删除的商品信息）
    @RequestMapping("/deleteGoods")
    public String deleteGoods(Goods goods,Model model) {
        System.out.println("表现层：删除商品...");
        Goods goods1 = goodsService.findBygoodsId(goods);

        //用来处理要是在数据库中找不到该goodsId的情况
        if(goods1 == null  ){
            model.addAttribute("msgdeleteGoods", "数据库没有该goodsId，请重新输入！");
            System.out.println("数据库没有该goodsId，请重新输入！");
            return "interface/goodsInterface";
        }

        // 调用service的方法
        goodsService.deleteGoods(goods);
        System.out.println(goods1);
        model.addAttribute("goods",goods1);
        return "goods/deleteGoods";
    }






}
