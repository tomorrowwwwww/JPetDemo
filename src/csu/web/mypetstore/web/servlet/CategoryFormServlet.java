package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Category;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.service.CatalogService;
import csu.web.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CategoryFormServlet extends HttpServlet {
    private static final String CATEGORY_FORM = "/WEB-INF/jsp/catalog/category.jsp";
    private CatalogService catalogService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*super.doGet(req,resp);*/
        String categoryId = req.getParameter("categoryId");
        catalogService = new CatalogService();
        Category category = catalogService.getCategory(categoryId);

        List<Product> productList = catalogService.getProductListByCategory(categoryId);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("category", category);
        httpSession.setAttribute("productList", productList);
        //日志
//        HttpSession httpSession = req.getSession();
        Account account = (Account)httpSession.getAttribute("loginAccount");

        if(account != null){
            HttpServletRequest httpRequest= req;
            String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
            String time = logService.logInfo(" ") ;
            String page=strBackUrl;
            logService.insertLogInfo(account.getUsername(), time,page,"目录");

        }
        req.getRequestDispatcher(CATEGORY_FORM).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
