package csu.web.mypetstore.web.servlet;

import com.alibaba.fastjson.JSON;
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
import java.io.PrintWriter;
import java.util.List;

public class SearchProductServlet extends HttpServlet {
    private static final String SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/item.jsp";
    private static final String MAIN_FORM="/WEB-INF/jsp/catalog/main.jsp";
    private static final String TOP_FORM="/WEB-INF/jsp/common/top.jsp";

    private String keyword;
    private String searchMsg=null;


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
            String time = logService.logInfo(" ") ;
            String page=strBackUrl;
            logService.insertLogInfo(account.getUsername(), time,page,"搜索关键字："+keyword);

        }

        //request.setAttribute("keyword", keyword);
        CatalogService service = new CatalogService();
        List<Product> productList = service.searchProductList(keyword);
        // HttpSession session = request.getSession();


        //判断输入是否为空
//        if (keyword.length()==0){
//            //System.out.println(222222);
//            this.searchMsg="请输入！";
//            keyword=null;
//        }
//        else if (productList.isEmpty()){
//            //System.out.println(33333);
//            this.searchMsg="不存在！";
//            productList=null;
//        }
//
//        //保存数据
//        else {
////            System.out.println(444444444);
////            System.out.println(productList.get(0));
////            System.out.println(productList.get(1));
////            System.out.println(productList.get(2));
//            searchMsg = null;
//        }
//            session.setAttribute("keyword", keyword);
//            session.setAttribute("productList", productList);
//            session.setAttribute("searchMsg",searchMsg);

        String result= JSON.toJSONString(productList);
        System.out.println(result);

        response.setContentType("text/json");
        PrintWriter out=response.getWriter();

        out.println(result);

        //跳转页面
        //request.getRequestDispatcher(MAIN_FORM).forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
