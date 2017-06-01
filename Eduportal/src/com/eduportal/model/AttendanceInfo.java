package com.eduportal.model;

public class AttendanceInfo {
	public String sid;
	public String fid;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String sname;
	public float atn;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public float getAtn() {
		return atn;
	}
	public void setAtn(float atn) {
		this.atn = atn;
	}
	

}
