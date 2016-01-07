package cn.shopping.service;

import cn.shopping.dao.UserDao;
import cn.shopping.pojo.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 博 on 2016/1/5.
 */
public class UserService {
    private UserDao userDao = new UserDao();

    /**
     * 用户登录，并获取用户信息
     * @param user
     * @return
     */
    public User login(User user) {
        if (user.getUsername().length() != 0)
            return userDao.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        else if (isEmail(user.getEmail()))
            return userDao.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        else if (isPhone(user.getPhone())) {
            return userDao.getUserByPhoneAndPassword(user.getPhone(), user.getPassword());
        }
        return null;
    }

    public boolean checkLogin(User user){
        if (user.getUsername().length() != 0)
            return userDao.loginByUsername(user.getUsername(), user.getPassword());
        else if (isEmail(user.getEmail()))
            return userDao.loginUserByEmail(user.getEmail(), user.getPassword());
        else if (isPhone(user.getPhone())) {
            return userDao.loginUserByPhone(user.getPhone(), user.getPassword());
        }
        return false;
    }

    /**
     * 验证email是否正确
     * @param email
     * @return
     */
    public boolean isEmail(String email) {
        if (email == null || email.equals(""))
            return false;
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = pattern.matcher(email);
        return m.matches();
    }

    /**
     * 验证手机号是否正确
     * @param phone
     * @return
     */
    public boolean isPhone(String phone) {
        if (phone == null || phone.equals(""))
            return false;
        Pattern pattern = Pattern.compile("^[1][123456789][0-9]{9}$");
        Matcher m = pattern.matcher(phone);
        return m.matches();
    }

    /**
     * 验证用户名、邮箱和手机是否唯一
     * @param username
     * @param email
     * @param phone
     * @return 0表示未注册，结果用二进制表示的话，最低位为1表示用户名已注册，中间位为1表示邮箱已注册，最高位为1表示手机号已注册
     */
    public int ajaxValidateInfo(String username,String email,String phone){
        if(!userDao.ajaxValidateUsername(username) && !userDao.ajaxValidateEmail(email) && !userDao.ajaxValidatePhone(phone)){
            return 0;
        }
        int result=0;
        if(userDao.ajaxValidateUsername(username)){
            result+=1;
        }
        if(userDao.ajaxValidateEmail(email)){
            result+=2;
        }
        if(userDao.ajaxValidatePhone(phone))
            result+=4;
        return result;
    }

    /**
     * 验证用户名是否已经被注册
     * @param username
     * @return
     */
    public boolean ajaxValidateUsername(String username){
        return userDao.ajaxValidateUsername(username);
    }

    /**
     * 验证Email是否已经被注册
     * @param email
     * @return
     */
    public boolean ajaxValidateEmail(String email){
        return userDao.ajaxValidateEmail(email);
    }

    /**
     * 验证手机号是否已经被注册
     * @param phone
     * @return
     */
    public boolean ajaxValidatePhone(String phone){
        return userDao.ajaxValidatePhone(phone);
    }

    /**
     * 注册功能
     * @param user
     */
    public void regist(User user){
        userDao.addUser(user);
    }

    public static void main(String[] args){
        UserService userService=new UserService();
        User user=new User();
        //user.setPhone("13167316684");
       // user.setGender("");
        user.setUsername("dongbo");
        //user.setEmail("dongbo555@foxmail.com");
        user.setPassword("123");
        //userService.regist(user);
        System.out.println(userService.login(user));
        //System.out.println(userService.checkLogin(user));
    }
}
