package com.quest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.quest.bean.QuestAdmin;
import com.quest.bean.QuestUser;
import com.quest.util.DBUtil;

public class QuestUsersDAO {
	private DBUtil dbUtil = null; 
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public QuestUsersDAO() {
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
	
	public int performInsert(QuestUser questUser) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("insert into "+this.dbUtil.getTableUsers()+" values(?,?,?)");
			this.preparedStatement.setInt(1, questUser.getEmployeeId());
			this.preparedStatement.setString(2, questUser.getName());
			this.preparedStatement.setString(3, questUser.getLg());
			res = this.preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.dbClose();
		}
		return performPostInsert(questUser);
		
	}
	
	public int performPostInsert(QuestUser questUser) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("insert into "+this.dbUtil.getTableUserStatistics()+" values(?,?,?)");
			this.preparedStatement.setInt(1, questUser.getEmployeeId());
			this.preparedStatement.setInt(2, 0);
			this.preparedStatement.setInt(3, 0);
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
	
	public int performDelete( int employeeid ) {

		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			System.out.println("delete from "+this.dbUtil.getTableUsers()+" where employeeid="+employeeid);
			this.preparedStatement = this.connection.prepareStatement("delete from "+this.dbUtil.getTableUsers()+" where employeeid="+employeeid);
			res = this.preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.dbClose();
		}
		System.out.println(res);
		return res;
	}
	
	public int performPreDelete( int employeeid ) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("delete from "+this.dbUtil.getTableUserStatistics()+" where employeeid="+employeeid);
			res = this.preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.dbClose();
		}
		return performDelete(employeeid);
	}
	
	public int validUser(String employeeid) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("select * from "+this.dbUtil.getTableUsers()+"  where employeeid="+employeeid);
			this.resultSet = this.preparedStatement.executeQuery();
			if(this.resultSet.next()) res = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.dbClose();
		}
		return res;
	}
	
	public ArrayList<QuestUser> retriveAll() {
		ArrayList<QuestUser> res = new ArrayList<QuestUser>();
		try{
			this.connection = this.dbUtil.getConnection();
			try {
				this.preparedStatement = this.connection.prepareStatement("select * from "+this.dbUtil.getTableUsers());
				this.resultSet = this.preparedStatement.executeQuery();
				while(this.resultSet.next()){
				res.add(
						new QuestUser(
								this.resultSet.getInt(1),
								this.resultSet.getString(2),
								this.resultSet.getString(3)
								)
						);
				
				System.out.println(this.resultSet.getInt(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		finally{
			this.dbClose();
		}
		return res;
	}

}
