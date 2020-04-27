package com.quest.bean;

public class QuestUser {

	private int employeeId;
	private String name = "";
	private String lg = "";
	public QuestUser(int employeeId, String name, String lg) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.lg = lg;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLg() {
		return lg;
	}
	public void setLg(String lg) {
		this.lg = lg;
	}
	@Override
	public String toString() {
		return "QuestUser [employeeId=" + employeeId + ", name=" + name + ", lg=" + lg + "]";
	}
	
}
