package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewOrderServlet extends HttpServlet {

    private static final String CONFIRM_ORDER = "/WEB-INF/jsp/order/confirmOrder.jsp";

    private Order order ;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        order = (Order) session.getAttribute("order");

        order.setBillToFirstName(request.getParameter("order.billToFirstName"));
        order.setBillToLastName(request.getParameter("order.billToLastName"));
        order.setBillAddress1(request.getParameter("order.billAddress1"));
        order.setBillAddress2(request.getParameter("order.billAddress2"));
        order.setBillCity(request.getParameter("order.billCity"));
        order.setBillState(request.getParameter("order.billState"));
        order.setBillZip(request.getParameter("order.billZip"));
        order.setBillCountry(request.getParameter("order.billCountry"));
        order.setShipToFirstName(request.getParameter("order.shipToFirstName"));
        order.setShipToLastName(request.getParameter("order.shipToLastName"));
        order.setShipAddress1(request.getParameter("order.shipAddress1"));
        order.setShipAddress2(request.getParameter("order.shipAddress2"));
        order.setShipCity(request.getParameter("order.shipCity"));
        order.setShipState(request.getParameter("order.shipState"));
        order.setShipZip(request.getParameter("order.shipZip"));
        order.setShipCountry(request.getParameter("order.shipCountry"));

        request.getRequestDispatcher(CONFIRM_ORDER).forward(request,response);

    }
}
