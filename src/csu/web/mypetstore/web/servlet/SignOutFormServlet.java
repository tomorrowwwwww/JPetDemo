package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOutFormServlet extends HttpServlet {
    private static final String MAIN_FORM="/WEB-INF/jsp/catalog/main.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//日志
        HttpSession httpSession = req.getSession();
        Account account = (Account)httpSession.getAttribute("loginAccount");

        if(account != null){
            HttpServletRequest httpRequest= req;
            String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
//最后加入的信息“XXXXX”应当为该界面的信息以及一些商品信息
            String logInfo = logService.logInfo(" ") + strBackUrl + " XXXXX";
            logService.insertLogInfo(account.getUsername(), logInfo);

        }
        Account loginAccount = null;
        HttpSession session = req.getSession();
        session.setAttribute("loginAccount", loginAccount);
        //   resp.sendRedirect("mainForm");
        req.getRequestDispatcher(MAIN_FORM).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
