package com.kf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kf.bean.User;
import com.kf.dao.DaoUser;

/**
 * Servlet implementation class Servlet_isHave
 */
@WebServlet("/servlet/Servlet_isHave")
public class Servlet_isHave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userName = request.getParameter("userName");
		PrintWriter writer = response.getWriter();
		if(!userName.matches("[a-zA-Z][0-9a-zA-Z]{4,13}")){
			writer.write("*用户名以字母开头，长度5~14");
		}else if(isHave(userName)){
			writer.write("*用户名已存在");
		}else{
			writer.write("*可以使用");
		}
	}
	public boolean isHave(String userName){
		DaoUser daoUser = new DaoUser();
		boolean b = false;
		List<User> list = daoUser.findAll();
		for(User user:list){
			if(user.getUserName().equals(userName)){
				b = true;
			}
		}
		return b;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
