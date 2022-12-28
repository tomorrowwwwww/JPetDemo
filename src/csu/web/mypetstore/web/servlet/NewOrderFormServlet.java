package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.Order;

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
            req.getRequestDispatcher(NEW_ORDER_FORM).forward(req,resp);
        }
        else{
            session.setAttribute("message", "An order could not be created because a cart could not be found.");
            req.getRequestDispatcher(ERROR).forward(req, resp);

        }
    }


}