package com.quest.bean;

public class QuestCategory {

	private String categoryName = "";

	public QuestCategory(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "QuestCategory [categoryName=" + categoryName + "]";
	}
	
}
