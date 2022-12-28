package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.CartItem;
import csu.web.mypetstore.domain.Order;
import csu.web.mypetstore.service.CartItemsService;
import csu.web.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubmitOrderServlet extends HttpServlet {
    private static final String ORDER = "/WEB-INF/jsp/order/order.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/error.jsp";

    private Cart cart;
    private Order order;
    private OrderService orderService;
    private Account account;
    private List<CartItem> cartItemList;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        cart = (Cart) session.getAttribute("cart");
        order =(Order) session.getAttribute("order");
        account = (Account) session.getAttribute("account");
//        CartItemsService cartItemsService = new CartItemsService();
//        cartItemList = cartItemsService.getCartByUsername(account.getUsername());
//        for (int i=0;i<cartItemList.size();i++){
//            cartItemsService.removeItem(cartItemList.get(i));
        //}
//        cart = new Cart();
//        session.setAttribute("cart",cart);
//        orderService = new OrderService();
//        orderService.insertOrder(order);
//        request.setAttribute("msg","Thank you, your order has been submitted.");
//        request.getRequestDispatcher(ORDER).forward(request,response);



        if (order != null) {
//            CartItemsService cartItemsService = new CartItemsService();
//            cartItemList = cartItemsService.getCartByUsername(account.getUsername());
//            for (int i=0;i<cartItemList.size();i++){
//                cartItemsService.removeItem(cartItemList.get(i));
//            }
            orderService = new OrderService();
            orderService.insertOrder(order);
            session.setAttribute("order", order);
            //清空购物车
            cart = null;
            session.setAttribute("cart", cart);

            session.setAttribute("message", "Thank you, your order has been submitted.");
            request.getRequestDispatcher(ORDER).forward(request, response);
        } else {
            session.setAttribute("message", "An error occurred processing your order (order was null).");
            request.getRequestDispatcher(ERROR).forward(request, response);
        }

    }
}
