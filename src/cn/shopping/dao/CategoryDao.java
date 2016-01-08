package cn.shopping.dao;

import cn.shopping.pojo.Category;
import cn.shopping.util.DBhelper;
import sun.util.resources.cldr.to.CalendarData_to_TO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 博 on 2016/1/8.
 */
public class CategoryDao {

    public Category getCategoryById(String id){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_cate where id="+id;
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            Category category=new Category();
            if(rs.next()){
                category.setId(rs.getInt("id"));
                category.setName((rs.getString("cName")));
            }
            return category;
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
     * 获取所有类别
     * @return
     */
    public ArrayList<Category> getCategories(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_cate";
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            ArrayList<Category> categories=new ArrayList<Category>();
            while(rs.next()){
                Category category=new Category();
                category.setId(rs.getInt("id"));
                category.setName((rs.getString("cName")));
                categories.add(category);
            }
            return categories;
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
                DBhelper.setConn(null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        CategoryDao categoryDao=new CategoryDao();
        ArrayList<Category> category=categoryDao.getCategories();
        System.out.println(category);
    }
}
