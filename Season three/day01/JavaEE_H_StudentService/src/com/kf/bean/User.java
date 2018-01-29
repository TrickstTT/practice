package com.kf.bean;

public class User {
	private String userName;
	private String name;
	private String gender;
	private String password;
	private String idCard ;
	private String phone;
	private String qq ;
	private String number;
	private String school ;
	private String studyStatus ;
	private String background ;
	private String className ;
	private String applyDate;
	private String addr ;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String name, String gender, String password, String idCard, String phone, String qq,
			String number, String school, String studyStatus, String background, String className, String applyDate,
			String addr) {
		super();
		this.userName = userName;
		this.name = name;
		this.gender = gender;
		this.password = password;
		this.idCard = idCard;
		this.phone = phone;
		this.qq = qq;
		this.number = number;
		this.school = school;
		this.studyStatus = studyStatus;
		this.background = background;
		this.className = className;
		this.applyDate = applyDate;
		this.addr = addr;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getStudyStatus() {
		return studyStatus;
	}
	public void setStudyStatus(String studyStatus) {
		this.studyStatus = studyStatus;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name + ", gender=" + gender + ", password=" + password
				+ ", idCard=" + idCard + ", phone=" + phone + ", qq=" + qq + ", number=" + number + ", school=" + school
				+ ", studyStatus=" + studyStatus + ", background=" + background + ", className=" + className
				+ ", applyDate=" + applyDate + ", addr=" + addr + "]";
	}
	
	
	
	
}
