package com.quest.bean;

public class QuestFeedback {

	private int employeeid;
	private String feedback;
	private String stream;
	public QuestFeedback(int employeeid, String feedback, String stream) {
		super();
		this.employeeid = employeeid;
		this.feedback = feedback;
		this.stream = stream;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	@Override
	public String toString() {
		return "QuestFeedback [employeeid=" + employeeid + ", feedback="
				+ feedback + ", stream=" + stream + "]";
	}
	
}
