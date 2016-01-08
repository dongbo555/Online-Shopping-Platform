package cn.shopping.web.servlet;

import cn.shopping.dao.GoodsDao;
import cn.shopping.pojo.Cart;
import cn.shopping.pojo.Goods;
import cn.shopping.pojo.User;
import jdk.nashorn.internal.ir.debug.JSONWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by 博 on 2016/1/8.
 */
public class CartServlet extends BaseServlet{
    Cart cart=new Cart();
    GoodsDao goodsDao=new GoodsDao();
    public String addToCart(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String id=req.getParameter("id");
        int number=Integer.parseInt(req.getParameter("num"));
        cart.addGoodsInCart(goodsDao.getGoodsById(id),number);
        req.setAttribute("size",cart.getGoodsMap().size());
        req.getSession().setAttribute("size",cart.getGoodsMap().size());
        return "f:/GoodsServlet?method=getGoodsById&id="+id;
    }

    public String deleteFromCart(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String id=req.getParameter("id");
        int number=Integer.parseInt(req.getParameter("num"));
        cart.removeGoodsFromCart(goodsDao.getGoodsById(id));
        return "f:cart.jsp";
    }

    public String showCart(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        req.getSession().setAttribute("cart",cart);
        return "f:cart.jsp";
    }
}
