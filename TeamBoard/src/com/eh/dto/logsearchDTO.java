package com.eh.dto;

import java.io.Serializable;

public class logsearchDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String logtime;
	
	public logsearchDTO() {
		// TODO Auto-generated constructor stub
	}

	public logsearchDTO(String id, String name, String logtime) {
		super();
		this.id = id;
		this.name = name;
		this.logtime = logtime;
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

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	
	
	
}
