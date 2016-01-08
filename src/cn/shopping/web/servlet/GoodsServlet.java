package cn.shopping.web.servlet;

import cn.shopping.dao.CategoryDao;
import cn.shopping.pojo.Category;
import cn.shopping.pojo.Goods;
import cn.shopping.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 博 on 2016/1/7.
 */
public class GoodsServlet extends BaseServlet {
    GoodsService goodsService=new GoodsService();
    CategoryDao categoryDao=new CategoryDao();
    public String getGoodsById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id=req.getParameter("id");
        Goods goods=goodsService.getGoodsById(id);
        Category category=categoryDao.getCategoryById(goods.getcId());
        req.setCharacterEncoding("utf-8");
        req.setAttribute("category",category);
        req.setAttribute("goods",goods);
        return "f:/introduce.jsp";
    }
//    public String getGoodsesByCatagory(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException{
//
//    }
//

//
//    public String delele(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException{
//
//    }
//
//    public String getAllGoods(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException{
//
//    }


}
