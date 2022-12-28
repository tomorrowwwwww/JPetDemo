package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.service.CatalogService;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SearchProductServlet extends HttpServlet {
    private static final String SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/item.jsp";
    private static final String MAIN_FORM="/WEB-INF/jsp/catalog/main.jsp";

    private String keyword;
    private String searchMsg;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);

        keyword = request.getParameter("keyword");

//日志
        HttpSession httpSession = request.getSession();
        Account account = (Account)httpSession.getAttribute("loginAccount");

        if(account != null){
            HttpServletRequest httpRequest= request;
            String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
            String logInfo = logService.logInfo(" ") + strBackUrl + keyword;
            logService.insertLogInfo(account.getUsername(), logInfo);

        }

        //request.setAttribute("keyword", keyword);
        CatalogService service = new CatalogService();
        List<Product> productList = service.searchProductList(keyword);

        HttpSession session = request.getSession();

        //判断输入是否为空
        if (keyword.length()==0){
            System.out.println(222222);
            this.searchMsg="请输入！";
            session.setAttribute("searchMsg",searchMsg);
            request.getRequestDispatcher(MAIN_FORM).forward(request,response);
        }
        else if (productList.isEmpty()){
            System.out.println(33333);
            this.searchMsg="不存在！";
            session.setAttribute("searchMsg",searchMsg);
            request.getRequestDispatcher(MAIN_FORM).forward(request,response);
        }

        //保存数据
        else {
            System.out.println(444444444);
            System.out.println(productList.get(0));
            System.out.println(productList.get(1));
            System.out.println(productList.get(2));
            session.setAttribute("keyword", keyword);
            session.setAttribute("productList", productList);

            //跳转页面
            request.getRequestDispatcher(MAIN_FORM).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
