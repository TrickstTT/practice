package com.kf.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.chrono.MinguoChronology;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kf.bean.User;
import com.kf.dao.DaoUser;
import com.kf.service.DaoUserService;


/**
 * Servlet implementation class Servlet_Output
 */
@WebServlet("/servlet/Servlet_Output")
public class Servlet_Output extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("namehehe") + ".csv";
		fileName = "biaoge.csv";
		String url = request.getParameter("url");
		if(url==null){
			url="d://gaga";
		}
		List<User> list = new DaoUser().findAll();
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		response.setContentType(getServletContext().getMimeType(fileName));
		response.setCharacterEncoding("utf-8");
		File file = new File(url);
		if(!file.exists()){
			file.mkdirs();
		}
		File file2 = new File(file,fileName);
		FileWriter writer = new FileWriter(file2);
		String mimeType = getServletContext().getMimeType(fileName);
		PrintWriter writer2 = response.getWriter();
//		writer2.write("姓名");
//		writer2.write(",");
//		writer2.write("年龄");
//		writer2.write(",");
//		writer2.write("手机号");
//		writer2.write(",");
//		writer2.write("QQ号");
//		writer2.write("\n");
		writer2.write("姓名");
		writer2.write(",");
		writer2.write("年龄");
		writer2.write(",");
		writer2.write("手机号");
		writer2.write(",");
		writer2.write("QQ号");
		writer2.write("\n");
		list.forEach(u->{
			Map<String, String> map = new DaoUserService().getRealInfo(u.getUserName());
			writer2.write(map.get("name"));
			writer2.write(",");
			writer2.write(map.get("gender"));
			writer2.write(",");
			writer2.write(map.get("phone"));
			writer2.write(",");
			writer2.write(map.get("qq"));
			writer2.write("\n");
		});
//		for(User user:list){
//			writer.write("/r/n");
//			Map<String, String> map = new DaoUserService().getRealInfo(user.getName());
//			writer.write(map.get("name"));
//			writer.write(map.get("gender"));
//			writer.write(map.get("idCard"));
//			writer.write(map.get("phone"));
//			writer.write(map.get("qq"));
//			writer.write(user.toString());
//			System.out.println("a");
//		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
