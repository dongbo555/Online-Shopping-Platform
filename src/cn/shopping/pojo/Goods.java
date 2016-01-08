package cn.shopping.pojo;

import java.util.Date;

/**
 * Created by 博 on 2016/1/4.
 */
public class Goods {
    private String name;
    private float price;
    private String number;//商品数量
    private String serialNum; //商品编号
    private String introduction; //商品简介
    private Date pubTime; //上架时间
    private String cId; //商品类别
    private int id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        if(pubTime!=null){
            this.pubTime=new Date(pubTime.getTime());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
