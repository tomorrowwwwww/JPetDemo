package csu.web.mypetstore.web.servlet;


import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Category;
import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class ItemFormServlet extends HttpServlet {
    private static final String ITEM_FORM = "/WEB-INF/jsp/catalog/item.jsp";
    private String itemId;
    private HttpSession session;
    private Account account;
    private Item item;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        itemId = req.getParameter("itemId");
        CatalogService service = new CatalogService();
        item = service.getItem(itemId);

        session = req.getSession();

        Product product = service.getProduct(item.getProduct().getProductId());
        session.setAttribute("product",product);

        session.setAttribute("item",item);

        req.getRequestDispatcher(ITEM_FORM).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
