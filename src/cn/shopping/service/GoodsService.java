package cn.shopping.service;

import cn.shopping.dao.GoodsDao;
import cn.shopping.pojo.Goods;

import java.util.ArrayList;

/**
 * Created by 博 on 2016/1/7.
 */
public class GoodsService {
    GoodsDao goodsDao=new GoodsDao();

    public ArrayList<Goods> getAllGoodses(){
        return goodsDao.getAllGoods();
    }

    public Goods getGoodsById(String id){
        return goodsDao.getGoodsById(id);
    }

    public ArrayList<Goods> getGoodsesByCategory(String cid){
        return goodsDao.getGoodsesByCategory(cid);
    }

    public ArrayList<Goods> getGoodsByName(String name){
        return goodsDao.getGoodsByName(name);
    }

    public void delete(int id){
        goodsDao.delete(id);
    }

    public int countGoodsByCatagory(String cid){
        return goodsDao.countGoodsByCategory(cid);
    }


}
