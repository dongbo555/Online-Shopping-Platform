<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="js/ie6Fixpng.js"></script>
    <![endif]-->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/regist.js"></script>
</head>

<body>
<div class="headerBar">
    <div class="logoBar red_logo">
        <div class="comWidth">
            <div class="logo fl">
                <a href="#"><img src="images/logo.jpg" alt="慕课网"></a>
            </div>
            <h3 class="welcome_title">欢迎注册</h3>
        </div>
    </div>
</div>

<div class="regBox">
    <div class="login_cont">
        <form action="/UserServlet" method="post" id="registForm" >
            <input type="hidden" name="method" value="regist"/>
            <ul class="login">
                <li><span class="reg_item"><i>*</i>账户名：</span>
                    <div class="input_item"><input type="text" id="username" name="username" class="login_input user_icon"></div>
                    <label id="usernameError" class="error errorClass">${errors.username}</label>
                </li>
                <li><span class="reg_item"><i>*</i>密码：</span>
                    <div class="input_item"><input type="password" id="password" name="password" class="login_input user_icon"></div>
                    <label class="errorClass" id="passwordError">${errors.password }</label>
                </li>
                <li><span class="reg_item"><i>*</i>确认密码：</span>
                    <div class="input_item"><input type="password" id="repassword"  name="rePassword" class="login_input user_icon"></div>
                    <label class="errorClass" id="repasswordError">${errors.rePassword }</label>
                </li>
                <li><span class="reg_item"><i>*</i>性别：</span><div class="input_item">
                    <input type="radio"  name="gender" value="男"> 男
                    <input type="radio"  checked="checked" name="gender" value="女" > 女
                    <input type="radio"  name="gender" value="保密" > 保密
                </div></li>
                <li><span class="reg_item"><i>*</i>邮箱：</span>
                    <div class="input_item"><input type="text" id="email" name="email" class="login_input user_icon"></div>
                    <label class="errorClass" id="emailError">${errors.email}</label>
                </li>
                <li><span class="reg_item"><i>*</i>手机号：</span>
                    <div class="input_item"><input type="text"id="phone" name="phone" class="login_input user_icon"></div>
                    <label class="errorClass" id="phoneError">${errors.phone}</label>
                </li>
                <li class="autoLogin"><span class="reg_item">&nbsp;</span><input type="checkbox" id="t1"
                                                                                 class="checked"><label for="t1">我同意什么什么条款</label>
                </li>
                <li><span class="reg_item">&nbsp;</span><input type="submit" value="注册" class="signup_btn"></li>
            </ul>
        </form>
    </div>
</div>

<div class="hr_25"></div>
<div class="footer">
    <p><a href="#">慕课简介</a><i>|</i><a href="#">慕课公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234
    </p>
    <p>Copyright &copy; 2006 - 2014 慕课版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p>
    <p class="web"><a href="#"><img src="images/webLogo.jpg" alt="logo"></a><a href="#"><img src="images/webLogo.jpg"
                                                                                             alt="logo"></a><a href="#"><img
            src="images/webLogo.jpg" alt="logo"></a><a href="#"><img src="images/webLogo.jpg" alt="logo"></a></p>
</div>
</body>
</html>
