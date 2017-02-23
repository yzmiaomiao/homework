package com.mercury.entity;

import java.util.Date;

public class Test {

	private int id;// 主键
	private String name;
	private Date gmt_modified;

	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGmtModified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getGmtModified() {
		return gmt_modified;
	}
	
}