<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>购物车</title>
<link type="text/css" rel="stylesheet" href="style/reset.css">
<link type="text/css" rel="stylesheet" href="style/main.css">
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="js/ie6Fixpng.js"></script>
<![endif]-->
</head>

<body>
<div class="headerBar">
	<div class="topBar">
		<div class="comWidth">
			<div class="leftArea">
				<a href="#" class="collection">收藏慕课</a>
			</div>
			<div class="rightArea">
				欢迎来到慕课网！<a href="#">[登录]</a><a href="#">[免费注册]</a>
			</div>
		</div>
	</div>
	<div class="logoBar">
		<div class="comWidth">
			<div class="logo fl">
				<a href="#"><img src="images/logo.jpg" alt="慕课网"></a>
			</div>
			<div class="stepBox fr">
				<div class="step"></div>
				<ul class="step_text">
					<li class="s01 active">我的购物车</li>
					<li class="s02 active">填写核对订单</li>
					<li class="s03">订单提交成功</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="shoppingCart comWidth">
	<div class="shopping_item">
		<h3 class="shopping_tit">收货地址</h3>
		<div class="shopping_cont padding_shop">
			<ul class="shopping_list">
				<li><span class="shopping_list_text"><em>*</em>选择地区：</span>
					<div class="select">
						<h3>海淀区五环内</h3><span></span>
						<ul class="show_select">
							<li>上帝</li>
							<li>五道口</li>
							<li>上帝</li>
						</ul>
					</div>
				</li>
				<li><span class="shopping_list_text"><em>*</em>详细地址：</span><input type="text" value="最多输入20个汉字" class="input input_b"></li>
				<li><span class="shopping_list_text"><em>*</em>收 货 人：</span><input type="text" value="最多10个" class="input"></li>
				<li><span class="shopping_list_text"><em>*</em>手	机：</span><input type="text" value="如：12312312" class="input"><span class="cart_tel">&nbsp;或固定电话：</span><input type="text" class="input input_s"><span class="jian">-</span><input type="text" class="input input_s2"><span class="jian">-</span><input type="text" class="input input_s2"></li>
				<li><input type="button" class="affirm"></li>
			</ul>
		</div>
	</div>
	<div class="hr_25"></div>
	<div class="shopping_item">
		<h3 class="shopping_tit">支付方式</h3>
		<div class="shopping_cont padding_shop">
			<ul class="shopping_list">
				<li><input type="radio" class="radio" id="r1"><label for="r1">微信支付</label>微信支付微信支付微信支付</li>
				<li><input type="radio" class="radio" id="r2"><label for="r2">微信支付</label>微信支付微信支付微信支付</li>
			</ul>
		</div>
	</div>
	<div class="hr_25"></div>
	<div class="shopping_item">
		<h3 class="shopping_tit">送货清单<a href="#" class="backCar">返回购物车修改</a></h3>
		<div class="shopping_cont pb_10">
			<div class="cart_inner">
				<div class="cart_head clearfix">
					<div class="cart_item t_name">商品名称</div>
					<div class="cart_item t_price">单价</div>
					<div class="cart_item t_return">返现</div>
					<div class="cart_item t_num">数量</div>
					<div class="cart_item t_subtotal">小计</div>
				</div>
				<div class="cart_cont clearfix">
					<div class="cart_item t_name">
						<div class="cart_shopInfo clearfix">
							<img src="images/des_sm.jpg" alt="">
							<div class="cart_shopInfo_cont">
								<p class="cart_link"><a href="#">微信支付微信支付微信支付微</a></p>
								<p class="cart_info">微信支付微信支付微信支付微</p>
							</div>
						</div>
					</div>
					<div class="cart_item t_price">
						asdfa
					</div>
					<div class="cart_item t_return">返现</div>
					<div class="cart_item t_num">数量</div>
					<div class="cart_item t_subtotal t_red">小计</div>
				</div>
				<div class="cart_message">
					若有问题请留言，若有问题请留言
				</div>
				<div class="cart_prompt"><i class="cart_prompt_icon"></i>抱歉，一下商品无法购买。</div>
				<div class="cart_cont cart_no_bor clearfix">
					<div class="cart_item t_name">
						<div class="cart_shopInfo clearfix">
							<img src="images/des_sm.jpg" alt="">
							<div class="cart_shopInfo_cont">
								<p class="cart_link"><a href="#">微信支付微信支付微信支付微</a></p>
								<p class="cart_info">微信支付微信支付微信支付微</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="hr_25"></div>
	<div class="shopping_item">
		<h3 class="shopping_tit">订单结算</h3>
		<div class="shopping_cont padding_shop clearfix">
			<div class="cart_count fr">
				<div class="cart_rmb">
					<i>总计：</i><span>￥145000009.00</span>
				</div>
				<div class="cart_btnBox">
					<input type="button" class="cart_btn" value="提交订单">
				</div>
			</div>
		</div>
	</div>
</div>
<div class="hr_25"></div>
<div class="footer">
	<p><a href="#">慕课简介</a><i>|</i><a href="#">慕课公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234</p>
	<p>Copyright &copy; 2006 - 2014 慕课版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p>
	<p class="web"><a href="#"><img src="images/webLogo.jpg" alt="logo"></a><a href="#"><img src="images/webLogo.jpg" alt="logo"></a><a href="#"><img src="images/webLogo.jpg" alt="logo"></a><a href="#"><img src="images/webLogo.jpg" alt="logo"></a></p>
</div>
</body>
</html>
