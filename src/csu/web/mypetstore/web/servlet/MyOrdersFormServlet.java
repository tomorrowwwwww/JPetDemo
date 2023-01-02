package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Order;
import csu.web.mypetstore.service.LogService;
import csu.web.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MyOrdersFormServlet extends HttpServlet {
    private static final String LIST_ORDERS = "/WEB-INF/jsp/order/listOrders.jsp";


    private OrderService orderService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //日志
        // HttpSession httpSession = req.getSession();
        Account account = (Account)session.getAttribute("loginAccount");

        if(account != null){
            HttpServletRequest httpRequest= req;
            String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
            String time = logService.logInfo(" ") ;
            String page=strBackUrl;
            logService.insertLogInfo(account.getUsername(), time,page,"查看订单");

        }
        orderService = new OrderService();
        List<Order> orderList = orderService.getOrdersByUsername(account.getUsername());
        session.setAttribute("orderList",orderList);
//        session.setAttribute("orderList", Account.MyOrders);
        req.getRequestDispatcher(LIST_ORDERS).forward(req, resp);
    }
}
