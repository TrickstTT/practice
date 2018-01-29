package com.hehe.shoppingweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends BaseServlet {
    private static MainServlet servlet_main = null;

    public static MainServlet getServlet_main() {
        if(servlet_main == null){
            synchronized (MainServlet.class){
                if(servlet_main == null){
                    servlet_main = new MainServlet();
                }
            }
        }
        return servlet_main;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forward("/main.jsp",req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
