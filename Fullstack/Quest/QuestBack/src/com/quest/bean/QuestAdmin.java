package com.quest.bean;

public class QuestAdmin {

	private int employeeId;
	private String password = "";
	public QuestAdmin(int employeeId, String password) {
		super();
		this.employeeId = employeeId;
		this.password = password;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "QuestAdmin [employeeId=" + employeeId + ", password=" + password + "]";
	}
	
}
