package cn.itcast.domain;


import java.io.Serializable;
import java.util.List;

/**
 * 用户
 */
public class Users implements Serializable {

    private String openId;                  //用户的id
    private String nickName;                //用户的名字
    private String avatarUrl;               //用户头像链接
    private int gender;                     //用户的性别
    private String phone;                   //用户的联系电话
    private String address;                 //用户的地址



    //建立起用户和商品一对多的操作
    private List<Goods> goodsList;

//    private List<Orders> ordersList;
//
//    public List<Orders> getOrdersList() {
//        return ordersList;
//    }
//
//    public void setOrdersList(List<Orders> ordersList) {
//        this.ordersList = ordersList;
//    }


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
