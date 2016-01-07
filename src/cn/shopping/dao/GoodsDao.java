package cn.shopping.dao;

import cn.shopping.pojo.Goods;
import cn.shopping.util.DBhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 博 on 2016/1/4.
 */
public class GoodsDao {
    //获取所有的商品信息
    public ArrayList<Goods> getAllGoods(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Goods> list=new ArrayList<Goods>();
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_pro";
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
                Goods goods=new Goods();
                goods.setId(rs.getInt("id"));
                goods.setName(rs.getString("pName"));
                goods.setNumber(rs.getString("pNum"));
                goods.setPrice(rs.getFloat("iPrice"));
                goods.setIntroduction(rs.getString("pDesc"));
                goods.setPubTime(rs.getTimestamp("pubTime"));
                list.add(goods);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            //释放结果集对象
            releaseDB(rs,stmt,conn);
        }
    }

    public Goods getGoodsById(int id){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_pro where id="+id;
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            Goods goods=new Goods();
            while(rs.next()){

                goods.setId(rs.getInt("id"));
                goods.setName(rs.getString("pName"));
                goods.setNumber(rs.getString("pNum"));
                goods.setPrice(rs.getFloat("iPrice"));
                goods.setIntroduction(rs.getString("pDesc"));
                goods.setPubTime(rs.getTimestamp("pubTime"));
            }
            return goods;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            releaseDB(rs,stmt,conn);
        }
    }
    /**
     * 释放数据库资源的方法
     *
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void releaseDB(ResultSet resultSet, PreparedStatement statement,
                                 Connection connection) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String [] args){
        GoodsDao goodsDao=new GoodsDao();
//        ArrayList<Goods> goodses=goodsDao.getAllGoods();
//        for (Goods goods:goodses){
//            System.out.println(goods.getId());
//            System.out.println(goods.getName());
//            System.out.println(goods.getNumber());
//            System.out.println(goods.getPrice());
//        }
        Goods goods=goodsDao.getGoodsById(1);
        System.out.println(goods.getId());
        System.out.println(goods.getName());
        System.out.println(goods.getNumber());
        System.out.println(goods.getPrice());
    }


}
