package com.kf.bean;

public class Img {
	private String userName;
	private String touXiangImg;
	private String idFontImg;
	private String idBackImg;
	private String biYeZhengImg;
	public Img() {
		// TODO Auto-generated constructor stub
	}
	public Img(String userName, String touXiangImg, String idFontImg, String idBackImg, String biYeZhengImg) {
		super();
		this.userName = userName;
		this.touXiangImg = touXiangImg;
		this.idFontImg = idFontImg;
		this.idBackImg = idBackImg;
		this.biYeZhengImg = biYeZhengImg;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTouXiangImg() {
		return touXiangImg;
	}
	public void setTouXiangImg(String touXiangImg) {
		this.touXiangImg = touXiangImg;
	}
	public String getIdFontImg() {
		return idFontImg;
	}
	public void setIdFontImg(String idFontImg) {
		this.idFontImg = idFontImg;
	}
	public String getIdBackImg() {
		return idBackImg;
	}
	public void setIdBackImg(String idBackImg) {
		this.idBackImg = idBackImg;
	}
	public String getBiYeZhengImg() {
		return biYeZhengImg;
	}
	public void setBiYeZhengImg(String biYeZhengImg) {
		this.biYeZhengImg = biYeZhengImg;
	}
	@Override
	public String toString() {
		return "Img [userName=" + userName + ", touXiangImg=" + touXiangImg + ", idFontImg=" + idFontImg
				+ ", idBackImg=" + idBackImg + ", biYeZhengImg=" + biYeZhengImg + "]";
	}
	
}
