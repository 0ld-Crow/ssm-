package cn.itcast.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品
 */
public class Goods implements Serializable{

    private String openId;              //商品所属的卖家的userId
    private int goodsId;                //商品的Id
    private String goodsName;           //商品的名字
    private float howNew;               //商品几成新
    private String pictures;            //商品的外观照片
    private float cost;                 //商品的价格
    private String kinds;               //商品所属的种类
    private int amounts;                //商品的数量
    private String address;             //商品所在的地址
    private String phone;               //买该商品的联系电话





    //建立起goods和user的一对一映射关系
    private Users seller;

    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getHowNew() {
        return howNew;
    }

    public void setHowNew(float howNew) {
        this.howNew = howNew;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public int getAmounts() {
        return amounts;
    }

    public void setAmounts(int amounts) {
        this.amounts = amounts;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "openId='" + openId + '\'' +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", howNew=" + howNew +
                ", pictures='" + pictures + '\'' +
                ", cost=" + cost +
                ", kinds='" + kinds + '\'' +
                ", amounts=" + amounts +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", seller=" + seller +
                '}';
    }
}
