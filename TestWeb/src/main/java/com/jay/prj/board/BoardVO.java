package com.jay.prj.board;

public class BoardVO {

	private String id;
	private String title;
	private String content;
	private String writer;
	private String rDate;
	private String hit;
	
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
}
