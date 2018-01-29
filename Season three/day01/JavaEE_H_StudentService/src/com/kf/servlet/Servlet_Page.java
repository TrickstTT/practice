package com.kf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kf.bean.Page;
import com.kf.bean.User;
import com.kf.service.DaoUserService;

/**
 * Servlet implementation class Servlet_Page
 */
@WebServlet("/servlet/Servlet_Page")
public class Servlet_Page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!"admin".equals(((User)request.getSession().getAttribute("user")).getUserName())){
			request.getSession().setAttribute("msg", "没有权限");
			request.getSession().setAttribute("url", request.getContextPath()+"/ziLiao.jsp");
			request.getRequestDispatcher("../success.jsp").forward(request, response);
			return;
		}
		int currentPage = Integer.parseInt(request.getParameter("page"));
		DaoUserService uService = new DaoUserService();
		Page page = uService.getPage(currentPage);
		System.out.println(page);
		request.getSession().setAttribute("page", page);
		response.sendRedirect(request.getContextPath()+"/students.jsp?page="+currentPage);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
