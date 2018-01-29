package com.kf.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kf.bean.Img;
import com.kf.bean.User;
import com.kf.dao.DaoImg;
import com.kf.dao.DaoUser;

/**
 * Servlet implementation class Servlet_Regist
 */
@WebServlet("/servlet/Servlet_Regist")
public class Servlet_Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String subject = request.getParameter("subject");
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String idCard = request.getParameter("idCard");
		String number = getNum(city, subject);
		String className = getClass(city, subject);
		String applyDate = getDate();
		User user = new User(userName, name, gender, password, idCard, phone, qq, number, null, null, null, className, applyDate, null);
		new DaoUser().insert(user);
		request.getSession().setAttribute("msg", "×¢²á³É¹¦£¡£¡");
		request.getSession().setAttribute("url", request.getContextPath());
		request.getRequestDispatcher("../success.jsp").forward(request, response);
		new DaoImg().insert(new Img(userName, "img/defaultImg/touxiangImg.jpg", "img/defaultImg/idFontImg.jpg", "img/defaultImg/idBackImg.jpg", "img/defaultImg/biYeZhengImg.jpg"));
	}
	public String getDate(){
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		String mm = sFormat.format(new Date());
		return mm;
	}
	public String getNum(String city,String subject){
		String zz = city.split("&")[2];
		SimpleDateFormat sFormat = new SimpleDateFormat("yyMM");
		String mm = sFormat.format(new Date());
		int num = new DaoUser().findAll().size()+1;
		String ll=null;
		if(num<10){
			ll = "000"+num;
		}else if(num<100){
			ll = "00"+num;
		}else if(num<1000){
			ll = "0"+num;
		}else{
			ll = ""+num;
		}
		return zz+mm+ll;
	}
	public String getClass(String city,String subject){
		String zz = city.split("&")[1];
		SimpleDateFormat sFormat = new SimpleDateFormat("yyMM");
		String mm = sFormat.format(new Date());
		return zz+subject+mm+"ÆÚ";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
