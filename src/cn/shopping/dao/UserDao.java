package cn.shopping.dao;

import cn.shopping.pojo.User;
import cn.shopping.util.DBhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 博 on 2016/1/4.
 */
public class UserDao {
    /**
     * 通过用户名和密码登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public boolean loginByUsername(String username,String password){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_user where username=? and password=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            rs=stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            releaseDB(rs,stmt,conn);
        }
    }

    /**
     * 通过email邮箱和密码登录
     * @param email 用户邮箱
     * @param password 密码
     * @return
     */
    public boolean loginUserByEmail(String email,String password){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_user where email=? and password=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,email);
            stmt.setString(2,password);
            rs=stmt.executeQuery();
           return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            releaseDB(rs,stmt,conn);
        }
    }

    /**
     * 通过手机号和密码登录
     * @param phone 手机号
     * @param password 密码
     * @return
     */
    public boolean loginUserByPhone(String phone,String password){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_user where phone=? and password=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,phone);
            stmt.setString(2,password);
            rs=stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            releaseDB(rs,stmt,conn);
        }
    }

    /**
     * 通过用户名和密码获取用户信息
     * @param username
     * @param password
     * @return
     */
    public User getUserByUsernameAndPassword(String username,String password){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_user where username=? and password=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            rs=stmt.executeQuery();
            if(rs.next()){
                User user=new User();
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setGender(rs.getString("sex"));
                user.setFace(rs.getString("face"));
                user.setPhone(rs.getString("phone"));
                user.setRegTime(rs.getTimestamp("regTime"));
                return user;
            }else{
                return null;
            }

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
     * 通过邮箱和密码获取用户信息
     * @param email
     * @param password
     * @return
     */
    public User getUserByEmailAndPassword(String email,String password){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_user where email=? and password=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,email);
            stmt.setString(2,password);
            rs=stmt.executeQuery();
            User user=new User();
            while(rs.next()){
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setGender(rs.getString("sex"));
                user.setFace(rs.getString("face"));
                user.setPhone(rs.getString("phone"));
                user.setRegTime(rs.getTimestamp("regTime"));
            }
            return user;
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
     * 通过手机号和密码获取用户信息
     * @param phone
     * @param password
     * @return
     */
    public User getUserByPhoneAndPassword(String phone,String password){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_user where phone=? and password=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,phone);
            stmt.setString(2,password);
            rs=stmt.executeQuery();
            User user=new User();
            while(rs.next()){
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setGender(rs.getString("sex"));
                user.setFace(rs.getString("face"));
                user.setPhone(rs.getString("phone"));
                user.setRegTime(rs.getTimestamp("regTime"));
            }
            return user;
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
     * 验证用户名是否已经存在
     * @param username
     * @return
     */
    public boolean ajaxValidateUsername(String username){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_user where username=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,username);
            rs=stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            releaseDB(rs,stmt,conn);
        }
    }

    /**
     * 验证邮箱是否已经存在
     * @param email
     * @return
     */
    public boolean ajaxValidateEmail(String email){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_user where email=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,email);
            rs=stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            releaseDB(rs,stmt,conn);
        }
    }

    /**
     * 验证手机号是否已经存在
     * @param phone
     * @return
     */
    public boolean ajaxValidatePhone(String phone){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="select * from shop_user where phone=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,phone);
            rs=stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            releaseDB(rs,stmt,conn);
        }
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public void addUser(User user){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= DBhelper.getConnection();
            String sql="insert into shop_user  (`username`, `password`, `sex`, `email`, `phone`,`face`)values(?,?,?,?,?,?)";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,user.getUsername());
            stmt.setString(2,user.getPassword());
            stmt.setString(3,user.getGender().equals("")?"保密":user.getGender());
            stmt.setString(4,user.getEmail());
            stmt.setString(5,user.getPhone());
            stmt.setString(6,user.getFace());
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

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
       UserDao userDao=new UserDao();
//        User user=userDao.getUserByPhoneAndPassword("123","fda");
//        System.out.println(user);
//        System.out.println(userDao.loginUserByPhone("123","fdda"));
        User user=new User();
        user.setPhone("4562");
        user.setGender("");
        user.setUsername("dongbo");
        user.setEmail("dongbo@");
        user.setPassword("123");
        System.out.println(userDao.ajaxValidatePhone(""));
    }
}
