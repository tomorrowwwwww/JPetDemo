package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.service.CatalogService;
import csu.web.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ProductFormServlet extends HttpServlet {
    private CatalogService catalogService;
    private String productId;

    private static final String PRODUCT_FORM = "WEB-INF/jsp/catalog/product.jsp";
    private static final String CART_FORM = "WEB-INF/jsp/cart/cart.jsp";
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{

        String name=req.getParameter("name");

//日志
        HttpSession httpSession = req.getSession();
        Account account = (Account)httpSession.getAttribute("loginAccount");

        if(account != null){
            HttpServletRequest httpRequest= req;
            String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
            String logInfo = logService.logInfo(" ") + strBackUrl + name;
            logService.insertLogInfo(account.getUsername(), logInfo);

        }
//        this.doGet(req, resp);

        System.out.println(name+"qqqqqqqqqqqqqqq");
        catalogService = new CatalogService();
        Product product = catalogService.getProductByName(name);
        String productId=product.getProductId();
        System.out.println(productId+"cjvdvb h");
        List<Item> itemList =  catalogService.getItemListByProduct(productId);
//        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("product", product);
        httpSession.setAttribute("itemList", itemList);
        req.getRequestDispatcher(PRODUCT_FORM).forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        productId = req.getParameter("productId");
        catalogService = new CatalogService();
        Product product = catalogService.getProduct(productId);
        List<Item> itemList =  catalogService.getItemListByProduct(productId);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("product", product);
        httpSession.setAttribute("itemList", itemList);
        req.getRequestDispatcher(PRODUCT_FORM).forward(req, resp);
        req.getRequestDispatcher(CART_FORM).forward(req, resp);
    }


}
