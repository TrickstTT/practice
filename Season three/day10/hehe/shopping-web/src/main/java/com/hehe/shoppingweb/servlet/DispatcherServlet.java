package com.hehe.shoppingweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUri = req.getRequestURI();
        //登录
        if(requestUri.contains("login.do")){
            LoginServlet.getServlet_login().service(req,resp);
        }
        //新增用户
        else if(requestUri.contains("insertUser.do")){
            InsertUserServlet.getServlet_insertUser().service(req, resp);
        }
        //主页面
        else if(requestUri.contains("main.do")){
            MainServlet.getServlet_main().service(req,resp);
        }
        //新增用户页面
        else if(requestUri.contains("insertUser.do")){
            InsertUserServlet.getServlet_insertUser().service(req,resp);
        }
        //所有用户页面
        else if(requestUri.contains("allUser.do")){
            AllUserServlet.getServlet_allUser().service(req,resp);
        }

    }
}
