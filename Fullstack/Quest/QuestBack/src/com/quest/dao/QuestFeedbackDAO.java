package com.quest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.quest.bean.QuestFeedback;
import com.quest.util.DBUtil;

public class QuestFeedbackDAO {

	private DBUtil dbUtil = null; 
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public QuestFeedbackDAO() {
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

	public int performInsert(QuestFeedback questFeedback) {
		int res = -1;
		try{
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("insert into "+this.dbUtil.getTableFeedback()+" values(?,?,?)");
			this.preparedStatement.setInt(1, questFeedback.getEmployeeid());
			this.preparedStatement.setString(2, questFeedback.getStream());
			this.preparedStatement.setString(3, questFeedback.getFeedback());
			res = this.preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.dbClose();
		}
		return res;
	}
	
	public ArrayList<QuestFeedback> performRetrieval() {
		ArrayList<QuestFeedback> list =  new ArrayList<>();
		try{
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("select * from "+this.dbUtil.getTableFeedback());
			this.resultSet = this.preparedStatement.executeQuery();
			while(this.resultSet.next()){
				list.add(new QuestFeedback(this.resultSet.getInt(1),
						this.resultSet.getString(3),
						this.resultSet.getString(2)));
			}
			System.out.println(list.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.dbClose();
		}
		return list;
	}
}
