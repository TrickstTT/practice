package com.hehe.shoppingweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllUserServlet extends BaseServlet {
    private static AllUserServlet servlet_allUser = null;
    public static AllUserServlet getServlet_allUser(){
        if(servlet_allUser == null){
            synchronized (AllUserServlet.class){
                if(servlet_allUser == null){
                    servlet_allUser = new AllUserServlet();
                }
            }
        }
        return servlet_allUser;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forward("/allUser.jsp",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
