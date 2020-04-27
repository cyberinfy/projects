package com.quest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.quest.bean.QuestSolutions;
import com.quest.util.DBUtil;

public class QuestSolutionsDAO {
	private DBUtil dbUtil = null; 
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public QuestSolutionsDAO() {
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
	public int performInsert(QuestSolutions questSolution) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("insert into "+this.dbUtil.getTableSolutions()+" values(?,"+this.dbUtil.getSequenceSolutionId()+",?,?)");
			this.preparedStatement.setInt(1, questSolution.getQuestionId());
			this.preparedStatement.setString(3, questSolution.getSolutionDescription());
			this.preparedStatement.setInt(4, questSolution.getEmployeeId());
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
	
	public ArrayList<QuestSolutions> getSolutions(int questionid){
		ArrayList<QuestSolutions> resList = new ArrayList<QuestSolutions>();
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("select * from "+this.dbUtil.getTableSolutions()+" where questionid="+questionid);
			this.resultSet = this.preparedStatement.executeQuery();
			while(this.resultSet.next()) {
				QuestSolutions questSolution = new QuestSolutions(this.resultSet.getInt(1),this.resultSet.getInt(2),this.resultSet.getString(3),this.resultSet.getInt(5));
				resList.add(questSolution);
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
