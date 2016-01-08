<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>商品介绍</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="js/ie6Fixpng.js"></script>
    <![endif]-->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/detail.js"></script>


</head>

<body class="grey">
<div class="headerBar">
    <div class="topBar">
        <div class="comWidth">
            <div class="leftArea">
                <a href="#" class="collection">收藏此网</a>
            </div>
            <div class="rightArea">
                <%-- 根据用户是否登录，显示不同的链接 --%>
                <c:choose>
                    <c:when test="${empty sessionScope.sessionUser }">
                        欢迎来到网上网！<a href="/login.jsp">[登录]</a><a href="signup.jsp">[免费注册]</a>
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
            <div class="search_box fl">
                <input type="text" class="search_text fl">
                <input type="button" value="搜 索" class="search_btn fr">
            </div>
            <div class="shopCar fr">
                <span class="shopText fl"><a href="/CartServlet?method=showCart">购物车</a></span>
                <span class="shopNum fl">${size}</span>
            </div>
        </div>
    </div>

</div>
<div class="userPosition comWidth">
    <strong><a href="#">首页</a></strong>
    <span>&nbsp;&gt;&nbsp;</span>
    <a href="#">${category.name}</a>
    <span>&nbsp;&gt;&nbsp;</span>
    <em>MD531CH/A</em>
</div>
<div class="description_info comWidth">
    <div class="description clearfix">
        <div class="leftArea">
            <div class="description_imgs">
                <div class="big">
                    <img src="images/des_big.jpg" alt="">
                </div>
                <ul class="des_smimg clearfix">
                    <li><a href="#"><img src="images/des_sm.jpg" class="active" alt=""></a></li>
                    <li><a href="#"><img src="images/des_sm2.jpg" alt=""></a></li>
                    <li><a href="#"><img src="images/des_sm.jpg" alt=""></a></li>
                    <li><a href="#"><img src="images/des_sm2.jpg" alt=""></a></li>
                    <li><a href="#"><img src="images/des_sm.jpg" alt=""></a></li>
                </ul>
            </div>
        </div>
        <div class="rightArea">
            <form action="/CartServlet" method="post" target="_top">
                <input type="hidden" name="method" value="addToCart"/>
                <input type="hidden" name="id" value="${goods.id }"/>
                <div class="des_content">
                    <h3 class="des_content_tit">${goods.name}</h3>
                    <div class="dl clearfix">
                        <div class="dt">网上价</div>
                        <div class="dd clearfix"><span class="des_money"><em>￥</em>${goods.price}</span></div>
                    </div>
                    <div class="dl clearfix">
                        <div class="dt">优惠</div>
                        <div class="dd clearfix"><span class="hg"><i
                                class="hg_icon">满换购</i><em>购ipad加价优惠够配件或USB充电插座</em></span></div>
                    </div>
                    <div class="des_position">
                        <div class="dl clearfix">
                            <div class="dt">送到</div>
                            <div class="dd clearfix">
                                <div class="select">
                                    <h3>海淀区五环内</h3><span></span>
                                    <ul class="show_select">
                                        <li>上帝</li>
                                        <li>五道口</li>
                                        <li>上帝</li>
                                    </ul>
                                </div>
                                <span class="theGoods">有货，可当日出货</span>
                            </div>
                        </div>
                        <div class="dl clearfix">
                            <div class="dt colorSelect">选择颜色</div>
                            <div class="dd clearfix">
                                <div class="des_item des_item_acitve">
                                    WIFI 16GB
                                </div>
                                <div class="des_item">
                                    WIFI 16GB
                                </div>
                                <div class="des_item">
                                    WIFI 16GB
                                </div>
                            </div>
                        </div>
                        <div class="dl clearfix">
                            <div class="dt des_select_more">选择版本</div>
                            <div class="dd clearfix ">
                                <div class="des_item des_item_sm des_item_acitve">
                                    WIFI 16GB
                                </div>
                                <div class="des_item des_item_sm">
                                    WIFI 16GB + 3G
                                </div>
                                <div class="des_item des_item_sm">
                                    WIFI + 3G
                                </div>
                                <div class="des_item des_item_sm">
                                    WIFI 16GB
                                </div>
                                <div class="des_item des_item_sm">
                                    WIFI 16GB + 3G
                                </div>
                                <div class="des_item des_item_sm">
                                    WIFI + 3G
                                </div>
                                <div class="des_item des_item_sm">
                                    WIFI 16GB
                                </div>
                                <div class="des_item des_item_sm">
                                    WIFI 16GB + 3G
                                </div>
                                <div class="des_item des_item_sm">
                                    WIFI + 3G
                                </div>
                            </div>
                        </div>
                        <div class="dl">
                            <div class="dt des_num">数量</div>
                            <div class="dd clearfix">
                                <div class="des_number">
                                    <div class="reduction">-</div>
                                    <div class="des_input">
                                        <input type="text" value="1" name="num" id="number">
                                    </div>
                                    <div class="plus">+</div>
                                </div>
                                <span class="xg">限购<em id="xg">${goods.number}</em>件</span>
                            </div>
                        </div>
                    </div>
                    <div class="des_select">
                        已选择 <span>"白色|WIFI 16G"</span>
                    </div>
                    <div class="shop_buy">
                        <a href="javascript:$('form').submit();" target="_top" class="shopping_btn" ></a>
                        <span class="line"></span>
                        <a href="javascript:void(0)" class="buy_btn">立即购买</a>
                    </div>
                    <div class="notes">
                        注意：此商品可提供普通发票，不提供增值税发票。
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="hr_15"></div>
<div class="des_info comWidth clearfix">
    <div class="leftArea">
        <div class="recommend">
            <h3 class="tit">同价位</h3>
            <div class="item">
                <div class="item_cont">
                    <div class="img_item">
                        <a href="#"><img src="images/shopImg.jpg" alt=""></a>
                    </div>
                    <p><a href="#">文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</a></p>
                    <p class="money">￥888</p>
                </div>
            </div>
            <div class="item">
                <div class="item_cont">
                    <div class="img_item">
                        <a href="#"><img src="images/shopImg.jpg" alt=""></a>
                    </div>
                    <p><a href="#">文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</a></p>
                    <p class="money">￥888</p>
                </div>
            </div>
            <div class="item">
                <div class="item_cont">
                    <div class="img_item">
                        <a href="#"><img src="images/shopImg.jpg" alt=""></a>
                    </div>
                    <p><a href="#">文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</a></p>
                    <p class="money">￥888</p>
                </div>
            </div>
        </div>
        <div class="hr_15"></div>
        <div class="recommend">
            <h3 class="tit">同价位</h3>
            <div class="item">
                <div class="item_cont">
                    <div class="img_item">
                        <a href="#"><img src="images/shopImg.jpg" alt=""></a>
                    </div>
                    <p><a href="#">文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</a></p>
                    <p class="money">￥888</p>
                </div>
            </div>
            <div class="item">
                <div class="item_cont">
                    <div class="img_item">
                        <a href="#"><img src="images/shopImg.jpg" alt=""></a>
                    </div>
                    <p><a href="#">文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</a></p>
                    <p class="money">￥888</p>
                </div>
            </div>
            <div class="item">
                <div class="item_cont">
                    <div class="img_item">
                        <a href="#"><img src="images/shopImg.jpg" alt=""></a>
                    </div>
                    <p><a href="#">文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</a></p>
                    <p class="money">￥888</p>
                </div>
            </div>
        </div>
    </div>
    <div class="rightArea">
        <div class="des_infoContent">
            <ul class="des_tit">
                <li class="active"><span>产品介绍</span></li>
                <li><span>产品评价(12312)</span></li>
            </ul>
            <div class="ad">
                <a href="#"><img src="images/ad.jpg"></a>
            </div>
            <div class="info_text">
                ${goodsMap.introduction}
            </div>
        </div>
        <div class="hr_15"></div>
        <div class="des_infoContent">
            <h3 class="shopDes_tit">商品评价</h3>
            <div class="score_box clearfix">
                <div class="score">
                    <span>4.7</span><em>分</em>
                </div>
                <div class="score_speed">
                    <ul class="score_speed_text">
                        <li class="speed_01">非常不满意</li>
                        <li class="speed_02">不满意</li>
                        <li class="speed_03">一般</li>
                        <li class="speed_04">满意</li>
                        <li>非常满意</li>
                    </ul>
                    <div class="score_num">
                        4.7<i></i>
                    </div>
                    <p>共18939位网上网友参与评分</p>
                </div>
            </div>
            <div class="review_tab">
                <ul class="review fl">
                    <li><a href="#" class="active">全部</a></li>
                    <li><a href="#">满意（3121）</a></li>
                    <li><a href="#">一般（321）</a></li>
                    <li><a href="#">不满意（1121）</a></li>
                </ul>
                <div class="review_sort fr">
                    <a href="#" class="review_time">时间排序</a><a href="#" class="review_reco">推荐排序</a>
                </div>
            </div>
            <div class="review_listBox">
                <div class="review_list clearfix">
                    <div class="review_userHead fl">
                        <div class="review_user">
                            <img src="images/userhead.jpg" alt="">
                            <p>61***42</p>
                            <p>金色会员</p>
                        </div>
                    </div>
                    <div class="review_cont">
                        <div class="review_t clearfix">
                            <div class="starsBox fl"><span class="stars"></span><span class="stars"></span><span
                                    class="stars"></span><span class="stars"></span><span class="stars"></span></div>
                            <span class="stars_text fl">5分 满意</span>
                        </div>
                        <p>赖网上挺不错的信赖网上挺不错的，信赖网上</p>
                        <p><a href="#" class="ding">顶(0)</a><a href="#" class="cai">踩(0)</a></p>
                    </div>
                </div>
                <div class="review_list clearfix">
                    <div class="review_userHead fl">
                        <div class="review_user">
                            <img src="images/userhead.jpg" alt="">
                            <p>61***42</p>
                            <p>金色会员</p>
                        </div>
                    </div>
                    <div class="review_cont">
                        <div class="review_t clearfix">
                            <div class="starsBox fl"><span class="stars"></span><span class="stars"></span><span
                                    class="stars"></span><span class="stars"></span><span class="stars"></span></div>
                            <span class="stars_text fl">5分 满意</span>
                        </div>
                        <p>赖网上挺不错的信赖网上挺不错的，信赖网上</p>
                        <p><a href="#" class="ding">顶(0)</a><a href="#" class="cai">踩(0)</a></p>
                    </div>
                </div>
                <div class="hr_25"></div>
            </div>
        </div>
    </div>
</div>
<div class="hr_25"></div>
<div class="footer">
    <p><a href="#">网上简介</a><i>|</i><a href="#">网上公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234
    </p>
    <p>Copyright &copy; 2006 - 2014 网上版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p>
    <p class="web"><a href="#"><img src="images/webLogo.jpg" alt="logo"></a><a href="#"><img src="images/webLogo.jpg"
                                                                                             alt="logo"></a><a href="#"><img
            src="images/webLogo.jpg" alt="logo"></a><a href="#"><img src="images/webLogo.jpg" alt="logo"></a></p>
</div>
</body>
</html>
