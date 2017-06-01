package com.eduportal.model;

import java.io.Serializable;
public class NoticeInfo implements Serializable {
	
	private int id;
	private String batch;
	private String msg;
	private String fileloc;
	
	
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getFileloc() {
		return fileloc;
	}
	public void setFileloc(String fileloc) {
		this.fileloc = fileloc;
	}
	
	

}
