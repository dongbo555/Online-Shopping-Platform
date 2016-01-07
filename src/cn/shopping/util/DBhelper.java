package cn.shopping.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by 博 on 2016/1/4.
 */
public class DBhelper {
    private static final String driver="com.mysql.jdbc.Driver"; //数据库驱动

    private static final String url="jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
    private static final String username="root";
    private static final String password="dong123";
    private static Connection conn=null;

    static{
        try {
            Class.forName(driver);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        if(conn==null)
        {
            conn= DriverManager.getConnection(url,username,password);
            return conn;
        }
        return conn;
    }

    public static void setConn(Connection conn) {
        DBhelper.conn = conn;
    }

    public static void main(String[] args){
        try{
            Connection conn=DBhelper.getConnection();
            if(conn!=null){
                System.out.println("数据库连接正常！");
            }else{
                System.out.println("数据库连接异常！");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
