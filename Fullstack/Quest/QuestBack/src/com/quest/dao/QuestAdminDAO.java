package com.quest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.quest.bean.QuestAdmin;
import com.quest.util.DBUtil;

import oracle.net.aso.q;

public class QuestAdminDAO {
	private DBUtil dbUtil = null; 
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public QuestAdminDAO() {
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

	
	public int performInsert( QuestAdmin questAdmin) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("insert into "+this.dbUtil.getTableAdmin()+" values(?,?)");
			this.preparedStatement.setInt(1, questAdmin.getEmployeeId());
			this.preparedStatement.setString(2, questAdmin.getPassword());
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
	
	public int performUpdate( QuestAdmin questAdmin ) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("update "+this.dbUtil.getTableAdmin()+" set password=\'"+questAdmin.getPassword()+"\' where employeeid="+questAdmin.getEmployeeId());
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
	
	public int performDelete( QuestAdmin questAdmin ) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			System.out.println("delete from "+this.dbUtil.getTableAdmin()+" where employeeid="+questAdmin.getEmployeeId());
			this.preparedStatement = this.connection.prepareStatement("delete from "+this.dbUtil.getTableAdmin()+" where employeeid="+questAdmin.getEmployeeId());
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
	
	public int validUser(QuestAdmin questAdmin) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("select * from "+this.dbUtil.getTableAdmin()+"  where employeeid="+questAdmin.getEmployeeId()+" and password=\'"+questAdmin.getPassword()+"\'");
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
	
	public ArrayList<String> retriveAll() {
		ArrayList<String> res = new ArrayList<String>();
		try{
			this.connection = this.dbUtil.getConnection();
			try {
				this.preparedStatement = this.connection.prepareStatement("select * from "+this.dbUtil.getTableAdmin());
				this.resultSet = this.preparedStatement.executeQuery();
				while(this.resultSet.next()){
				res.add(this.resultSet.getInt(1)+"");
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
