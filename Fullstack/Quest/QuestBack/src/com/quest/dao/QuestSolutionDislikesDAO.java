package com.quest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.quest.bean.QuestSolutionDislikes;
import com.quest.util.DBUtil;

public class QuestSolutionDislikesDAO {
	private DBUtil dbUtil = null; 
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public QuestSolutionDislikesDAO() {
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
	public int performInsert(QuestSolutionDislikes questSolutionDislikes) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("insert into "+this.dbUtil.getTableSolutionDislikes()+" values(?,?)");
			this.preparedStatement.setInt(1,questSolutionDislikes.getSolutionId());
			this.preparedStatement.setInt(2,questSolutionDislikes.getEmployeeId());
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
	public int performDelete(QuestSolutionDislikes questSolutionDislikes) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("delete from "+this.dbUtil.getTableSolutionDislikes()+" where solutionid=? and employeeid=?");
			this.preparedStatement.setInt(1,questSolutionDislikes.getSolutionId());
			this.preparedStatement.setInt(2,questSolutionDislikes.getEmployeeId());
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
