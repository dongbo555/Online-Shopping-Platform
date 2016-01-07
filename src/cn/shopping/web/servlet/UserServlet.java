package cn.shopping.web.servlet;


import cn.shopping.pojo.User;
import cn.shopping.service.UserService;
import cn.shopping.util.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 博 on 2016/1/4.
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserService();

    /**
     * 检查信息是否已经被注册
     *
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String ajaxValidateUserInfo(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
		 * 1. 获取用户名
		 */
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
		/*
		 * 2. 通过service得到校验结果
		 */
        int result = userService.ajaxValidateInfo(username, email, phone);
		/*
		 * 3. 发给客户端
		 */
        resp.getWriter().print(result);
        return null;
    }

    /**
     * ajax用户名是否注册校验
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String ajaxValidateUsername(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		/*
		 * 1. 获取用户名
		 */
        String username = req.getParameter("username");
		/*
		 * 2. 通过service得到校验结果
		 */
        boolean b = userService.ajaxValidateUsername(username);
		/*
		 * 3. 发给客户端
		 */
        resp.getWriter().print(b);
        return null;
    }

    /**
     * ajaxEmail是否注册校验
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String ajaxValidateEmail(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		/*
		 * 1. 获取用户名
		 */
        String email = req.getParameter("email");
		/*
		 * 2. 通过service得到校验结果
		 */
        boolean b = userService.ajaxValidateEmail(email);
		/*
		 * 3. 发给客户端
		 */
        resp.getWriter().print(b);
        return null;
    }


    /**
     * ajax 手机号是否注册校验
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String ajaxValidatePhone(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		/*
		 * 1. 获取用户名
		 */
        String phone = req.getParameter("phone");
		/*
		 * 2. 通过service得到校验结果
		 */
        boolean b = userService.ajaxValidatePhone(phone);
		/*
		 * 3. 发给客户端
		 */
        resp.getWriter().print(b);
        return null;
    }
    /**
     * 注册功能
     *
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String regist(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到User对象
		 */
        User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		/*
		 * 2. 校验之, 如果校验失败，保存错误信息，返回到register.jsp显示
		 */
        Map<String, String> errors = validateRegist(formUser, req.getSession());
        if (errors.size() > 0) {
            req.setAttribute("form", formUser);
            req.setAttribute("errors", errors);
            return "f:/signup.jsp";
        }
		/*
		 * 3. 使用service完成业务
		 */
        userService.regist(formUser);
		/*
		 * 4. 保存成功信息，转发到msg.jsp显示！
		 */
        req.setAttribute("code", "success");
        //req.setAttribute("msg", "注册功能！");
        return "f:/login.jsp";
    }

    private Map<String, String> validateRegist(User formUser, HttpSession session) {
        Map<String, String> errors = new HashMap<String, String>();
		/*
		 * 1. 校验登录名
		 */
        String username = formUser.getUsername();

        if (username == null || username.trim().isEmpty()) {
            errors.put("username", "用户名不能为空！");
        } else if (username.length() < 3 || username.length() > 20) {
            errors.put("username", "用户名长度必须在3~20之间！");
        } else if (userService.ajaxValidateUsername(username)) {
            errors.put("phone", "手机号已被注册！");
        }


		/*
		 * 2. 校验登录密码
		 */
        String password = formUser.getPassword();
        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空！");
        } else if (password.length() < 3 || password.length() > 20) {
            errors.put("password", "密码长度必须在3~20之间！");
        }
		
		/*
		 * 3. 确认密码校验
		 */
        String rePassword = formUser.getRePassword();
        if (rePassword == null || rePassword.trim().isEmpty()) {
            errors.put("rePassword", "确认密码不能为空！");
        } else if (!rePassword.equals(password)) {
            errors.put("rePassword", "两次输入不一致！");
        }
		
		/*
		 * 4. 校验email
		 */
        String email = formUser.getEmail();
        if (email == null || email.trim().isEmpty()) {
            errors.put("email", "Email不能为空！");
        } else if (!email.matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$")) {
            errors.put("email", "Email格式错误！");
        } else if (userService.ajaxValidateEmail(email)) {
            errors.put("email", "Email已被注册！");
        }

        /*
         * 5. 校验手机号
         */
        String phone = formUser.getPhone();
        if (phone == null || phone.trim().isEmpty()) {
            errors.put("phone", "手机号不能为空！");
        } else if (!phone.matches("[1][123456789][0-9]{9}$")) {
            errors.put("phone", "手机号格式错误!");
        } else if (userService.ajaxValidatePhone(phone)) {
            errors.put("phone", "手机号已被注册！");
        }

        return errors;
    }

    /**
     * 退出功能
     *
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String quit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getSession().invalidate();
        return "r:/login.jsp";
    }

    public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
		 * 1. 封装表单数据到User
		 * 2. 校验表单数据
		 * 3. 使用service查询，得到User
		 * 4. 查看用户是否存在，如果不存在：
		 *   * 保存错误信息：用户名或密码错误
		 *   * 保存用户数据：为了回显
		 *   * 转发到login.jsp
		 * 5. 如果存在，查看状态，如果状态为false：
		 *   * 保存错误信息：您没有激活
		 *   * 保存表单数据：为了回显
		 *   * 转发到login.jsp
		 * 6. 登录成功：
		 * 　　* 保存当前查询出的user到session中
		 *   * 保存当前用户的名称到cookie中，注意中文需要编码处理。
		 */
		/*
		 * 1. 封装表单数据到user
		 */
        Map map=new HashMap<String,String>();
        map.putAll(req.getParameterMap());
        if(map.containsKey("method"))
            map.remove("method");
        //System.out.println(map);
        User formUser = CommonUtils.toBean(map, User.class);
		/*
		 * 2. 校验
		 */
        Map<String, String> errors = validateLogin(formUser, req.getSession());
        if (errors.size() > 0) {
            req.setAttribute("form", formUser);
            req.setAttribute("errors", errors);
            return "f:/login.jsp";
        }

		/*
		 * 3. 调用userService#login()方法
		 */
        User user = userService.login(formUser);
		/*
		 * 4. 开始判断
		 */
        if (user == null) {
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("user", formUser);
            return "f:/login.jsp";
        } else {
            // 保存用户到session
            req.getSession().setAttribute("sessionUser", user);
            // 获取用户名保存到cookie中
            String userName = user.getUsername();
            userName = URLEncoder.encode(userName, "utf-8");
            Cookie cookie = new Cookie("username", userName);
            cookie.setMaxAge(60 * 60 * 24 * 10);//保存10天
            resp.addCookie(cookie);
            return "r:/index.jsp";//重定向到主页
        }
    }

    /*
	 * 登录校验方法，内容等你自己来完成
	 */
    private Map<String,String> validateLogin(User formUser, HttpSession session) {
        Map<String,String> errors = new HashMap<String,String>();
        return errors;
    }
}
