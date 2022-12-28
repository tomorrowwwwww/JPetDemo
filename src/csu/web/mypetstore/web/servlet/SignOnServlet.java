package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOnServlet extends HttpServlet {


    private static final String SIGN_ON_FORM="/WEB-INF/jsp/account/signon.jsp";

    private String username;
    private String password;
    private String signOnMsg;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.username=req.getParameter("username");
        this.password=req.getParameter("password");

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
            this.signOnMsg="验证码出错，请重试";
        }
        if(!validate()){
            req.setAttribute("signOnMsg",this.signOnMsg);
            req.getRequestDispatcher(SIGN_ON_FORM ).forward(req,resp);
        }else if(validate()&&isSame){
            AccountService accountService=new AccountService();
            System.out.println("我是userservice里第三十行里的"+username+password);
            Account loginAccount=accountService.getAccount(username,password);
            if(loginAccount==null){
                this.signOnMsg="用户名或密码错误";
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

                resp.sendRedirect("mainForm");
            }

        }else{
            req.setAttribute("signOnMsg",this.signOnMsg);
            req.getRequestDispatcher(SIGN_ON_FORM ).forward(req,resp);

        }
    }
    private boolean validate(){
        if(this.username==null || this.username.equals("")){
            this.signOnMsg="用户名不能为空";
            return false;
        }
        if(this.password==null||this.password.equals("")){
            this.signOnMsg="密码不能为空";
            return false;
        }
        return true;
    }
}
