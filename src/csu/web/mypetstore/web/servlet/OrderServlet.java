package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.Order;
import csu.web.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OrderServlet extends HttpServlet {
    private static final String ORDER = "/WEB-INF/jsp/order/order.jsp";

    private String orderId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        orderId = request.getParameter ("orderId");

        OrderService service = new OrderService();
        int a = Integer.parseInt(orderId);

        Order order = service.getOrder(a);
        HttpSession session = request.getSession();
        session.setAttribute("order",order);

        request.getRequestDispatcher(ORDER).forward(request,response);

    }

}
