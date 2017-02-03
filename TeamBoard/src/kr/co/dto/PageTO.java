package kr.co.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class PageTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<BoardDTO> list;
	private int curPage;
	private int perPage=10;
	private int totalCount;
	
	public PageTO() {
		// TODO Auto-generated constructor stub
	}

	public PageTO(ArrayList<BoardDTO> list, int perPage, int totalCount) {
		super();
		this.list = list;
		this.perPage = perPage;
		this.totalCount = totalCount;
	}

	public ArrayList<BoardDTO> getList() {
		return list;
	}

	public void setList(ArrayList<BoardDTO> list) {
		this.list = list;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
