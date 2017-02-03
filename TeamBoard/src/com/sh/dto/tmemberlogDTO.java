package com.sh.dto;

import java.io.Serializable;

public class tmemberlogDTO implements Serializable {
	
	private int mxlognum;
	private int memnum;
	private String loginday;
	
	
	private String id;
	private String name;
	
	public tmemberlogDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getMxlognum() {
		return mxlognum;
	}

	public void setMxlognum(int mxlognum) {
		this.mxlognum = mxlognum;
	}

	public int getMemnum() {
		return memnum;
	}

	public void setMemnum(int memnum) {
		this.memnum = memnum;
	}

	public String getLoginday() {
		return loginday;
	}

	public void setLoginday(String loginday) {
		this.loginday = loginday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public tmemberlogDTO(int mxlognum, int memnum, String loginday, String id, String name) {
		super();
		this.mxlognum = mxlognum;
		this.memnum = memnum;
		this.loginday = loginday;
		this.id = id;
		this.name = name;
	}
	
	

}
