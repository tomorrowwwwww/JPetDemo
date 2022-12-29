package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Order;
import csu.web.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {

    private static final String CONFIRM_ORDER = "/WEB-INF/jsp/order/confirmOrder.jsp";

    private Order order ;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        order = (Order) session.getAttribute("order");

        order.setBillToFirstName(request.getParameter("update.FirstName"));
        order.setBillToLastName(request.getParameter("update.LastName"));
        order.setBillAddress1(request.getParameter("update.Address1"));
        order.setBillAddress2(request.getParameter("update.Address2"));
        order.setBillCity(request.getParameter("update.City"));
        order.setBillState(request.getParameter("update.State"));
        order.setBillZip(request.getParameter("update.Zip"));
        order.setBillCountry(request.getParameter("update.Country"));


        Account account = (Account)session.getAttribute("loginAccount");

        if(account != null){
            HttpServletRequest httpRequest= request;
            String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
            String time = logService.logInfo(" ") ;
            String page=strBackUrl;
            logService.insertLogInfo(account.getUsername(), time,page,"生成新订单"+"  "+order);

        }

        request.getRequestDispatcher(CONFIRM_ORDER).forward(request,response);

    }
}