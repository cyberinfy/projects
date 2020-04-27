package com.quest.service;

import java.util.ArrayList;

import com.quest.bean.QuestAdmin;
import com.quest.dao.QuestAdminDAO;

public class QuestAdminService {
	private QuestAdminDAO questAdminDAO = null;

	public QuestAdminService() {
		this.questAdminDAO = new QuestAdminDAO();
	}  
	
	public int validUser(QuestAdmin questAdmin) {
		return this.questAdminDAO.validUser(questAdmin);
	}
	
	public int performUpdate(QuestAdmin questAdmin) {
		return this.questAdminDAO.performUpdate(questAdmin);
	}
	
	public int performInsert(QuestAdmin questAdmin){
		return this.questAdminDAO.performInsert(questAdmin);
	}
	
	public int performDelete(QuestAdmin questAdmin) {
		return this.questAdminDAO.performDelete(questAdmin);
	}
	
	public ArrayList<String> retrieveAll(){
		return this.questAdminDAO.retriveAll();
	}
	
	
}
