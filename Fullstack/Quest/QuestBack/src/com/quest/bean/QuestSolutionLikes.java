package com.quest.bean;

public class QuestSolutionLikes {
	private int solutionId;
	private int employeeId;
	public QuestSolutionLikes(int solutionId, int employeeId) {
		super();
		this.solutionId = solutionId;
		this.employeeId = employeeId;
	}
	public int getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(int solutionId) {
		this.solutionId = solutionId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "QuestSolutionLikes [solutionId=" + solutionId + ", employeeId=" + employeeId + "]";
	}
	
}
