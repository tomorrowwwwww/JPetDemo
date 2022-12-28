package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Order;
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

    private Account account;

    private OrderService orderService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        account = (Account) session.getAttribute("account");
        orderService = new OrderService();
        List<Order> orderList = orderService.getOrdersByUsername(account.getUsername());
        session.setAttribute("orderList",orderList);
        req.getRequestDispatcher(LIST_ORDERS).forward(req, resp);
    }
}
