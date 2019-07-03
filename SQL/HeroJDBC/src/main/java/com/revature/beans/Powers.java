package com.revature.beans;

public class Powers {
	private int powersID;
	private String powersName;
	public Powers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Powers(int powersID, String powersName) {
		super();
		this.powersID = powersID;
		this.powersName = powersName;
	}
	public int getPowersID() {
		return powersID;
	}
	public void setPowersID(int powersID) {
		this.powersID = powersID;
	}
	public String getPowersName() {
		return powersName;
	}
	public void setPowersName(String powersName) {
		this.powersName = powersName;
	}
	@Override
	public String toString() {
		return "Powers [powersID=" + powersID + ", powersName=" + powersName + "]";
	}
	
}
