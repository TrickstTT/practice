package com.kf.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kf.bean.Img;
import com.kf.bean.Page;
import com.kf.bean.User;
import com.kf.dao.DaoImg;
import com.kf.dao.DaoUser;

public class DaoUserService {
	//ªÒ»°page∂‘œÛ
	public Page getPage(int currentPage){
		List<User> list = new DaoUser().findAll();
		Collections.reverse(list);
		int total = list.size();
		Page page = new Page(currentPage, total);
		List<Map<String, String>> part = new ArrayList<>();
		int pageSize = page.getPageSize();
		int start = (currentPage-1)*pageSize;
		int end = start+pageSize;
		for(int i=start;i<end;i++){
			System.out.println(i);
			if(i<total){
				Map<String, String> map = getRealInfo(list.get(i).getUserName());
				part.add(map);
			}
		}
		page.setList(part);
		return page;
	}
	//…˙≥…«∞Ã®–≈œ¢1
	public Map<String, String> getRealInfo(String userName){
		DaoUser daoUser = new DaoUser();
		DaoImg daoImg = new DaoImg();
		Img img = daoImg.findOne(userName);
		User user = daoUser.findOnd(userName);
		Map<String, String> mapUserInfo=new HashMap<>();
		if(img != null){
			if(img.getTouXiangImg()!=null && (!"".equals(img.getTouXiangImg()))){
				mapUserInfo.put("touXiangImg", img.getTouXiangImg());
			}else{
				mapUserInfo.put("touXiangImg","£®Œ¥ÃÓ–¥£©");
			}
		}
		if(user.getNumber()!=null && (!"".equals(user.getNumber()))){
			mapUserInfo.put("number", user.getNumber());
		}else{
			mapUserInfo.put("number", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getSchool()!=null && (!"".equals(user.getSchool()))){
			String[] arr = user.getSchool().split("&");
			String school;
			if(arr.length==3){
				school =arr[1]+" "+arr[2];
			}else if(arr.length==2){
				school =arr[1];
			}else{
				school="£®Œ¥—°‘Ò£©";
			}
			
			mapUserInfo.put("school", school);
		}else{
			mapUserInfo.put("school","£®Œ¥ÃÓ–¥£©");
		}
		if(user.getStudyStatus()!=null && (!"".equals(user.getStudyStatus()))){
			mapUserInfo.put("studyStatus", user.getStudyStatus());
		}else{
			mapUserInfo.put("studyStatus","£®Œ¥ÃÓ–¥£©");
		}
		if(user.getBackground()!=null && (!"".equals(user.getBackground()))){
			mapUserInfo.put("background", user.getBackground());
		}else{
			mapUserInfo.put("background", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getClassName()!=null && (!"".equals(user.getClassName()))){
			mapUserInfo.put("className", user.getClassName());
		}else{
			mapUserInfo.put("className", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getAddr()!=null && (!"".equals(user.getAddr()))){
			mapUserInfo.put("registerDate", user.getAddr());
		}else{
			mapUserInfo.put("registerDate", "£®Œ¥ÃÓ–¥£©");
		}		
		if(user.getIdCard()!=null && (!"".equals(user.getIdCard()))){
			mapUserInfo.put("idCard", user.getIdCard());
		}else{
			mapUserInfo.put("idCard", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getPhone()!=null && (!"".equals(user.getPhone()))){
			mapUserInfo.put("phone", user.getPhone());
		}else{
			mapUserInfo.put("phone", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getQq()!=null && (!"".equals(user.getQq()))){
			mapUserInfo.put("qq", user.getQq());
		}else{
			mapUserInfo.put("qq", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getName()!=null && (!"".equals(user.getName()))){
			mapUserInfo.put("name", user.getName());
		}else{
			mapUserInfo.put("name", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getGender()!=null && (!"".equals(user.getGender()))){
			mapUserInfo.put("gender", user.getGender());
		}else{
			mapUserInfo.put("gender", "£®Œ¥ÃÓ–¥£©");
		}
		return mapUserInfo;
	}
	//…˙≥…«∞Ã®–≈œ¢2
	public Map<String, String> getInfo(String userName){
		DaoUser daoUser = new DaoUser();
		User user = daoUser.findOnd(userName);
		Map<String, String> mapUserInfo=new HashMap<>();
		if(user.getNumber()!=null && (!"".equals(user.getNumber()))){
			mapUserInfo.put("number", user.getNumber());
		}else{
			mapUserInfo.put("number", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getSchool()!=null && (!"".equals(user.getSchool()))){
			String[] arr = user.getSchool().split("&");
			String school;
			if(arr.length==3){
				school =arr[1]+" "+arr[2];
			}else if(arr.length==2){
				school =arr[1];
			}else{
				school="£®Œ¥—°‘Ò£©";
			}
			
			mapUserInfo.put("school", school);
		}else{
			mapUserInfo.put("school","£®Œ¥ÃÓ–¥£©");
		}
		if(user.getStudyStatus()!=null && (!"".equals(user.getStudyStatus()))){
			mapUserInfo.put("studyStatus", user.getStudyStatus());
		}else{
			mapUserInfo.put("studyStatus","£®Œ¥ÃÓ–¥£©");
		}
		if(user.getBackground()!=null && (!"".equals(user.getBackground()))){
			mapUserInfo.put("background", user.getBackground());
		}else{
			mapUserInfo.put("background", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getClassName()!=null && (!"".equals(user.getClassName()))){
			mapUserInfo.put("className", user.getClassName());
		}else{
			mapUserInfo.put("className", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getAddr()!=null && (!"".equals(user.getAddr()))){
			mapUserInfo.put("registerDate", user.getAddr());
		}else{
			mapUserInfo.put("registerDate", "£®Œ¥ÃÓ–¥£©");
		}		
		if(user.getIdCard()!=null && (!"".equals(user.getIdCard()))){
			if( user.getIdCard().length()>4){
				mapUserInfo.put("idCard", user.getIdCard().substring(0,user.getIdCard().length()-4)+"****");
			}else{
				mapUserInfo.put("idCard","****");
			}
		}else{
			mapUserInfo.put("idCard", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getPhone()!=null && (!"".equals(user.getPhone()))){
			mapUserInfo.put("phone", user.getPhone().substring(0, 7)+"****");
		}else{
			mapUserInfo.put("phone", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getQq()!=null && (!"".equals(user.getQq()))){
			mapUserInfo.put("qq", user.getQq());
		}else{
			mapUserInfo.put("qq", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getName()!=null && (!"".equals(user.getName()))){
			mapUserInfo.put("name", user.getName());
		}else{
			mapUserInfo.put("name", "£®Œ¥ÃÓ–¥£©");
		}
		if(user.getGender()!=null && (!"".equals(user.getGender()))){
			mapUserInfo.put("gender", user.getGender());
		}else{
			mapUserInfo.put("gender", "£®Œ¥ÃÓ–¥£©");
		}
		return mapUserInfo;
	}
	//Õ®π˝”√ªß√˚≤È’“
	public User findOne(String userName){
		DaoUser daoUser = new DaoUser();
		return daoUser.findOnd(userName);
	}
	//–ﬁ∏ƒ”√ªß–≈œ¢
	public User modify(List<String> texts, List<String> imgs, User oldUser) {
		String userName = oldUser.getUserName();
		String name = texts.get(0);
		String gender = texts.get(1);
		String password = oldUser.getPassword();
		String idCard = texts.get(4);
		String phone = texts.get(2);
		String qq = texts.get(3);
		String number = oldUser.getNumber();
		String school = texts.get(5)+"&"+texts.get(6)+"&"+texts.get(7);
		String studyStatus = texts.get(8);
		String background = texts.get(9);
		String className = oldUser.getClassName();
		String applyDate = oldUser.getApplyDate();
		String addr = oldUser.getAddr();
		User user = new User(userName, name, gender, password, idCard, phone, qq, number, school, studyStatus, background, className, applyDate, addr);
		new DaoUser().update(userName, user);
		String touXiangImg = imgs.get(0);
		String idFontImg = imgs.get(1);
		String idBackImg = imgs.get(2);
		String biYeZhengImg = imgs.get(3);
		new DaoImg().update(userName, new Img(userName, touXiangImg, idFontImg, idBackImg, biYeZhengImg));
		return user;
	}
	
}
