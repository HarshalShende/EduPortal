package com.eduportal.model;

import java.io.Serializable;
public class FacultyInfo implements Serializable {
	
	private String id;
	private String fname;
	private String lname;
	private String uname;
	private String pass;
	private String dob;
	private String gender;
	private String permaddr;
	private String presentaddr;
	private String resPh;
	private String mob;
	private String name;
	private String email;
	private String subject;
	private String qual;
	private String college;
	
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
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getName() {
		return name;
	}
	public void setName() {
		this.name = fname+" "+lname;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	

}
