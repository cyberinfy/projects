package com.quest.service;

import java.util.ArrayList;

import com.quest.bean.QuestAdmin;
import com.quest.bean.QuestUser;
import com.quest.dao.QuestUsersDAO;

public class QuestUsersService {

	private QuestUsersDAO questUsersDAO = null;

	public QuestUsersService() {
		this.questUsersDAO = new QuestUsersDAO();
	}
	
	public int performInsert(QuestUser questUser) {
		return this.questUsersDAO.performInsert(questUser);
	}
	
	public int performDelete(int employeeid){
		return this.questUsersDAO.performPreDelete(employeeid);
	}
	
	public ArrayList<QuestUser> retrieveAll() {
		return this.questUsersDAO.retriveAll();
	}

	public int validUser(String employeeid) {
		return this.questUsersDAO.validUser(employeeid);
	}
	
}
