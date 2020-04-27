package com.quest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.quest.bean.QuestQuestion;
import com.quest.util.DBUtil;

public class QuestQuestionsDAO {
	private DBUtil dbUtil = null; 
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public QuestQuestionsDAO() {
		this.dbUtil = new DBUtil();
	} 
	private void dbClose() {
		if(this.resultSet != null) {
			try {
				this.resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(this.preparedStatement != null) {
			try {
				this.preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int performInsert(QuestQuestion questQuestion) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("insert into "+this.dbUtil.getTableQuestions()+" values("+this.dbUtil.getSequenceQuestionId()+"?,?,?,?)" );
			this.preparedStatement.setString(1, questQuestion.getQuestionDescription());
			this.preparedStatement.setString(2, questQuestion.getCategoryName());
			this.preparedStatement.setBlob(3, questQuestion.getScreenShot());
			this.preparedStatement.setInt(4, questQuestion.getEmployeeId());
			res = this.preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.dbClose();
		}
		return res;
	}
	public int performUpdate(QuestQuestion questQuestion) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("update "+this.dbUtil.getTableQuestions()+" set questiondescription=?, categoryname=?, screenshot=?, employeeid=? where questionid="+questQuestion.getQuestionId());
			this.preparedStatement.setString(1, questQuestion.getQuestionDescription());
			this.preparedStatement.setString(2, questQuestion.getCategoryName());
			this.preparedStatement.setBlob(3, questQuestion.getScreenShot());
			this.preparedStatement.setInt(4, questQuestion.getEmployeeId());
			res = this.preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.dbClose();
		}
		return res;
	}
	public int performDelete(QuestQuestion questQuestion) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			try {
				this.preparedStatement = this.connection.prepareStatement("delete from "+this.dbUtil.getTableQuestions()+" where questionid="+questQuestion.getQuestionId());
				res = this.preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		finally {
			this.dbClose();
		}
		return res;
	}
	
	public ArrayList<QuestQuestion> getQuestions(){
		ArrayList<QuestQuestion> resList = new ArrayList<QuestQuestion>();
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("select * from "+this.dbUtil.getTableQuestions());
			this.resultSet = this.preparedStatement.executeQuery();
			while(this.resultSet.next()) {
				QuestQuestion questQuestion = new QuestQuestion(this.resultSet.getInt(1),this.resultSet.getString(2),this.resultSet.getString(3),this.resultSet.getBlob(4),this.resultSet.getInt(5));
				resList.add(questQuestion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.dbClose();
		}
		
		return resList;
	}
}
