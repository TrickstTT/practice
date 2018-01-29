package com.hehe.shoppingweb.servlet;

import com.hehe.shoppingweb.service.UserDaoService;
import com.hehe.shoppingweb.service.impl.UserDaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertUserServlet extends BaseServlet {
    private static InsertUserServlet servlet_insertUser = null;

    public static InsertUserServlet getServlet_insertUser(){
        if(servlet_insertUser == null){
            synchronized(InsertUserServlet.class){
                if(servlet_insertUser == null){
                    servlet_insertUser = new InsertUserServlet();
                }
            }
        }
        return servlet_insertUser;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        UserDaoService userDaoService = new UserDaoServiceImpl();
        userDaoService.insertUser(username,password,phone);
        request.setAttribute("msg","添加用户成功");
        forward("/insertUser.jsp",request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("InserUserServlet:doGet");
//        forward("/insertUser.jsp",request,response);
        request.getRequestDispatcher("/insertUser.jsp").forward(request,response);
    }
}
