package com.quest.bean;

import java.sql.Blob;

public class QuestQuestion {
	private int questionId;
	private String questionDescription = "";
	private String categoryName = "";
	private Blob screenShot = null;
	private int employeeId;
	public QuestQuestion(int questionId, String questionDescription, String categoryName, Blob screenShot,
			int employeeId) {
		super();
		this.questionId = questionId;
		this.questionDescription = questionDescription;
		this.categoryName = categoryName;
		this.screenShot = screenShot;
		this.employeeId = employeeId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Blob getScreenShot() {
		return screenShot;
	}
	public void setScreenShot(Blob screenShot) {
		this.screenShot = screenShot;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "QuestQuestion [questionId=" + questionId + ", questionDescription=" + questionDescription
				+ ", categoryName=" + categoryName + ", screenShot=" + screenShot + ", employeeId=" + employeeId + "]";
	}
	
}
