package com.hehe.shoppingweb.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        this.encoding = config.getInitParameter("encoding");
        System.out.println(encoding);
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        httpServletRequest.setCharacterEncoding(encoding);
        httpServletResponse.setContentType(String.format("text/html;charset=%s",encoding));
        chain.doFilter(httpServletRequest, httpServletResponse);
    }

    public void destroy() {

    }
}
