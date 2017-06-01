package com.eduportal.model;

import java.io.Serializable;
public class SubjectInfo implements Serializable{
	
	private String scode;
	private String sname;
	private String sem;
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}

}
