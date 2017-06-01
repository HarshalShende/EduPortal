package com.eduportal.model;

import java.io.Serializable;
public class AssignmentSubmissionInfo implements Serializable{
	
	private int ano;
	private String sid;
	private String fid;
	private String fileloc;
	private String date;
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFileloc() {
		return fileloc;
	}
	public void setFileloc(String fileloc) {
		this.fileloc = fileloc;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}
