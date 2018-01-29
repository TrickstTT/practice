package com.kf.bean;

import java.util.List;
import java.util.Map;

public class Page {
	private int total;
	private int pageSize=2;
	private int currentPage;
	private int totalPage;
	private int startPage;
	private int endPage;
	private List<Map<String,String>> list;
	public Page() {
		// TODO Auto-generated constructor stub
	}
	public Page(int currentPage, int total) {
		this.currentPage = currentPage;
		this.total = total;
		totalPage = (int) Math.ceil(total*1.0/pageSize);
		startPage = currentPage-2;
		endPage = currentPage+2;
		if(currentPage<3) {
			startPage=1;
			endPage=5;
		}
		if(currentPage>totalPage-2) {
			startPage = totalPage-4;
			endPage = totalPage;
		}
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	
	public List<Map<String, String>> getList() {
		return list;
	}
	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "Page [total=" + total + ", pageSize=" + pageSize + ", currentPage=" + currentPage + ", totalPage="
				+ totalPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
}
