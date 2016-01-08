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
                goods.setcId(rs.getString("cId"));
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

    /**
     * 查询指定分类下图书的个数
     * @param cid
     * @return
     * @throws SQLException
     */
    public int countGoodsByCategory(String cid) {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select count(*) from shop_pro where cId="+cid;
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            if(rs.next()){
                return rs.getInt("count(*)");
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        finally {
            releaseDB(rs,stmt,conn);
        }
    }

    /**
     * 通过商品名称查询
     * @param name
     * @return
     */
    public ArrayList<Goods> getGoodsByName(String name){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Goods> list=new ArrayList<Goods>();
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_pro where pName like '%"+name+"%'";
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
                goods.setcId(rs.getString("cId"));
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
    /**
     * 按类别查找商品
     * @param cid
     * @return
     */
    public ArrayList<Goods> getGoodsesByCategory(String cid){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Goods> list=new ArrayList<Goods>();
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_pro where cId="+cid;
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
                goods.setcId(rs.getString("cId"));
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
            releaseDB(rs,stmt,conn);
        }
    }
    public Goods getGoodsById(String id){
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
                goods.setcId(rs.getString("cId"));
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
     * 删除商品
     * @param id
     */
    public void delete(int id){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="delete from shop_pro where id="+id;
            stmt=conn.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
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
                DBhelper.setConn(null);
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
        Goods goods=goodsDao.getGoodsById("1");
        System.out.println(goods.getId());
        System.out.println(goods.getName());
        System.out.println(goods.getNumber());
        System.out.println(goods.getPrice());
        System.out.println(goodsDao.getGoodsByName("shop").size());
    }


}
