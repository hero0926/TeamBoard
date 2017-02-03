package com.yu.dto;

import java.io.Serializable;

public class tmemberDTO implements Serializable{
	private int memnum;
	private String id;
	private String name;
	private String pw;
	private String regday;
	private String status;
	
	
	public int getMemnum() {
		return memnum;
	}
	public void setMemnum(int memnum) {
		this.memnum = memnum;
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getRegday() {
		return regday;
	}
	public void setRegday(String regday) {
		this.regday = regday;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + memnum;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		tmemberDTO other = (tmemberDTO) obj;
		if (memnum != other.memnum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "tmemberDTO [memnum=" + memnum + ", id=" + id + ", name=" + name + ", pw=" + pw + ", regday=" + regday
				+ ", status=" + status + "]";
	}
	
	
	public tmemberDTO() {
		// TODO Auto-generated constructor stub
	}
	public tmemberDTO(int memnum, String id, String name, String pw, String regday, String status) {
		super();
		this.memnum = memnum;
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.regday = regday;
		this.status = status;
	}
	
}