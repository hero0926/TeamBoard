package kr.co.dto;

import java.io.Serializable;

public class BoardDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int num;
	private String author;
	private String title;
	private String content;
	private String writeday;
	private int readcnt;
	private int reproot;
	private int repstep;
	private int repindent;
	private int boardnum;
	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public BoardDTO(int num, String author, String title, String content, String writeday, int readcnt, int reproot,
			int repstep, int repindent, int boardnum) {
		super();
		this.num = num;
		this.author = author;
		this.title = title;
		this.content = content;
		this.writeday = writeday;
		this.readcnt = readcnt;
		this.reproot = reproot;
		this.repstep = repstep;
		this.repindent = repindent;
		this.boardnum = boardnum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getReproot() {
		return reproot;
	}

	public void setReproot(int reproot) {
		this.reproot = reproot;
	}

	public int getRepstep() {
		return repstep;
	}

	public void setRepstep(int repstep) {
		this.repstep = repstep;
	}

	public int getRepindent() {
		return repindent;
	}

	public void setRepindent(int repindent) {
		this.repindent = repindent;
	}
	public int getBoardnum() {
		return boardnum;
	}

	public void seBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
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
		BoardDTO other = (BoardDTO) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardDTO [title=" + title + "]";
	}
	
	
	

}
