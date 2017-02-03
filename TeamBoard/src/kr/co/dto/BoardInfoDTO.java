package kr.co.dto;

import java.io.Serializable;

public class BoardInfoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int boardnum;
	private String title;
	private String repyn;
	
	public BoardInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public BoardInfoDTO(int boardnum, String title, String repyn) {
		super();
		this.boardnum = boardnum;
		this.title = title;
		this.repyn = repyn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardnum;
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
		BoardInfoDTO other = (BoardInfoDTO) obj;
		if (boardnum != other.boardnum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return boardnum + ":" + title;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRepyn() {
		return repyn;
	}

	public void setRepyn(String repyn) {
		this.repyn = repyn;
	}
	
	
	
	
}
