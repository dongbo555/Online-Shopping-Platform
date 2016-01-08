package cn.shopping.pojo;

import cn.shopping.dao.GoodsDao;

import java.util.*;

/**
 * Created by 博 on 2016/1/8.
 */
public class Cart {
    private HashMap<Goods, Integer> goodsMap;

    private double totalPrice;
    //构造方法
    public Cart()
    {
        goodsMap = new HashMap<Goods,Integer>();
        totalPrice = 0.0;
    }


    public HashMap<Goods, Integer> getGoodsMap() {
        return goodsMap;
    }

    public void setGoodsMap(HashMap<Goods, Integer> goodsMap) {
        this.goodsMap = goodsMap;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //添加商品进购物车的方法
    public boolean addGoodsInCart(Goods goods ,int number)
    {
        if(goodsMap.containsKey(goods))
        {
            goodsMap.put(goods, goodsMap.get(goods)+number);
        }
        else
        {
            goodsMap.put(goods, number);
        }
        calTotalPrice(); //重新计算购物车的总金额
        return true;
    }

    //删除商品的方法
    public boolean removeGoodsFromCart(Goods goods)
    {
        goodsMap.remove(goods);
        calTotalPrice(); //重新计算购物车的总金额
        return true;
    }

    //统计购物车的总金额
    public double calTotalPrice()
    {
        double sum = 0.0;
        Set<Goods> keys = goodsMap.keySet(); //获得键的集合
        Iterator<Goods> it = keys.iterator(); //获得迭代器对象
        while(it.hasNext())
        {
            Goods i = it.next();
            sum += i.getPrice()* goodsMap.get(i);
        }
        this.setTotalPrice(sum); //设置购物车的总金额
        return this.getTotalPrice();
    }

    public static void main(String[] args) {

        //先创建两个商品对象
//        Items i1 = new Items(1,"沃特篮球鞋","温州",200,500,"001.jpg");
//        Items i2 = new Items(2,"李宁运动鞋","广州",300,500,"002.jpg");
//        Items i3 = new Items(1,"沃特篮球鞋","温州",200,500,"001.jpg");

        GoodsDao goodsDao=new GoodsDao();
        ArrayList<Goods> goodses=goodsDao.getGoodsesByCategory("1");
        Cart c = new Cart();
        System.out.println(goodses.get(0).getPrice());
        c.addGoodsInCart(goodses.get(0), 1);
        c.addGoodsInCart(goodses.get(0), 2);
        //再次购买沃特篮球鞋，购买3双
        c.addGoodsInCart(goodses.get(0), 3);


        //变量购物商品的集合
        Set<Map.Entry<Goods, Integer>> items= c.getGoodsMap().entrySet();
        for(Map.Entry<Goods, Integer> obj:items)
        {
            System.out.println(obj);
        }


        System.out.println("购物车的总金额："+c.getTotalPrice());

    }
}
