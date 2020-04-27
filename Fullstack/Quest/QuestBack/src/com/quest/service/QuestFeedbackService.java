package com.quest.service;

import java.util.ArrayList;

import com.quest.bean.QuestFeedback;
import com.quest.dao.QuestFeedbackDAO;

public class QuestFeedbackService {

	private QuestFeedbackDAO questFeedbackDAO = null;

	public QuestFeedbackService() {
		this.questFeedbackDAO = new QuestFeedbackDAO();
	}
	public ArrayList<QuestFeedback> performRetrieval(){
		return this.questFeedbackDAO.performRetrieval();
	}
	public int performInsert(QuestFeedback questFeedback){
		return this.questFeedbackDAO.performInsert(questFeedback);
	}
	
}
