package csu.web.mypetstore.web.servlet;

import com.alibaba.fastjson.JSON;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class UpdateCartServlet extends HttpServlet {
    private static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";

    private Cart cart;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从对话中，获取购物车
        HttpSession session = request.getSession();
        cart = (Cart) session.getAttribute("cart");
        Map<String, String> map = new HashMap<String, String>();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                if (paramValues[0].length() != 0) {
                    map.put(paramName, paramValues[0]);
                }
            }
        }
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if (Integer.parseInt(entry.getValue()) < 1) {
                cart.removeItemById(entry.getKey());
            } else {
                cart.setQuantityByItemId(entry.getKey(), Integer.parseInt(entry.getValue()));
            }
        }
        session.setAttribute("cart", cart);
        Iterator<CartItem> cartItemIterator = cart.getAllCartItems();
        List<QuantityAndPrice> qpList = new ArrayList<>();

        while (cartItemIterator.hasNext()) {
            //产品数量增加
            CartItem cartItem = cartItemIterator.next();
            QuantityAndPrice qp = new QuantityAndPrice(String.valueOf(cartItem.getQuantity()), cartItem.getTotal().toString());
            qpList.add(qp);
        }
        String quantityAll = JSON.toJSONString(qpList);
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        out.write(quantityAll);
        out.flush();
        out.close();
    }

    class QuantityAndPrice {
        protected String quantity;
        protected String totalPrice;

        public QuantityAndPrice(String quantity, String totalPrice) {
            this.quantity = quantity;
            this.totalPrice = totalPrice;
        }

        public String getQuantity() {
            return quantity;
        }

        public String getTotalPrice() {
            return totalPrice;
        }
    }
}

//    private static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";
//    private Cart cart;
//    private String workingItemId;
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        workingItemId = request.getParameter("workingItemId");
//        CatalogService catalogService = new CatalogService();
//
//        //从对话中，获取购物车
//        HttpSession session = request.getSession();
//        cart = (Cart)session.getAttribute("cart");
//
//        Iterator<CartItem> cartItemIterator = cart.getAllCartItems();
//
//        while (cartItemIterator.hasNext()) {
//            //产品数量增加
//            CartItem cartItem = (CartItem) cartItemIterator.next();
//            String itemId = cartItem.getItem().getItemId();
//
//            try {
//                int quantity = Integer.parseInt((String) request.getParameter("quantity"));
//                cart.setQuantityByItemId(itemId, quantity);
//                if (quantity < 1) {
//                    cartItemIterator.remove();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        session.setAttribute("cart", cart);
//
//        Cart cart2 = (Cart)session.getAttribute("cart");
//        Iterator<CartItem> cartItemIterator2 = cart2.getAllCartItems();
//        String quantityAll = "";
//        while (cartItemIterator2.hasNext()) {
//            //产品数量增加
//            CartItem cartItem2 = cartItemIterator2.next();
//            int quantity2 = cartItem2.getQuantity();
//            quantityAll += quantity2 + "," + cartItem2.getTotal() + "," + cart2.getSubTotal();
//        }
//        response.setContentType("text/xml");
//        PrintWriter out = response.getWriter();
//        out.write(quantityAll);
//    }

