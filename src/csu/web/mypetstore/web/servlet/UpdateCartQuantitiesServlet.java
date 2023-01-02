package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.CartItem;
import csu.web.mypetstore.service.CartItemsService;
import csu.web.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

public class UpdateCartQuantitiesServlet extends HttpServlet {

    private static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";

    private Cart cart;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        cart = (Cart) session.getAttribute("cart");
        Account account = (Account) session.getAttribute("account");
        Iterator<CartItem> cartItemIterator = cart.getAllCartItems();

        if (account==null){
            while (cartItemIterator.hasNext()){
                CartItem cartItem = (CartItem) cartItemIterator.next();
                String itemId = cartItem.getItem().getItemId();
                try{
                    int quantity = Integer.parseInt((String) request.getParameter(itemId));
                    cart.setQuantityByItemId(itemId,quantity);
                    if (quantity<1){
                        cartItemIterator.remove();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }}
        else {
            CartItemsService cartItemsService = new CartItemsService();
            while (cartItemIterator.hasNext()){
                CartItem cartItem = (CartItem) cartItemIterator.next();
                String itemId = cartItem.getItem().getItemId();
                try{
                    int quantity = Integer.parseInt((String) request.getParameter(itemId));
                    cart.setQuantityByItemId(itemId,quantity);
                    cartItemsService.updateCart(cartItem);
                    if (quantity<1){
                        cartItemsService.removeItem(cartItem);
                        cartItemIterator.remove();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        if(account != null){
            HttpServletRequest httpRequest= request;
            String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
            String time = logService.logInfo(" ") ;
            String page=strBackUrl;
            logService.insertLogInfo(account.getUsername(), time,page,"更新购物车商品数量"+" "+cartItemIterator);

        }

        request.getRequestDispatcher(CART_FORM).forward(request, response);
        response.sendRedirect(CART_FORM);
    }
}

