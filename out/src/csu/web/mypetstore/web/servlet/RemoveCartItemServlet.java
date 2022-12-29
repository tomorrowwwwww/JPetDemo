package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.service.CartItemsService;
import csu.web.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RemoveCartItemServlet extends HttpServlet {
    private static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";
    private static final String ERROR_FORM = "/WEB-INF/jsp/common/error.jsp";

    private String workingItemId;
    private Cart cart;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        workingItemId = req.getParameter("workingItemId");

        HttpSession session = req.getSession();
        cart = (Cart) session.getAttribute("cart");
        Account account = (Account) session.getAttribute("account");
        Item item = cart.getItemById(workingItemId);

        if (item == null) {
            session.setAttribute("errorMsg","Attempted to remove null CartItem from Cart.");
            req.getRequestDispatcher(ERROR_FORM).forward(req,resp);
        } else {
            if (account!=null){
                CartItemsService cartItemsService = new CartItemsService();
                cartItemsService.removeItem(cart.getCartItemById(workingItemId));
            }
            cart.removeItemById(workingItemId);

            if(account != null){
                HttpServletRequest httpRequest= req;
                String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
                String time = logService.logInfo(" ") ;
                String page=strBackUrl;
                logService.insertLogInfo(account.getUsername(), time,page,"删除购物车中商品"+workingItemId);

            }
            req.getRequestDispatcher(CART_FORM).forward(req,resp);
        }
    }
}
