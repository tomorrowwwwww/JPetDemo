package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SignOnServlet extends HttpServlet {


    private static final String SIGN_ON_FORM="/WEB-INF/jsp/account/signon.jsp";

    private String username;
    private String password;
    private String signOnMsg;
    private Cart cart;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        this.username=req.getParameter("username");
        this.password=req.getParameter("password");

        resp.setContentType("text/plain");
        PrintWriter out=resp.getWriter();

        if(username.equals("abcdefg")){
            out.print("Exist");
        }else{
            out.print("Not Exist");
        }

        //获得输入的验证码值
        String value1 = req.getParameter("vCode");
        /*获取图片的值*/
        HttpSession session1=req.getSession();
        String value2 = (String) session1.getAttribute("checkcode");
        Boolean isSame = false;
        /*对比两个值（字母不区分大小写）*/
        if ((value2.equalsIgnoreCase(value1))) {
            isSame = true;
            System.out.println("zheer");
        }else{
            System.out.println("naer");
            this.signOnMsg="CODE WRONG TRY AGAIN!";
        }
        if(isSame){
            AccountService accountService=new AccountService();
            System.out.println("我是userservice里第三十行里的"+username+password);
            Account loginAccount=accountService.getAccount(username,password);
            if(loginAccount==null){
                this.signOnMsg="USERNAME OR PASSWORD WRONG";
                req.setAttribute("signOnMsg",this.signOnMsg);
                req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
            }else{
                loginAccount.setPassword(null);
                HttpSession session=req.getSession();
                session.setAttribute("loginAccount",loginAccount);

//                if(loginAccount.isListOption()){
//                    CatalogService catalogService = new CatalogService();
//                    List<Product> myList = catalogService.getProductListByCategory(loginAccount.getFavouriteCategoryId());
//                    session.setAttribute("myList",myList);
//                }

                cart = (Cart) session.getAttribute("cart");
                if(cart !=null)
                    resp.sendRedirect("newOrderForm");
                else
                    resp.sendRedirect("mainForm");
            }

        }else{
            req.setAttribute("signOnMsg",this.signOnMsg);
            req.getRequestDispatcher(SIGN_ON_FORM ).forward(req,resp);

        }
    }
//    private boolean validate(){
//        if(this.username==null || this.username.equals("")){
//            this.signOnMsg="用户名不能为空";
//            return false;
//        }
//        if(this.password==null||this.password.equals("")){
//            this.signOnMsg="密码不能为空";
//            return false;
//        }
//        return true;
//    }
}