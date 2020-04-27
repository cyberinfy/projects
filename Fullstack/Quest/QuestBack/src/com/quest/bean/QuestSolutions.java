package com.quest.bean;

public class QuestSolutions {
	private int questionId;
	private int solutionId;
	private String solutionDescription="";
	private int employeeId;
	public QuestSolutions(int questionId, int solutionId, String solutionDescription, int employeeId) {
		super();
		this.questionId = questionId;
		this.solutionId = solutionId;
		this.solutionDescription = solutionDescription;
		this.employeeId = employeeId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(int solutionId) {
		this.solutionId = solutionId;
	}
	public String getSolutionDescription() {
		return solutionDescription;
	}
	public void setSolutionDescription(String solutionDescription) {
		this.solutionDescription = solutionDescription;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
}
