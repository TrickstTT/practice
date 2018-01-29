package com.kf.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kf.bean.User;
import com.kf.dao.DaoImg;
import com.kf.service.DaoUserService;



/**
 * Servlet implementation class Servlet_Update
 */
@WebServlet("/servlet/Servlet_Update")
public class Servlet_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)){
			DiskFileItemFactory dFactory = new DiskFileItemFactory();
			ServletFileUpload fUpload = new ServletFileUpload(dFactory);
			DaoUserService userService = new DaoUserService();
			DaoImg daoImg = new DaoImg();
			String userName = ((User)request.getSession().getAttribute("user")).getUserName();
			HttpSession session = request.getSession();
			try {
				List<FileItem>	list = fUpload.parseRequest(request);
				//获取表单的隐藏信息  userName
				User oldUser = userService.findOne(userName);
				List<String> texts  = new ArrayList<>();
				List<String> imgs  = new ArrayList<>();
				for(FileItem fileItem :list){
					if(fileItem.isFormField()){
						String name = fileItem.getFieldName();
						String value = fileItem.getString("utf-8");
						texts.add(value);
					}else{
						String fileName = fileItem.getFieldName();
//						if(name!=null){
//							name = FilenameUtils.getName(name);
//						}
						String path = getServletContext().getRealPath("\\img\\"+userName);
						if(fileItem.getSize()==0){
							if("touXiangImg".equals(fileName)){
								fileName = "touxiangImg";
							}
							imgs.add("img/defaultImg/"+fileName+".jpg");
						}else{
							imgs.add("img/"+userName+"/"+fileName+".jpg");
						}
						File dir = new File(path);
						if(!dir.exists()){
							dir.mkdirs();
						}
						File file = new File(dir, fileName+".jpg");
						fileItem.write(file);
					}
				}
				System.out.println(texts);
				System.out.println(imgs);
				User newUser = userService.modify(texts,imgs,oldUser);
				session.setAttribute("user", newUser);
				session.setAttribute("userInfo", userService.getInfo(newUser.getUserName()));
				session.setAttribute("img", daoImg.findOne(newUser.getUserName()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("url", request.getContextPath()+"/ziLiao.jsp");
			session.setAttribute("msg", "修改成功");
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
