<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="cn.shopping.pojo.Cart" %>
<%@ page import="cn.shopping.pojo.Goods" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>购物车</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <link type="text/css" rel="stylesheet" href="style/style.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="js/ie6Fixpng.js"></script>
    <![endif]-->
    <script type="text/javascript" src="js/cart.js"></script>

</head>

<body>
<div class="headerBar">
    <div class="topBar">
        <div class="comWidth">
            <div class="leftArea">
                <a href="#" class="collection">收藏慕课</a>
            </div>
            <div class="rightArea">
                <%-- 根据用户是否登录，显示不同的链接 --%>
                <c:choose>
                    <c:when test="${empty sessionScope.sessionUser }">
                        欢迎来到慕课网！<a href="/login.jsp">[登录]</a><a href="signup.jsp">[免费注册]</a>
                    </c:when>
                    <c:otherwise>
                        <span>欢迎您</span>${sessionScope.sessionUser.username}&nbsp;
                        <a href="<c:url value='/UserServlet?method=quit'/>" target="_parent">[退出]</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
    <div class="logoBar">
        <div class="comWidth">
            <%--<div class="logo fl">--%>
            <%--<a href="#"><img src="images/logo.jpg" alt="慕课网"></a>--%>
            <%--</div>--%>
            <div class="stepBox fr">
                <div class="step"></div>
                <ul class="step_text">
                    <li class="s01 active">我的购物车</li>
                    <li class="s02">填写核对订单</li>
                    <li class="s03">订单提交成功</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="shoppingCart comWidth">
    <div class="shopping_item">
        <table id="cartTable">
            <thead>
            <tr>
                <th><label><input class="check-all check" type="checkbox"/>&nbsp;全选</label></th>
                <th>商品</th>
                <th>单价</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%
                //首先判断session中是否有购物车对象
                if (request.getSession().getAttribute("cart") != null) {
            %>
            <!-- 循环的开始 -->
            <%
                Cart cart = (Cart) request.getSession().getAttribute("cart");
                HashMap<Goods, Integer> goods = cart.getGoodsMap();
                Set<Goods> items = goods.keySet();
                Iterator<Goods> it = items.iterator();

                while (it.hasNext()) {
                    Goods i = it.next();
            %>
            <tr>
                <td class="checkbox"><input class="check-one check" type="checkbox"/></td>
                <td class="goodsMap"><img class="cart_img" src="images/1.jpg"
                                          alt=""/><span><%=i.getName().substring(0, 15)%></span></td>
                <td class="price"><%=i.getPrice() %>
                </td>
                <td class="count">
                    <span class="reduce">-</span>
                    <input class="count-input" type="text" value="<%=goods.get(i)%>"/>
                    <span class="add">+</span></td>
                <td class="subtotal"><%=goods.get(i) * i.getPrice()%>
                </td>
                <td class="operation"><span class="delete">删除</span></td>
            </tr>
            <%
                }
            %>
            <!--循环的结束-->
            </tbody>
        </table>

    </div>
    <div class="hr_25"></div>
    <div class="shopping_item">
        <h3 class="shopping_tit">订单结算</h3>

        <%--<div class="cart_count fr">--%>
        <%--<div class="cart_rmb">--%>
        <%--<i>总计：</i><span>￥145000009.00</span>--%>
        <%--</div>--%>
        <%--<div class="cart_btnBox">--%>
        <%--<input type="button" class="cart_btn" value="提交订单">--%>
        <%--</div>--%>
        <%--</div>--%>
        <div class="foot" id="foot">
            <label class="fl select-all"><input type="checkbox" class="check-all check"/>&nbsp;全选</label>
            <a class="fl delete" id="deleteAll" href="javascript:;">删除</a>
            <div class="fr closing">结 算</div>
            <div class="fr total">合计：￥<span id="priceTotal">0.00</span></div>
            <div class="fr selected" id="selected">已选商品
                <span id="selectedTotal">0</span>件
                <span class="arrow up">︽</span>
                <span class="arrow down">︾</span>
            </div>
            <div class="selected-view">
                <div id="selectedViewList" class="clearfix">
                    <!--<div><img src="images/1.jpg"><span>取消选择</span></div>-->
                </div>
                <span class="arrow">◆<span>◆</span></span>
            </div>
        </div>
        <%
            }
        %>

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
