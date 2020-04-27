package com.quest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.quest.bean.QuestUserStatistics;
import com.quest.util.DBUtil;

public class QuestUserStatisticsDAO {
	private DBUtil dbUtil = null; 
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public QuestUserStatisticsDAO() {
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
	public int performInsert(QuestUserStatistics questUserStatistics) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("insert into "+this.dbUtil.getTableUserStatistics()+" values(?,?,?)");
			this.preparedStatement.setInt(1, questUserStatistics.getEmployeeId());
			this.preparedStatement.setInt(2, questUserStatistics.getQuestions());
			this.preparedStatement.setInt(3, questUserStatistics.getSolutions());
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
}
