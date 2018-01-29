package com.hehe.shoppingweb.servlet;

import com.hehe.shoppingweb.entity.User;
import com.hehe.shoppingweb.service.impl.UserDaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends BaseServlet {
    private static LoginServlet servlet_login = null;

    public static LoginServlet getServlet_login() {
        if(servlet_login == null){
            synchronized (LoginServlet.class){
                if(servlet_login == null){
                    servlet_login = new LoginServlet();
                }
            }
        }
        return servlet_login;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        UserDaoServiceImpl userDaoService = new UserDaoServiceImpl();
        User user = userDaoService.isUser(username, password);
        if (user == null) {
            request.setAttribute("msg", "帐号或密码错误");
//            request.getSession().setAttribute("url", "/login.jsp");
            forward("/login.jsp",request,response);
        } else {
            System.out.println(user);
            request.getSession().setAttribute("user", user);
            response.sendRedirect(String.format("%s/main.do", request.getContextPath()));
        }
    }
}
