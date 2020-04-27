package com.quest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.quest.bean.QuestCategory;
import com.quest.util.DBUtil;

public class QuestCategoriesDAO {

	private DBUtil dbUtil = null; 
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public QuestCategoriesDAO() {
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
	
	public int performInsert(QuestCategory questCategory) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("insert into "+this.dbUtil.getTableCategories()+" values(?)");
			this.preparedStatement.setString(1, questCategory.getCategoryName());
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
	
	public int performDelete(QuestCategory questCategory) {
		int res = -1;
		try {
			this.connection = this.dbUtil.getConnection();
			this.preparedStatement = this.connection.prepareStatement("delete from "+this.dbUtil.getTableCategories()+" where categoryname=\'"+questCategory.getCategoryName()+"\'");
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
	
	
	public ArrayList<String> retriveAll() {
		ArrayList<String> res = new ArrayList<String>();
		try{
			this.connection = this.dbUtil.getConnection();
			try {
				this.preparedStatement = this.connection.prepareStatement("select * from "+this.dbUtil.getTableCategories());
				this.resultSet = this.preparedStatement.executeQuery();
				while(this.resultSet.next()){
				res.add(this.resultSet.getString(1)+"");
				System.out.println(this.resultSet.getString(1));
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
