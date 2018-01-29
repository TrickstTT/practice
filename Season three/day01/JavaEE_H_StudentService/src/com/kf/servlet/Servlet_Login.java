package com.kf.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.kf.bean.User;
import com.kf.dao.DaoImg;
import com.kf.dao.DaoUser;
import com.kf.service.DaoUserService;

/**
 * Servlet implementation class Servlet_Login
 */
@WebServlet("/servlet/Servlet_Login")
public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checkbox = request.getParameter("checkbox");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		DaoUser daoUser = new DaoUser();
		DaoUserService daoUserService = new DaoUserService();
		DaoImg daoImg = new DaoImg();
		HttpSession session = request.getSession();
		Map<String, String> mapUserInfo = new HashMap<>();
		List<User> allUser = daoUser.findAll();
//		getServletContext().setAttribute("allUser", allUser);
		String flag = "0";
		if(allUser != null){
			for(User user : allUser){
				if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
					flag="1";
					mapUserInfo = daoUserService.getInfo(user.getUserName());
					session.setAttribute("userInfo", mapUserInfo);
					session.setAttribute("user", user);
					session.setAttribute("img", daoImg.findOne(user.getUserName()));
				}
			}
		}
		if("1".equals(flag)	){
			Cookie cookie_userName = new Cookie("userName",userName);
			Cookie cookie_password = new Cookie("password",password);
			if("on".equals(checkbox)){
				cookie_userName.setMaxAge(60*60);
				cookie_password.setMaxAge(60*60);
			}else{
				cookie_userName.setMaxAge(60*60);
				cookie_password.setMaxAge(0);
			}
			cookie_userName.setPath(request.getContextPath());
			cookie_password.setPath(request.getContextPath());
			response.addCookie(cookie_userName);
			response.addCookie(cookie_password);
			response.sendRedirect(request.getContextPath()+"/main.jsp");
		}else{
			getServletContext().setAttribute("msg", "用户名或密码错误！");
			getServletContext().setAttribute("url", request.getContextPath()+"/login.jsp");
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
