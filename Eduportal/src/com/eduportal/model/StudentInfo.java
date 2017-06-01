package com.eduportal.model;

import java.io.Serializable;
public class StudentInfo implements Serializable {
	
	private String id;
	private String fname;
	private String lname;
	private String uname;
	private String pass;
	private String dob;
	private String gender;
	private String mob;
	private String stream;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
		setName();
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEscore() {
		return escore;
	}
	public void setEscore(int escore) {
		this.escore = escore;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	private String permaddr;
	private String presentaddr;
	private String resPh;
	
	public String getPermaddr() {
		return permaddr;
	}
	public void setPermaddr(String permaddr) {
		this.permaddr = permaddr;
	}
	public String getPresentaddr() {
		return presentaddr;
	}
	public void setPresentaddr(String presentaddr) {
		this.presentaddr = presentaddr;
	}
	public String getResPh() {
		return resPh;
	}
	public void setResPh(String resPh) {
		this.resPh = resPh;
	}
	/*private String Xschool;
	private String XIIschool;
	private String Xpersc;
	private String XIIpersc;
	private String college;
	
	private String cgpa;*/
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setName() {
		this.name = fname+ " "+lname ;
	}
	private String email;
	private int escore;
	private String batch;
	
}