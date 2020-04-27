package com.quest.service;

import java.util.ArrayList;

import com.quest.bean.QuestCategory;
import com.quest.dao.QuestCategoriesDAO;

public class QuestCategoriesService {

	QuestCategoriesDAO questCategoriesDAO = null;

	public QuestCategoriesService() {
		this.questCategoriesDAO = new QuestCategoriesDAO();
		
	}
	
	public int performInsert(QuestCategory questCategory) {
		return this.questCategoriesDAO.performInsert(questCategory);
	}

	public int performDelete(QuestCategory questCategory) {
		// TODO Auto-generated method stub
		return this.questCategoriesDAO.performDelete(questCategory);
	}
	
	public ArrayList<String> retrieveAll() {
		return this.questCategoriesDAO.retriveAll();
	}
}
