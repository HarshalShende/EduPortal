package com.eduportal.model;

import java.io.Serializable;


public class QueryMsgInfo implements Serializable {
	
	private String sndrName;
	private String sndrMail;
	private String sndrMsg;
	public String getSndrName() {
		return sndrName;
	}
	public void setSndrName(String sndrName) {
		this.sndrName = sndrName;
	}
	public String getSndrMail() {
		return sndrMail;
	}
	public void setSndrMail(String sndrMail) {
		this.sndrMail = sndrMail;
	}
	public String getSndrMsg() {
		return sndrMsg;
	}
	public void setSndrMsg(String sndrMsg2) {
		this.sndrMsg = sndrMsg2;
	}

}
