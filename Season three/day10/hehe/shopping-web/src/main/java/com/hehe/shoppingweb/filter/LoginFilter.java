package com.hehe.shoppingweb.filter;

import com.hehe.shoppingweb.entity.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user = (User) request.getSession().getAttribute("user");
        String uri = request.getRequestURI();
        if(user == null){
            if(request.getRequestURI().contains("/login.do")){
                filterChain.doFilter(request,response);
            }
            else{
                response.sendRedirect("/login.do");
            }
        }
        else{
            if(request.getRequestURI().contains("/login.do")){
                response.sendRedirect("/main.do");
            }
            else{
                filterChain.doFilter(request,response);
            }
        }
//        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
