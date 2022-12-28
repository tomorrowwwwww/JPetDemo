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

public class RegisterServlet extends HttpServlet {


    private static final String REGISTER_FORM="/WEB-INF/jsp/account/register.jsp";

    private String username;
    private String password;
    private String repeatPassword;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String status;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String favouriteCategoryId;
    private String languagePreference;
    private String listOption;
    private String bannerOption;
    private String bannerName;
    private String registerMsg;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.username=req.getParameter("username");
        this.password=req.getParameter("password");
        this.repeatPassword=req.getParameter("username");
        this.firstName=req.getParameter("firstName");
        this.lastName=req.getParameter("lastName");
        this.email=req.getParameter("email");
        this.phone=req.getParameter("phone");
        this.status="OK";
        this.bannerName="<image src=\"../images/banner_cats.gif\">";
        this.bannerOption="1";
        this.listOption="1";
        this.languagePreference="english";
        this.favouriteCategoryId="CATS";
        this.address1=req.getParameter("address1");
        this.address2=req.getParameter("address2");
        this.city=req.getParameter("city");
        this.state=req.getParameter("state");
        this.zip=req.getParameter("zip");
        this.country=req.getParameter("country");
        System.out.println(this.username+"我是registerservlet50行里的东东");
        if(!validate()){
            req.setAttribute("registerMsg",this.registerMsg);
            req.getRequestDispatcher("registerForm").forward(req,resp);
        }else{
            Account registerUser=new Account();
            registerUser.setUsername(this.username);
            registerUser.setPassword(this.password);
            registerUser.setFirstName(this.firstName);
            registerUser.setLastName(this.lastName);
            registerUser.setEmail(this.email);
            registerUser.setPhone(this.phone);
            registerUser.setStatus(this.status);
            registerUser.setAddress1(this.address1);
            registerUser.setAddress2(this.address2);
            registerUser.setCity(this.city);
            registerUser.setState(this.state);
            registerUser.setZip(this.zip);
            registerUser.setCountry(this.country);
            registerUser.setFavouriteCategoryId(this.favouriteCategoryId);
            registerUser.setBannerOption(this.bannerOption);
            registerUser.setLanguagePreference(this.languagePreference);
            registerUser.setBannerName(this.bannerName);
            registerUser.setListOption(this.listOption);
            AccountService accountService=new AccountService();
            if(accountService.addAccount(registerUser)){
                resp.sendRedirect("signonForm");
            }else{
                this.registerMsg="用户名已存在，请更换用户名";
                req.setAttribute("registerMsg",this.registerMsg);
                req.getRequestDispatcher(REGISTER_FORM).forward(req,resp);
            }

        }
    }
    private boolean validate(){
        if(this.username==null || this.username.equals("")||this.password==null||this.password.equals("")
                ||this.repeatPassword==null||this.repeatPassword.equals("")
                ||this.firstName==null||this.firstName.equals("")
                ||this.lastName==null||this.lastName.equals("")
                ||this.email==null||this.email.equals("")
                ||this.phone==null||this.phone.equals("")
                ||this.address1==null||this.address1.equals("")
                ||this.address2==null||this.address2.equals("")
                ||this.city==null||this.city.equals("")
                ||this.state==null||this.state.equals("")
                ||this.zip==null||this.zip.equals("")
                ||this.country==null||this.country.equals("")
        ){
            this.registerMsg="信息不完整，请完善信息后注册";
            return false;
        }
        return true;
    }
}
