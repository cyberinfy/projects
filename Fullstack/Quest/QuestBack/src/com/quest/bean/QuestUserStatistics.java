package com.quest.bean;

public class QuestUserStatistics {

	private int employeeId;
	private int questions;
	private int solutions;
	public QuestUserStatistics(int employeeId, int questions, int solutions) {
		super();
		this.employeeId = employeeId;
		this.questions = questions;
		this.solutions = solutions;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getQuestions() {
		return questions;
	}
	public void setQuestions(int questions) {
		this.questions = questions;
	}
	public int getSolutions() {
		return solutions;
	}
	public void setSolutions(int solutions) {
		this.solutions = solutions;
	}
	@Override
	public String toString() {
		return "QuestUserStatistics [employeeId=" + employeeId + ", questions=" + questions + ", solutions=" + solutions
				+ "]";
	}
	
}
