package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.Order;
import csu.web.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewOrderFormServlet extends HttpServlet {

    private static final String NEW_ORDER_FORM="/WEB-INF/jsp/order/newOrder.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/error.jsp";

    private Cart cart;
    private Account loginAccount;
    private Order order;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        loginAccount = (Account) session.getAttribute("loginAccount");
        cart = (Cart)session.getAttribute("cart");
        if(loginAccount==null){
            resp.sendRedirect("signonForm");
        }else if(cart != null) {
            order = new Order();
            order.initOrder(loginAccount, cart);
            session.setAttribute("order", order);
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
                logService.insertLogInfo(account.getUsername(), time,page,"生成新用户"+"  "+order);

            }
            req.getRequestDispatcher(NEW_ORDER_FORM).forward(req,resp);
        }
        else{
            session.setAttribute("message", "An order could not be created because a cart could not be found.");
            req.getRequestDispatcher(ERROR).forward(req, resp);

        }
    }


}