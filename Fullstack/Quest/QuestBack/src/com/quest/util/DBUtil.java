package com.quest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private Connection connection = null;
	private String url = "";
	private String user = "";
	private String password = "";
	private String tableAdmin = "";
	private String tableUsers = "";
	private String tableCategories = "";
	private String tableUserStatistics = "";
	private String tableQuestions = "";
	private String tableSolutions = "";
	private String tableSolutionLikes = "";
	private String tableSolutionDislikes = "";
	private String tableFeedback = "";
	private String sequenceQuestionId = "";
	private String sequenceSolutionId = "";
	public DBUtil() {
		this.url = "jdbc:oracle:thin:@192.168.0.4:1521:xe";
		this.user = "MJAG28";
		this.password = "MJAG28";
		this.tableAdmin = "questadmin";
		this.tableUsers = "questusers";
		this.tableCategories = "questcategories";
		this.tableUserStatistics = "questuserstatistics";
		this.tableQuestions = "questquestions";
		this.tableSolutions = "questsolutions";
		this.tableSolutionLikes = "questsolutionlikes";
		this.tableSolutionDislikes = "questsolutiondislikes";
		this.setTableFeedback("questfeedback");
		this.sequenceQuestionId = "get_question_id.nextval";
		this.sequenceSolutionId = "get_solution_id.nextval";
		
	}
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.connection = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTableAdmin() {
		return tableAdmin;
	}
	public void setTableAdmin(String tableAdmin) {
		this.tableAdmin = tableAdmin;
	}
	public String getTableUsers() {
		return tableUsers;
	}
	public void setTableUsers(String tableUsers) {
		this.tableUsers = tableUsers;
	}
	public String getTableCategories() {
		return tableCategories;
	}
	public void setTableCategories(String tableCategories) {
		this.tableCategories = tableCategories;
	}
	public String getTableUserStatistics() {
		return tableUserStatistics;
	}
	public void setTableUserStatistics(String tableUserStatistics) {
		this.tableUserStatistics = tableUserStatistics;
	}
	public String getTableQuestions() {
		return tableQuestions;
	}
	public void setTableQuestions(String tableQuestions) {
		this.tableQuestions = tableQuestions;
	}
	public String getTableSolutions() {
		return tableSolutions;
	}
	public void setTableSolutions(String tableSolutions) {
		this.tableSolutions = tableSolutions;
	}
	public String getTableSolutionLikes() {
		return tableSolutionLikes;
	}
	public void setTableSolutionLikes(String tableSolutionLikes) {
		this.tableSolutionLikes = tableSolutionLikes;
	}
	public String getTableSolutionDislikes() {
		return tableSolutionDislikes;
	}
	public void setTableSolutionDislikes(String tableSolutionDislikes) {
		this.tableSolutionDislikes = tableSolutionDislikes;
	}
	public String getSequenceQuestionId() {
		return sequenceQuestionId;
	}
	public void setSequenceQuestionId(String sequenceQuestionId) {
		this.sequenceQuestionId = sequenceQuestionId;
	}
	public String getSequenceSolutionId() {
		return sequenceSolutionId;
	}
	public void setSequenceSolutionId(String sequenceSolutionId) {
		this.sequenceSolutionId = sequenceSolutionId;
	}
	public String getTableFeedback() {
		return tableFeedback;
	}
	public void setTableFeedback(String tableFeedback) {
		this.tableFeedback = tableFeedback;
	}
	
	
}
