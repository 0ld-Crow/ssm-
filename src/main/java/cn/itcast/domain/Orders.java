package cn.itcast.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public class Orders implements Serializable {

    private int orderId;                //订单的id
    private int goodsId;                //商品的id
    private String sellerId;            //卖家的id
    private String buyerId;             //买家的id
    private Date dateTime;              //交易时间
    private String comments;            //留言
    private boolean flag;               //是否同意卖

    //建立起Order和User的一对一（买家和卖家）/Goods的一对一（商品）的映射关系
    private Goods goods;
    private Users buyer;
    private Users seller;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Users getBuyer() {
        return buyer;
    }

    public void setBuyer(Users buyer) {
        this.buyer = buyer;
    }

    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", sellerId='" + sellerId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", dateTime=" + dateTime +
                ", comments='" + comments + '\'' +
                ", flag=" + flag +
                ", goods=" + goods +
                ", buyer=" + buyer +
                ", seller=" + seller +
                '}';
    }
}