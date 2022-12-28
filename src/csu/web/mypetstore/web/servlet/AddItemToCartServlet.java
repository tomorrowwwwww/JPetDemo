package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.service.CartItemsService;
import csu.web.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class AddItemToCartServlet extends HttpServlet {
    //1.处理完请求后的跳转页面
    private static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";

    //2.定义处理该请求所需要的数据
    private String workingItemId;
    private Cart cart;
    private Account account;
    private Item item;
    private HttpSession session;
    //3.是否需要调用业务逻辑层
    private CatalogService catalogService;

    public AddItemToCartServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        workingItemId = request.getParameter("workingItemId");
        session = request.getSession();
        account = (Account) session.getAttribute("account");
        cart = (Cart) session.getAttribute("cart");

        if(account==null){
            if (cart == null){
                cart = new Cart();
            }

            if (cart.containsItemId(workingItemId)){
                cart.incrementQuantityByItemId(workingItemId);
            }else {
                catalogService = new CatalogService();
                boolean isInStock = catalogService.isItemInStock(workingItemId);
                item = catalogService.getItem(workingItemId);
                cart.addItem(item, isInStock);
            }
        } else {
            CartItemsService cartItemsService = new CartItemsService();
            if (cart == null){
                cart = new Cart();
            }

            catalogService = new CatalogService();
            item = catalogService.getItem(workingItemId);

            if (cart.containsItemId(workingItemId)){
                cart.incrementQuantityByItemId(workingItemId);
            }else {
                boolean isInStock = catalogService.isItemInStock(workingItemId);
                cart.addItem(item,isInStock);
                cartItemsService.insertItem(cart.getCartItemById(workingItemId),account.getUsername());
            }
        }
        session.setAttribute("cart", cart);
        request.getRequestDispatcher(CART_FORM).forward(request,response);
        response.sendRedirect(CART_FORM);

    }
}
